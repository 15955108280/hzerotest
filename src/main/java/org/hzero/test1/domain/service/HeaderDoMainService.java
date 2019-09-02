package org.hzero.test1.domain.service;

import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author YXP 2019/08/27 22:37
 */
@Service
public interface HeaderDoMainService {
	/**
	 * 判断订单头是否为空
	 * @param tenantId 租户id
	 * @param rfxHeaderId 询价单头id
	 * @return 是否存在
	 */
	 Boolean headerIsNull(Long tenantId, Long rfxHeaderId);

	/**
	 * 判断该询价单头下物料行是否为空
	 * @param tenantId 租户id
	 * @param rfxHeaderId 头id
	 * @return 是否存在
	 */
	 Boolean lineItemIsNull(Long tenantId, Long rfxHeaderId);
}
