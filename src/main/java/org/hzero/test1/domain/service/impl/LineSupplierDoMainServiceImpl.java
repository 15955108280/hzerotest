package org.hzero.test1.domain.service.impl;

import org.hzero.test1.domain.entity.LineSupplier;
import org.hzero.test1.domain.repository.LineSupplierRepository;
import org.hzero.test1.domain.service.LineSupplierDoMainService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/02 15:31
 */
public class LineSupplierDoMainServiceImpl implements LineSupplierDoMainService {

    @Autowired
    LineSupplierRepository lineSupplierRepository;

    @Override
    public Boolean lineSupplierIsNull(Long tenantId, Long rfxLineSupplierId) {
        LineSupplier lineSupplier = new LineSupplier(tenantId, rfxLineSupplierId);
        return lineSupplierRepository.selectOne(lineSupplier) != null;
    }
}
