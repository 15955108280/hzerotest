package org.hzero.test1.domain.service;

import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/02 15:30
 */
@Service
public interface LineSupplierDoMainService {

	Boolean lineSupplierIsNull(Long tenantId,Long rfxLineSupplierId);
}
