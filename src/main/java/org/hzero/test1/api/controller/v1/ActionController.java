package org.hzero.test1.api.controller.v1;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.test1.domain.entity.Action;
import org.hzero.test1.domain.repository.ActionRepository;
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
 * 询价单操作记录 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@RestController("actionController.v1")
@RequestMapping("/v1/{organizationId}/actions")
public class ActionController extends BaseController {

    @Autowired
    private ActionRepository actionRepository;

    @ApiOperation(value = "询价单操作记录列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Action>> list(Action action, @ApiIgnore @SortDefault(value = Action.FIELD_RFX_ACTION_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Action> list = actionRepository.pageAndSort(pageRequest, action);
        return Results.success(list);
    }

    @ApiOperation(value = "询价单操作记录明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{rfxActionId}")
    public ResponseEntity<Action> detail(@PathVariable Long rfxActionId) {
        Action action = actionRepository.selectByPrimaryKey(rfxActionId);
        return Results.success(action);
    }

    @ApiOperation(value = "创建询价单操作记录")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<Action> create(@RequestBody Action action) {
        validObject(action);
        actionRepository.insertSelective(action);
        return Results.success(action);
    }

    @ApiOperation(value = "修改询价单操作记录")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<Action> update(@RequestBody Action action) {
        SecurityTokenHelper.validToken(action);
        actionRepository.updateByPrimaryKeySelective(action);
        return Results.success(action);
    }

    @ApiOperation(value = "删除询价单操作记录")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Action action) {
        SecurityTokenHelper.validToken(action);
        actionRepository.deleteByPrimaryKey(action);
        return Results.success();
    }

}
