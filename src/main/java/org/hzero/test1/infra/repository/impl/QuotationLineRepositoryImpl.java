package org.hzero.test1.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.repository.QuotationLineRepository;
import org.hzero.test1.infra.mapper.QuotationLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 报价单行表 资源库实现
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@Component
public class QuotationLineRepositoryImpl extends BaseRepositoryImpl<QuotationLine> implements QuotationLineRepository {

    @Autowired
    QuotationLineMapper quotationLineMapper;

    @Override
    public QuotationLine selectVersionNumber(Long tenantId, Long quotationLineId) {
        QuotationLine quotationLine = new QuotationLine(tenantId, quotationLineId);
        return quotationLineMapper.selectOne(quotationLine);
    }

    @Override
    public QuotationLine selectQuotationLine(Long tenantId, Long quotationLineId) {
        QuotationLine quotationLine = new QuotationLine(tenantId, quotationLineId);
        return quotationLineMapper.selectOne(quotationLine);
    }
}
