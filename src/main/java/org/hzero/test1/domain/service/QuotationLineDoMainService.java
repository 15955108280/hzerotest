package org.hzero.test1.domain.service;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 15:45
 */
public interface QuotationLineDoMainService {
    /**
     * 报价单行是否存在
     * 
     * @param tenantId 租户id
     * @param quotationLineId 报价单id
     * @return
     */
    Boolean quotationLineIsNull(Long tenantId, Long quotationLineId);
}
