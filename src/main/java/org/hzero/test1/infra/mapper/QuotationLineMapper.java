package org.hzero.test1.infra.mapper;

import org.apache.ibatis.annotations.Param;
import org.hzero.test1.domain.entity.QuotationLine;

import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.security.core.parameters.P;

/**
 * 报价单行表Mapper
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
public interface QuotationLineMapper extends BaseMapper<QuotationLine> {
    /**
     * 获取版本号
     * 
     * @param tenantId 租户id
     * @param quotationLineId 报价单id
     * @return 版本号
     */
    Long selectVersionNumber(@Param(value = "tenantId") Long tenantId,
                    @Param(value = "quotationLineId") Long quotationLineId);
}
