package org.hzero.test1.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxBySupplierDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;

/**
 * description
 *
 * @author YXP 2019/08/26 13:02
 */
public interface RfxRepository {
	/**
	 * 查询询价单
	 * @param pageRequest 分页参数
	 * @param queryDTO 查询条件
	 * @return 分页查询结果
	 */
	Page<RfxSummaryDTO> listLineItem(PageRequest pageRequest, QueryDTO queryDTO);

	/**
	 *供应商查询询价单
	 * @param tenantId 供应商id
	 * @param  pageRequest 分页参数
	 * @return 询价单列表
	 */
	Page<RfxBySupplierDTO> listRfxBySupplier(Long tenantId,PageRequest pageRequest);
}
