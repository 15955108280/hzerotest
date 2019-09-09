package org.hzero.test1.domain.service.impl;

import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.repository.QuotationLineRepository;
import org.hzero.test1.domain.service.QuotationLineDoMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 15:45
 */
@Service
public class QuotationLineDoMainServiceImpl implements QuotationLineDoMainService {
    @Autowired
    QuotationLineRepository quotationLineRepository;

    @Override
    public Boolean quotationLineIsNull(Long tenantId, Long quotationLineId) {
        QuotationLine quotationLine = new QuotationLine(tenantId, quotationLineId);
        return quotationLineRepository.selectOne(quotationLine) != null;
    }
}
