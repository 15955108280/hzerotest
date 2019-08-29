package org.hzero.test1.domain.service.impl;

import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.repository.HeaderRepository;
import org.hzero.test1.domain.service.HeaderDoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author YXP 2019/08/27 22:38
 */
@Service
public class HeaderDoMainServiceImpl implements HeaderDoMainService {
	@Autowired
	HeaderRepository headerRepository;
	@Override
	public Boolean headerIsNull(Long tenantId, Long rfxHeaderId) {
		Header header = new Header(tenantId, rfxHeaderId);
		return headerRepository.selectOne(header) != null;
	}
}
