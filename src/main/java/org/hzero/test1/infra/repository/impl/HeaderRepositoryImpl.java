package org.hzero.test1.infra.repository.impl;

import io.swagger.models.auth.In;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.repository.HeaderRepository;
import org.hzero.test1.infra.mapper.HeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 询价单头表 资源库实现
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@Component
public class HeaderRepositoryImpl extends BaseRepositoryImpl<Header> implements HeaderRepository {

	@Autowired
	HeaderMapper headerMapper;

	@Override
	public Long  insertGetId(Header header) {
		Long rfxHeaderId = Long.valueOf(headerMapper.insert(header));
		//headerMapper.insertGetId(header);
		return header.getRfxHeaderId();
	}

	@Override
	public Long getTenantId(Long tenantId) {
		return headerMapper.getTenantId(tenantId);
	}
}
