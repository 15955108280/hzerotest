package org.hzero.test1.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;

import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/26 13:19
 */
public interface RfxMapper  {
	List<RfxSummaryDTO> list(QueryDTO queryDTO);
}
