package org.hzero.test1.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.QueryDTO;
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
	Page<RfxSummaryDTO> list(PageRequest pageRequest, QueryDTO queryDTO);
}
