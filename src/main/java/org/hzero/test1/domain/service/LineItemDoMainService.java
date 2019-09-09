package org.hzero.test1.domain.service;

/**
 * description
 *
 * @author YXP 2019/08/27 22:15
 */
public interface LineItemDoMainService {
    /**
     * 判断物料行是否为空
     * 
     * @param tenantId 租户id
     * @param rfxLineItemId 询价单头id
     * @return 询价单是否为空
     */
    Boolean lineItemIsNull(Long tenantId, Long rfxLineItemId);
}
