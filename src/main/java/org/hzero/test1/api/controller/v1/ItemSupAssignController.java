package org.hzero.test1.api.controller.v1;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.test1.domain.entity.ItemSupAssign;
import org.hzero.test1.domain.repository.ItemSupAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 询价单物料-供应商分配关系表 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@RestController("itemSupAssignController.v1")
@RequestMapping("/v1/{organizationId}/item-sup-assigns")
public class ItemSupAssignController extends BaseController {

    @Autowired
    private ItemSupAssignRepository itemSupAssignRepository;

    @ApiOperation(value = "询价单物料-供应商分配关系表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<ItemSupAssign>> list(ItemSupAssign itemSupAssign, @ApiIgnore @SortDefault(value = ItemSupAssign.FIELD_ITEM_SUP_ASSIGN_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<ItemSupAssign> list = itemSupAssignRepository.pageAndSort(pageRequest, itemSupAssign);
        return Results.success(list);
    }

    @ApiOperation(value = "询价单物料-供应商分配关系表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{itemSupAssignId}")
    public ResponseEntity<ItemSupAssign> detail(@PathVariable Long itemSupAssignId) {
        ItemSupAssign itemSupAssign = itemSupAssignRepository.selectByPrimaryKey(itemSupAssignId);
        return Results.success(itemSupAssign);
    }

    @ApiOperation(value = "创建询价单物料-供应商分配关系表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<ItemSupAssign> create(@RequestBody ItemSupAssign itemSupAssign) {
        validObject(itemSupAssign);
        itemSupAssignRepository.insertSelective(itemSupAssign);
        return Results.success(itemSupAssign);
    }

    @ApiOperation(value = "修改询价单物料-供应商分配关系表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<ItemSupAssign> update(@RequestBody ItemSupAssign itemSupAssign) {
        SecurityTokenHelper.validToken(itemSupAssign);
        itemSupAssignRepository.updateByPrimaryKeySelective(itemSupAssign);
        return Results.success(itemSupAssign);
    }

    @ApiOperation(value = "删除询价单物料-供应商分配关系表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody ItemSupAssign itemSupAssign) {
        SecurityTokenHelper.validToken(itemSupAssign);
        itemSupAssignRepository.deleteByPrimaryKey(itemSupAssign);
        return Results.success();
    }

}
