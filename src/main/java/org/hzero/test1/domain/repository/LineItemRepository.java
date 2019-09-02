package org.hzero.test1.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.test1.domain.entity.LineItem;


/**
 * 询价单物料料⾏行行资源库
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
public interface LineItemRepository extends BaseRepository<LineItem> {


	/**
	 * 查询租户id
	 * @param tenantId 租户id
	 * @return 租户id
	 */
	Long getTenantId(Long tenantId);

}
