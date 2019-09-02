package org.hzero.test1.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.ItemSummaryDTO;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxBySupplierDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.domain.repository.RfxRepository;
import org.hzero.test1.infra.mapper.RfxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author YXP 2019/08/26 13:14
 */
@Component
public class RfxRepositoryImpl implements RfxRepository {
	@Autowired
	RfxMapper rfxMapper;
	@Override
	public Page<RfxSummaryDTO> listLineItem(PageRequest pageRequest, QueryDTO queryDTO) {
		return PageHelper.doPage(pageRequest,() -> rfxMapper.list(queryDTO));
	}

	@Override
	public Page<RfxBySupplierDTO> listRfxBySupplier(Long tenantId,PageRequest pageRequest) {
		return PageHelper.doPage(pageRequest,()->rfxMapper.listRfxBySupplier(tenantId));
	}
}
