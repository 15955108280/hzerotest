package org.hzero.test1.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import org.hzero.test1.domain.entity.Header;

/**
 * 询价单头表资源库
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
public interface HeaderRepository extends BaseRepository<Header> {
    /**
     * 添加询价单行并返回id
     * 
     * @param header 询价单
     * @return 主键
     */
    Long insertGetId(Header header);

    /**
     * 获取住户id
     * 
     * @param tenantId 租户id
     * @return 租户id
     */
    Long getTenantId(Long tenantId);

}
