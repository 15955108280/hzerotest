package org.hzero.test1.infra.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 14:37
 */
public interface QuotationMapper {
    /**
     * 供应商报价行查询
     * 
     * @param tenantId 租户id
     * @param supplierCompanyId 供应商租户id
     * @return 供应商报价链表
     */
    List listQuotation(@Param(value = "tenantId") Long tenantId,
                    @Param(value = "supplierCompanyId") Long supplierCompanyId);
}
