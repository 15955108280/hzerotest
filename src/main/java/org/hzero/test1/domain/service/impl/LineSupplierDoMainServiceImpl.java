package org.hzero.test1.domain.service.impl;

import org.hzero.test1.domain.entity.LineSupplier;
import org.hzero.test1.domain.repository.LineSupplierRepository;
import org.hzero.test1.domain.service.LineSupplierDoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/02 15:31
 */
@Service
public class LineSupplierDoMainServiceImpl implements LineSupplierDoMainService {

    @Autowired
    LineSupplierRepository lineSupplierRepository;

    @Override
    public Boolean lineSupplierIsNull(Long tenantId, Long supplierCompanyId, Long rfxHeaderId) {
        LineSupplier lineSupplier = new LineSupplier(tenantId, supplierCompanyId, rfxHeaderId);
        return lineSupplierRepository.selectOne(lineSupplier) != null;
    }

    @Override
    public Boolean lineSupplierIsNull(Long tenantId, Long rfxLineSupplierId) {
        LineSupplier lineSupplier = new LineSupplier(tenantId, rfxLineSupplierId);
        return lineSupplierRepository.selectOne(lineSupplier) != null;
    }
}
