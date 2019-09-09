package org.hzero.test1.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.*;
import org.hzero.test1.domain.repository.RfxRepository;
import org.hzero.test1.infra.mapper.RfxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/26 13:14
 */
@Component
public class RfxRepositoryImpl implements RfxRepository {
    @Autowired
    RfxMapper rfxMapper;

    @Override
    public Page<RfxSummaryDTO> listLineItem(PageRequest pageRequest, QueryDTO queryDTO) {
        return PageHelper.doPage(pageRequest, () -> rfxMapper.list(queryDTO));
    }

    @Override
    public Page<RfxBySupplierDTO> listRfxBySupplier(Long tenantId, PageRequest pageRequest, Long supplierCompanyId) {
        return PageHelper.doPage(pageRequest, () -> rfxMapper.listRfxBySupplier(tenantId, supplierCompanyId));
    }

    @Override
    public List<ExportDTO> exportRfx(Long tenantId, Long rfxHeaderId) {
        return rfxMapper.exportRfx(tenantId, rfxHeaderId);
    }
}
