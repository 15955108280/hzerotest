package org.hzero.test1.infra.mapper;

import io.choerodon.mybatis.provider.base.BaseInsertProvider;
import io.choerodon.mybatis.provider.special.SpecialProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.hzero.test1.domain.entity.Header;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * 询价单头表Mapper
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
public interface HeaderMapper extends BaseMapper<Header> {
	/**
	*@Description: 重写insert方法使其返回主键
	*@Param: [header]
	*@return: int
	*@Author: Xingpeng.Yang
	*@date: 2019/8/27
	*/
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "rfxHeaderId")
	@InsertProvider(type = BaseInsertProvider.class, method = "dynamicSql")
	int insert(Header header);
	
	/**
	*@Description: 新增头信息并返回id
	*@Param: [header]
	*@return: java.lang.Long
	*@Author: Xingpeng.Yang
	*@date: 2019/8/27
	*/
	Long insertGetId(Header header);
	/**
	 *
	 *
	 * @param null
	 * @author YXP 2019-08-27 17:00
	 * @return
	 */
	/**
	*@Description: 获取租户id
	*@Param: [tenantId]
	*@return: java.lang.Long
	*@Author: Xingpeng.Yang
	*@date: 2019/8/27
	*/
	Long getTenantId(Long tenantId);
}
