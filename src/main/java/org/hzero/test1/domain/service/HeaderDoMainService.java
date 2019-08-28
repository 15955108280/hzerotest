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
	 * @param rfxheaderId 询价单头id
	 * @return 是否存在
	 */
	 Boolean headerIsNull(Long tenantId, Long rfxheaderId);
}
