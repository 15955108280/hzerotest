package org.hzero.test1.api.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.test1.api.config.SwaggerApiConfig;
import org.hzero.test1.app.service.ItemSupAssignService;
import org.hzero.test1.domain.entity.ItemSupAssign;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 询价单物料行管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@Api(tags = SwaggerApiConfig.LINEITEM)
@RestController("lineItemController.v1")
@RequestMapping("/v1/{organizationId}/line-items")
public class LineItemController extends BaseController {

    @Autowired
    private LineItemRepository lineItemRepository;
    @Autowired
    private ItemSupAssignService itemSupAssignService;

    @ApiOperation(value = "询价单物料料⾏行行列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<LineItem>> list(LineItem lineItem,
                    @ApiIgnore @SortDefault(value = LineItem.FIELD_RFX_LINE_ITEM_ID,
                                    direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<LineItem> list = lineItemRepository.pageAndSort(pageRequest, lineItem);
        return Results.success(list);
    }

    @ApiOperation(value = "询价单物料料⾏行行明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{rfxLineItemId}")
    public ResponseEntity<LineItem> detail(@PathVariable Long rfxLineItemId) {
        LineItem lineItem = lineItemRepository.selectByPrimaryKey(rfxLineItemId);
        return Results.success(lineItem);
    }

    @ApiOperation(value = "创建询价单物料料⾏行行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<LineItem> create(@RequestBody LineItem lineItem) {
        validObject(lineItem);
        lineItemRepository.insertSelective(lineItem);
        return Results.success(lineItem);
    }

    @ApiOperation(value = "修改询价单物料料⾏行行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<LineItem> update(@RequestBody LineItem lineItem) {
        SecurityTokenHelper.validToken(lineItem);
        lineItemRepository.updateByPrimaryKeySelective(lineItem);
        return Results.success(lineItem);
    }

    @ApiOperation(value = "删除询价单物料料⾏行行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody LineItem lineItem) {
        SecurityTokenHelper.validToken(lineItem);
        lineItemRepository.deleteByPrimaryKey(lineItem);
        return Results.success();
    }

    @ApiOperation(value = "物料行分配")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/assign")
    public ResponseEntity<List<ItemSupAssign>> assignLineItem(
                    @ApiParam(value = "租户id", required = true) @PathVariable("organizationId") Long tenantId,
                    @RequestBody List<ItemSupAssign> itemSupAssignList) {
        return Results.success(itemSupAssignService.assignLineItem(itemSupAssignList, tenantId));
    }
}
