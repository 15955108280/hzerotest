package org.hzero.test1.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.test1.domain.entity.QuotationLine;

/**
 * 报价单行表资源库
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
public interface QuotationLineRepository extends BaseRepository<QuotationLine> {
    /**
     * 获取版本号
     * 
     * @param tenantId 租户id
     * @param quotationLineId 报价单id
     * @return 版本号
     */
    QuotationLine selectVersionNumber(Long tenantId, Long quotationLineId);

    /**
     * 获取订单行信息
     * 
     * @param tenantId 租户id
     * @param quotationLineId 订单行id
     * @return 订单行
     */
    QuotationLine selectQuotationLine(Long tenantId, Long quotationLineId);
}
