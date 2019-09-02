package org.hzero.test1.infra.mapper;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxBySupplierDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;

import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/26 13:19
 */
public interface RfxMapper  {
	/**
	 * 获取询价单列表
	 * @param queryDTO 查询条件
	 * @return 询价单列表
	 */
	List<RfxSummaryDTO> list(QueryDTO queryDTO);

	/**
	 * 供应商获取询价单
	 * @param tenantId 供应商租户id
	 * @return 询价单列表
	 */
	List<RfxBySupplierDTO> listRfxBySupplier(Long tenantId);
}
