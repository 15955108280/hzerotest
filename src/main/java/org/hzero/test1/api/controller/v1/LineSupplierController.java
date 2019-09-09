package org.hzero.test1.api.controller.v1;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.test1.domain.entity.LineSupplier;
import org.hzero.test1.domain.repository.LineSupplierRepository;
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
 * 询价单供应商行 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@RestController("lineSupplierController.v1")
@RequestMapping("/v1/{organizationId}/line-suppliers")
public class LineSupplierController extends BaseController {

    @Autowired
    private LineSupplierRepository lineSupplierRepository;

    @ApiOperation(value = "询价单供应商行列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<LineSupplier>> list(LineSupplier lineSupplier,
                    @ApiIgnore @SortDefault(value = LineSupplier.FIELD_RFX_LINE_SUPPLIER_ID,
                                    direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<LineSupplier> list = lineSupplierRepository.pageAndSort(pageRequest, lineSupplier);
        return Results.success(list);
    }

    @ApiOperation(value = "询价单供应商行明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{rfxLineSupplierId}")
    public ResponseEntity<LineSupplier> detail(@PathVariable Long rfxLineSupplierId) {
        LineSupplier lineSupplier = lineSupplierRepository.selectByPrimaryKey(rfxLineSupplierId);
        return Results.success(lineSupplier);
    }

    @ApiOperation(value = "创建询价单供应商行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<LineSupplier> create(@RequestBody LineSupplier lineSupplier) {
        validObject(lineSupplier);
        lineSupplierRepository.insertSelective(lineSupplier);
        return Results.success(lineSupplier);
    }

    @ApiOperation(value = "修改询价单供应商行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<LineSupplier> update(@RequestBody LineSupplier lineSupplier) {
        SecurityTokenHelper.validToken(lineSupplier);
        lineSupplierRepository.updateByPrimaryKeySelective(lineSupplier);
        return Results.success(lineSupplier);
    }

    @ApiOperation(value = "删除询价单供应商行")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody LineSupplier lineSupplier) {
        SecurityTokenHelper.validToken(lineSupplier);
        lineSupplierRepository.deleteByPrimaryKey(lineSupplier);
        return Results.success();
    }

}
