package org.hzero.test1.app.service.impl;

import java.util.List;

import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.HeaderRepository;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.repository.RfxRepository;
import org.hzero.test1.domain.service.LineItemDoMainService;
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
    public void create(RfxDTO rfxDTO) {
        Long rfxHeaderId = headerRepository.insertGetId(rfxDTO.getHeader());
        List<LineItem> lineItemList = rfxDTO.getLineItem();
        for (LineItem lineItem : lineItemList) {
            lineItem.setRfxHeaderId(rfxHeaderId);
        }

        lineItemRepository.batchInsert(lineItemList);
    }
	@Override
    public LineItem  updateLineItem(Long tenantId,Long rfxLineItemId, String itemRemark, String itemName) {
        Assert.isTrue(lineItemDoMainService.lineItemIsNull(tenantId,rfxLineItemId),"该物料行信息不存在");
       	LineItem lineItem = new LineItem(rfxLineItemId,itemRemark,itemName);
        LineItem oldLineItem = lineItemRepository.selectByPrimaryKey(lineItem);
        lineItem.setObjectVersionNumber(oldLineItem.getObjectVersionNumber());
        lineItemRepository.updateByPrimaryKeySelective(lineItem);
        return lineItemRepository.selectByPrimaryKey(lineItem);
    }

    @Override
    public Page<RfxSummaryDTO> list(PageRequest pageRequest, QueryDTO queryDTO, Long tenantId) {
        queryDTO.setTenantId(tenantId);
        return rfxRepository.list(pageRequest,queryDTO);
    }
}
