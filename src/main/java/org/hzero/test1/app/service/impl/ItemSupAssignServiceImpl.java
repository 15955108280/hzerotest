package org.hzero.test1.app.service.impl;

import org.hzero.test1.app.service.ItemSupAssignService;
import org.hzero.test1.domain.entity.ItemSupAssign;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.repository.ItemSupAssignRepository;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.repository.QuotationLineRepository;
import org.hzero.test1.domain.service.LineItemDoMainService;
import org.hzero.test1.domain.service.LineSupplierDoMainService;
import org.hzero.test1.infra.constant.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    @Override
    public ItemSupAssign assignLineItem(ItemSupAssign itemSupAssign) {
        Assert.isTrue(lineItemDoMainService.lineItemIsNull(itemSupAssign.getTenantId(),
                        itemSupAssign.getRfxLineItemId()), Instance.ERROR_LINEITEM_NOT_FOUND);
        // 判断供应商是否存在
        Assert.isTrue(lineSupplierDoMainService.lineSupplierIsNull(itemSupAssign.getTenantId(),
                        itemSupAssign.getRfxLineSupplierId()), Instance.ERROR_SUPPLIER_NOT_FOUND);
        // 判断提供数量总和<=物料总和
        LineItem lineItem = lineItemRepository
                        .selectOne(new LineItem(itemSupAssign.getTenantId(), itemSupAssign.getRfxLineItemId()));
        QuotationLine quotationLine = quotationLineRepository
                        .selectOne(new QuotationLine(itemSupAssign.getTenantId(), itemSupAssign.getRfxLineItemId()));
        Assert.isTrue(lineItem.getRfxQuantity().compareTo(quotationLine.getAllottedQuantity()) > -1,
                        Instance.ERROR_QUANTITY_IS_ENOUGH);
        itemSupAssignRepository.insert(itemSupAssign);
        return itemSupAssign;
    }
}
