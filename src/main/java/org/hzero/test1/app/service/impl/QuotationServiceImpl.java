package org.hzero.test1.app.service.impl;

import org.hzero.test1.api.dto.SavePriceDTO;
import org.hzero.test1.api.dto.SubmitPriceDTO;
import org.hzero.test1.app.service.QuotationService;
import org.hzero.test1.domain.entity.ItemSupAssign;
import org.hzero.test1.domain.entity.LineSupplier;
import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.entity.QuotationRecord;
import org.hzero.test1.domain.repository.ItemSupAssignRepository;
import org.hzero.test1.domain.repository.LineSupplierRepository;
import org.hzero.test1.domain.repository.QuotationLineRepository;
import org.hzero.test1.domain.repository.QuotationRecordRepository;
import org.hzero.test1.domain.service.QuotationLineDoMainService;
import org.hzero.test1.infra.constant.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 14:13
 */
@Service
public class QuotationServiceImpl implements QuotationService {
    @Autowired
    QuotationLineRepository quotationLineRepository;
    @Autowired
    QuotationLineDoMainService quotationLineDoMainService;
    @Autowired
    QuotationRecordRepository quotationRecordRepository;
    @Autowired
    ItemSupAssignRepository itemSupAssignRepository;
    @Autowired
    LineSupplierRepository lineSupplierRepository;

    @Override
    public QuotationLine saveQuotation(Long tenantId, SavePriceDTO savePriceDTO) {
        QuotationLine quotationLine = new QuotationLine(tenantId, savePriceDTO);
        QuotationLine queryQuotationLine =
                        quotationLineRepository.selectVersionNumber(tenantId, savePriceDTO.getQuotationLineId());
        Assert.notNull(queryQuotationLine, Instance.ERROR_QUOTATION_LINE_NOT_FOUND);
        quotationLine.setObjectVersionNumber(queryQuotationLine.getObjectVersionNumber());
        quotationLineRepository.updateByPrimaryKeySelective(quotationLine);
        return quotationLine;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public QuotationLine submitQuotation(Long tenantId, Long supplierCompanyId, SubmitPriceDTO submitPriceDTO) {
        //判断是否存在报检单行
        QuotationLine quotationLine =
                        quotationLineRepository.selectQuotationLine(tenantId, submitPriceDTO.getQuotationLineId());
        Assert.notNull(quotationLine, Instance.ERROR_QUOTATION_LINE_NOT_FOUND);
        //判断是否存在供应商
        LineSupplier lineSupplier = lineSupplierRepository
                        .selectOne(new LineSupplier(tenantId, supplierCompanyId, submitPriceDTO.getRfxHeaderId()));
        Assert.notNull(lineSupplier, Instance.ERROR_SUPPLIER_NOT_FOUND);
        //根据查出来的订单行和供应商数据判断是否已分配
        ItemSupAssign itemSupAssign = itemSupAssignRepository.selectOne(new ItemSupAssign(quotationLine.getTenantId(),
                        quotationLine.getRfxLineItemId(), lineSupplier.getRfxLineSupplierId()));
        Assert.notNull(itemSupAssign, Instance.ERROR_ITEM_SUP_ASSIGN_NOT_FOUND);
        Assert.isTrue(submitPriceDTO.getValidQuotationPrice().compareTo(itemSupAssign.getMinLimitPrice()) > 0
                        || submitPriceDTO.getValidQuotationPrice().compareTo(itemSupAssign.getMaxLimitPrice()) < 0,
                        Instance.ERROR_PRICE_NOT_ALLOWED);
        //更新订单行
        QuotationLine insertQuotationLine = new QuotationLine(tenantId, submitPriceDTO);
        insertQuotationLine.setObjectVersionNumber(quotationLine.getObjectVersionNumber());
        insertQuotationLine.setCurrentQuotedBy(null);
        insertQuotationLine.setCurrentQuotationQuantity(BigDecimal.valueOf(0));
        insertQuotationLine.setCurrentQuotationRemark(null);
        quotationLineRepository.updateByPrimaryKeySelective(insertQuotationLine);
        //插入报价记录
        QuotationRecord quotationRecord = new QuotationRecord(quotationLine);
        quotationRecordRepository.insert(quotationRecord);
        return quotationLine;
    }
}
