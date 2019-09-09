package org.hzero.test1.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.QuotationSummaryDTO;



/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 14:35
 */
public interface QuotationRepository {
    /**
     * 供应商报价行查询
     * 
     * @param pageRequest 分页参数
     * @param tenantId 租户id
     * @param supplierCompanyId 供应商租户id
     * @return 供应商报价链表
     */
    Page<QuotationSummaryDTO> listQuotation(PageRequest pageRequest, Long tenantId, Long supplierCompanyId);
}
