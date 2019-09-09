package org.hzero.test1.domain.service;

import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/02 15:30
 */
@Service
public interface LineSupplierDoMainService {
    /**
     * 判断供应商是否已经存在
     * 
     * @param tenantId 租户id
     * @param supplierCompanyId 供应商租户id
     * @param rfxHeaderId 询价单头id
     * @return 是否存在
     */
    Boolean lineSupplierIsNull(Long tenantId, Long supplierCompanyId, Long rfxHeaderId);

    /**
     * 判断供应商是否已经存在
     *
     * @param tenantId 租户id
     * @param rfxLineSupplierId 供应商租户id
     * @return 是否存在
     */
    Boolean lineSupplierIsNull(Long tenantId, Long rfxLineSupplierId);


}
