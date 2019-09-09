package org.hzero.test1.infra.repository.impl;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.QuotationSummaryDTO;
import org.hzero.test1.domain.repository.QuotationRepository;
import org.hzero.test1.infra.mapper.QuotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 14:36
 */
@Component
public class QuotationRepositoryImpl implements QuotationRepository {

    @Autowired
    QuotationMapper quotationMapper;

    @Override
    public Page<QuotationSummaryDTO> listQuotation(PageRequest pageRequest, Long tenantId, Long supplierCompanyId) {
        return PageHelper.doPage(pageRequest, () -> quotationMapper.listQuotation(tenantId, supplierCompanyId));
    }
}
