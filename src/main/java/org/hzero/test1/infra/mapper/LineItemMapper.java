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
	*@Description: 重写批量添加方法
	*@Param: [list]
	*@return: int
	*@Author: Xingpeng.Yang
	*@date: 2019/8/27
	*/
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "rfxLineItemId")
	@InsertProvider(type = SpecialProvider.class, method = "dynamicSql")
	int insertList(List<LineItem> list);
	
	/**
	*@Description: 获取租户id
	*@Param: [tenantId]
	*@return: java.lang.Long
	*@Author: Xingpeng.Yang
	*@date: 2019/8/27
	*/
	Long getTenantId(Long tenantId);
}
