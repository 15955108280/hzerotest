package org.hzero.test1.app.service.impl;

import org.hzero.test1.app.service.LineItemService;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.service.HeaderDoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 询价单物料行应用服务默认实现
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@Service
public class LineItemServiceImpl implements LineItemService {
	@Autowired
	LineItemRepository lineItemRepository;
	@Autowired
	HeaderDoMainService headerDoMainService;

	@Override
	public void deleteLineItem(Long tenantId, Long rfxHeaderId) {
		Assert.isTrue(headerDoMainService.headerIsNull(tenantId,rfxHeaderId),"该物料行信息不存在");
		LineItem lineItem = new LineItem(rfxHeaderId);
		lineItemRepository.delete(lineItem);
	}
}
