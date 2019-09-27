package org.hzero.test1.app.service;

import org.hzero.test1.api.dto.SavePriceDTO;
import org.hzero.test1.api.dto.SubmitPriceDTO;
import org.hzero.test1.domain.entity.QuotationLine;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 14:13
 */
public interface QuotationService {
    /**
     * 报检单保存
     * 
     * @param tenantId 租户id
     * @param savePriceDTO 保存信息
     * @return 报价单保存信息
     */
    QuotationLine saveQuotation(Long tenantId, SavePriceDTO savePriceDTO);

    /**
     * 报检单提交
     * 
     * @param tenantId 租户id
     * @param submitPriceDTO 保存信息
     * @return 报价单提交信息
     */
    QuotationLine submitQuotation(Long tenantId,Long supplierCompanyId, SubmitPriceDTO submitPriceDTO);
}
