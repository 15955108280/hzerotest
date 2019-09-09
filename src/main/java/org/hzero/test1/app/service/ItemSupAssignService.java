package org.hzero.test1.app.service;

import org.hzero.test1.domain.entity.ItemSupAssign;

import java.util.List;

/**
 * 询价单物料-供应商分配关系表应用服务
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
public interface ItemSupAssignService {

    /**
     * 物料行分配
     * 
     * @param itemSupAssignList 物料行分配信息
     * @param tenantId 租户id
     * @return 物料行分配信息
     */
    List<ItemSupAssign> assignLineItem(List<ItemSupAssign> itemSupAssignList, Long tenantId);
}
