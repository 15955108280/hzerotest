package org.hzero.test1.domain.service.impl;

import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.service.LineItemDoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author YXP 2019/08/27 22:15
 */
@Service
public class LineItemDoMainServiceImpl implements LineItemDoMainService {

    @Autowired
    LineItemRepository lineItemRepository;


	@Override
	public Boolean lineItemIsNull(Long tenantId, Long rfxLineItemId) {
		LineItem lineItem = new LineItem(tenantId,rfxLineItemId);
		return lineItemRepository.selectOne(lineItem) != null;
	}
}
