package org.hzero.test1.app.service.impl;

import org.hzero.test1.app.service.ItemSupAssignService;
import org.hzero.test1.domain.entity.ItemSupAssign;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.repository.ItemSupAssignRepository;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.repository.QuotationLineRepository;
import org.hzero.test1.domain.service.HeaderDoMainService;
import org.hzero.test1.domain.service.LineItemDoMainService;
import org.hzero.test1.domain.service.LineSupplierDoMainService;
import org.hzero.test1.infra.constant.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

/**
 * 询价单物料-供应商分配关系表应用服务默认实现
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@Service
public class ItemSupAssignServiceImpl implements ItemSupAssignService {

    @Autowired
    ItemSupAssignRepository itemSupAssignRepository;
    @Autowired
    LineItemDoMainService lineItemDoMainService;
    @Autowired
    LineSupplierDoMainService lineSupplierDoMainService;
    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    QuotationLineRepository quotationLineRepository;
    @Autowired
    HeaderDoMainService headerDoMainService;

    @Override
    public List<ItemSupAssign> assignLineItem(List<ItemSupAssign> itemSupAssignList, Long tenantId) {
        // 判断供应商是否存在
        for (ItemSupAssign itemSupAssign : itemSupAssignList) {
            itemSupAssign.setTenantId(tenantId);
            ItemSupAssign newItemSupAssign =
                            itemSupAssignRepository.selectOne(new ItemSupAssign(itemSupAssign.getTenantId(),
                                            itemSupAssign.getRfxLineSupplierId(), itemSupAssign.getRfxHeaderId()));
            Assert.isNull(newItemSupAssign, Instance.ERROR_ITEM_SUP_ASSIGN_EXISTED);
            Assert.isTrue(lineSupplierDoMainService.lineSupplierIsNull(tenantId, itemSupAssign.getRfxLineSupplierId()),
                            Instance.ERROR_SUPPLIER_NOT_FOUND);
        }
        // 判断提供数量总和<=物料总和
        LineItem lineItem = lineItemRepository
                        .selectOne(new LineItem(tenantId, itemSupAssignList.get(0).getRfxLineItemId()));
        Assert.notNull(lineItem, Instance.ERROR_LINEITEM_NOT_FOUND);
        Assert.isTrue(headerDoMainService.headerIsNull(tenantId, itemSupAssignList.get(0).getRfxHeaderId()),
                        Instance.ERROR_HEADER_NOT_FOUND);
        QuotationLine queryQuotationLine = new QuotationLine();
        queryQuotationLine.setTenantId(tenantId);
        queryQuotationLine.setRfxLineItemId(itemSupAssignList.get(0).getRfxLineItemId());
        List<QuotationLine> quotationLineList = quotationLineRepository.select(queryQuotationLine);
        if (quotationLineList.size() > 0) {
            BigDecimal allottedQuantity;
            allottedQuantity = BigDecimal.valueOf(0);
            for (QuotationLine quotationLine : quotationLineList) {
                allottedQuantity = allottedQuantity.add(quotationLine.getAllottedQuantity()==null?BigDecimal.valueOf(0):quotationLine.getAllottedQuantity());
            }
            Assert.isTrue(lineItem.getRfxQuantity().compareTo(allottedQuantity) > 0, Instance.ERROR_QUANTITY_IS_ENOUGH);
        }
        itemSupAssignRepository.batchInsert(itemSupAssignList);
        return itemSupAssignList;
    }
}
