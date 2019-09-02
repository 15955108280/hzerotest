package org.hzero.test1.infra.mapper;

import io.choerodon.mybatis.provider.special.SpecialProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.poi.ss.formula.functions.T;
import org.hzero.test1.domain.entity.LineItem;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * 询价单物料料⾏行行Mapper
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
public interface LineItemMapper extends BaseMapper<LineItem> {


	/**
	 * 获取租户id
	 * @param tenantId 租户id
	 * @return 租户id
	 */
	Long getTenantId(Long tenantId);
}
