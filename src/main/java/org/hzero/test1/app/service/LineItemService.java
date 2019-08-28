package org.hzero.test1.app.service;

/**
 * 询价单物料料⾏行行应用服务
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
public interface LineItemService {
	/**
	 * 删除询价单无聊行
	 * @param tenantId 租户id
	 * @param rfxHeaderId 询价单行id
	 */
	void deleteLineItem(Long tenantId, Long rfxHeaderId);
}
