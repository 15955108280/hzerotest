package org.hzero.test1.app.service.impl;

import java.util.List;

import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.HeaderRepository;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.repository.RfxRepository;
import org.hzero.test1.domain.service.LineItemDoMainService;
import org.hzero.test1.infra.constant.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

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
    RfxRepository rfxRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createLineItem(RfxDTO rfxDTO,Long tenantId) {
        Header header = new Header(tenantId);
        Long rfxHeaderId = headerRepository.insertGetId(header);
        List<LineItem> lineItemList = rfxDTO.getLineItem();
        for (LineItem lineItem : lineItemList) {
            lineItem.setRfxHeaderId(rfxHeaderId);
            lineItem.setTenantId(tenantId);
        }
        lineItemRepository.batchInsert(lineItemList);
    }

    @Override
    public LineItem updateLineItem(Long tenantId, Long rfxLineItemId, String itemRemark, String itemName) {
        Assert.isTrue(lineItemDoMainService.lineItemIsNull(tenantId, rfxLineItemId), Instance.ERROR_LINEITEM_NOT_FOUND);
        LineItem lineItem = new LineItem(rfxLineItemId, itemRemark, itemName);
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
}
