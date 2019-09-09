package org.hzero.test1.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.infra.mapper.LineItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 询价单物料料⾏行行 资源库实现
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@Component
public class LineItemRepositoryImpl extends BaseRepositoryImpl<LineItem> implements LineItemRepository {
    @Autowired
    LineItemMapper lineItemMapper;

    @Override
    public Long getTenantId(Long tenantId) {
        return lineItemMapper.getTenantId(tenantId);
    }
}
