package org.hzero.test1.app.service;

import org.hzero.test1.domain.entity.ItemSupAssign;

/**
 * 询价单物料-供应商分配关系表应用服务
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
public interface ItemSupAssignService {

    /**
     * 物料行分配
     * 
     * @param itemSupAssign 物料行分配信息
     * @return 物料行分配信息
     */
    ItemSupAssign assignLineItem(ItemSupAssign itemSupAssign);
}
