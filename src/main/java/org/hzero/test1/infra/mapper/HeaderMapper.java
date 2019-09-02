package org.hzero.test1.infra.mapper;

import org.hzero.test1.domain.entity.Header;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * 询价单头表Mapper
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
public interface HeaderMapper extends BaseMapper<Header> {

    /**
     * 查询租户id
     * 
     * @param tenantId 租户id
     * @return 租户id
     */
    Long getTenantId(Long tenantId);
}
