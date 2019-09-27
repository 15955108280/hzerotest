package org.hzero.test1.app.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.*;
import org.hzero.test1.domain.repository.*;
import org.hzero.test1.domain.service.HeaderDoMainService;
import org.hzero.test1.domain.service.LineItemDoMainService;
import org.hzero.test1.domain.service.LineSupplierDoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import static org.hzero.test1.infra.constant.Instance.*;

/**
 * description
 *
 * @author YXP 2019/08/26 15:12
 */
@Service
public class RfxServiceImpl implements RfxService {

    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    LineItemDoMainService lineItemDoMainService;
    @Autowired
    HeaderDoMainService headerDoMainService;
    @Autowired
    RfxRepository rfxRepository;
    @Autowired
    LineSupplierRepository lineSupplierRepository;
    @Autowired
    QuotationHeaderRepository quotationHeaderRepository;
    @Autowired
    ItemSupAssignRepository itemSupAssignRepository;
    @Autowired
    QuotationLineRepository quotationLineRepository;
    @Autowired
    CodeRuleBuilder codeRuleBuilder;
    @Autowired
    LineSupplierDoMainService lineSupplierDoMainService;

    public LineSupplier checkRfx(Header header, Long supplierCompanyId) {
        Assert.notNull(header, ERROR_HEADER_NOT_FOUND);
        Assert.isTrue(header.getQuotationStartDate() != null
                        && header.getQuotationStartDate().compareTo(new Date()) < 0, ERROR_TIME_IS_NOT_ALLOWED);
        // 结束时间小于当前时间
        Assert.isTrue(header.getQuotationEndDate() != null && header.getQuotationEndDate().compareTo(new Date()) > 0,
                        ERROR_TIME_IS_NOT_ALLOWED);
        // 供应商是否已存在
        LineSupplier lineSupplier = lineSupplierRepository
                        .selectOne(new LineSupplier(header.getTenantId(), supplierCompanyId, header.getRfxHeaderId()));
        Assert.notNull(lineSupplier, ERROR_SUPPLIER_NOT_FOUND);
        //判断反馈状态
        Assert.isTrue(StringUtils.equals("NEW", lineSupplier.getFeedbackStatus()),
                        ERROR_SUPPLIER_IS_PARTICIPATED_OR_ABANDONED);
        return lineSupplier;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createLineItem(RfxDTO rfxDTO, Long tenantId) {
        rfxDTO.getHeader().setTenantId(tenantId);
        Long rfxHeaderId = headerRepository.insertGetId(rfxDTO.getHeader());
        List<LineItem> lineItemList = rfxDTO.getLineItem();
        for (LineItem lineItem : lineItemList) {
            lineItem.setRfxHeaderId(rfxHeaderId);
            lineItem.setTenantId(tenantId);
        }
        lineItemRepository.batchInsert(lineItemList);
    }

    @Override
    public LineItem updateLineItem(Long tenantId, Long rfxLineItemId, String itemRemark, String itemName) {
        Assert.isTrue(lineItemDoMainService.lineItemIsNull(tenantId, rfxLineItemId), ERROR_LINEITEM_NOT_FOUND);
        LineItem lineItem = new LineItem(rfxLineItemId, itemRemark, itemName);
        //获取版本号
        LineItem oldLineItem = lineItemRepository.selectByPrimaryKey(lineItem);
        lineItem.setObjectVersionNumber(oldLineItem.getObjectVersionNumber());
        lineItemRepository.updateByPrimaryKeySelective(lineItem);
        return lineItemRepository.selectByPrimaryKey(lineItem);
    }

    @Override
    public Page<RfxSummaryDTO> listLineItem(PageRequest pageRequest, QueryDTO queryDTO, Long tenantId) {
        queryDTO.setTenantId(tenantId);
        return rfxRepository.listLineItem(pageRequest, queryDTO);
    }

    @Override
    public Header publishRfx(Long tenantId, Long rfxHeaderId) {
        Header header = headerRepository.selectOne(new Header(tenantId, rfxHeaderId));
        //判断订单头是否存在
        Assert.notNull(header, ERROR_HEADER_NOT_FOUND);
        //判断订单行是否存在
        Assert.isTrue(headerDoMainService.lineItemIsNull(tenantId, rfxHeaderId), ERROR_LINEITEM_IN_HEADER_NOT_FOUND);
        //判断开始时间是否到达
        Assert.isTrue(header.getQuotationStartDate() != null
                        && header.getQuotationStartDate().compareTo(new Date()) < 0, ERROR_TIME_IS_NOT_ALLOWED);
        header.setRfxStatus("IN_QUOTATION");
        headerRepository.updateByPrimaryKeySelective(header);
        return headerRepository.selectByPrimaryKey(header);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public QuotationHeader participateRfx(Long tenantId, Long supplierCompanyId, Long rfxHeaderId, Long rfxLineItemId) {
        Header header = headerRepository.selectOne(new Header(tenantId, rfxHeaderId));
        LineSupplier lineSupplier = checkRfx(header, supplierCompanyId);
        QuotationHeader quotationHeader = new QuotationHeader(header, tenantId, lineSupplier.getSupplierCompanyName());
        // 设置流水号
        quotationHeader.setQuotationNum(
                        codeRuleBuilder.generateCode(tenantId, "HZERO.SRM.QUOTATION.NUMBER", "GLOBAL", "GLOBAL", null));
        quotationHeaderRepository.insertSelective(quotationHeader);
        QuotationLine quotationLine = new QuotationLine(quotationHeader.getQuotationHeaderId(), header.getTenantId(),
                        quotationHeader.getQuotationStatus(), rfxLineItemId, header.getRoundNumber(),
                        header.getTaxIncludedFlag());
        quotationLineRepository.insertSelective(quotationLine);
        lineSupplier.setReadFlag(1);
        lineSupplier.setFeedbackStatus("PARTICIPATED");
        lineSupplierRepository.updateByPrimaryKeySelective(lineSupplier);
        return quotationHeader;
    }

    @Override
    public LineSupplier abandonRfx(Long tenantId, Long supplierCompanyId, Long rfxHeaderId) {
        Header header = headerRepository.selectOne(new Header(tenantId, rfxHeaderId));
        LineSupplier lineSupplier = checkRfx(header, supplierCompanyId);
        lineSupplier.setFeedbackStatus("ABANDONED");
        lineSupplier.setReadFlag(1);
        return lineSupplier;
    }

    @Override
    public LineSupplier addSupplier(Long tenantId, Long rfxHeaderId, LineSupplier lineSupplier) {
        Assert.isTrue(!lineSupplierDoMainService.lineSupplierIsNull(tenantId, lineSupplier.getSupplierCompanyId(),
                        rfxHeaderId), ERROR_SUPPLIER_NOT_FOUND);
        lineSupplier.setFeedbackStatus("NEW");
        lineSupplier.setTenantId(tenantId);
        lineSupplier.setRfxHeaderId(rfxHeaderId);
        lineSupplierRepository.insert(lineSupplier);
        return lineSupplier;
    }
}
