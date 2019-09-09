package org.hzero.test1.api.controller.v1;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.repository.QuotationLineRepository;
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
 * 报价单行表 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@RestController("quotationLineController.v1")
@RequestMapping("/v1/{organizationId}/quotation-lines")
public class QuotationLineController extends BaseController {

    @Autowired
    private QuotationLineRepository quotationLineRepository;

    @ApiOperation(value = "报价单行表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<QuotationLine>> list(QuotationLine quotationLine,
                    @ApiIgnore @SortDefault(value = QuotationLine.FIELD_QUOTATION_LINE_ID,
                                    direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<QuotationLine> list = quotationLineRepository.pageAndSort(pageRequest, quotationLine);
        return Results.success(list);
    }

    @ApiOperation(value = "报价单行表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{quotationLineId}")
    public ResponseEntity<QuotationLine> detail(@PathVariable Long quotationLineId) {
        QuotationLine quotationLine = quotationLineRepository.selectByPrimaryKey(quotationLineId);
        return Results.success(quotationLine);
    }

    @ApiOperation(value = "创建报价单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<QuotationLine> create(@RequestBody QuotationLine quotationLine) {
        validObject(quotationLine);
        quotationLineRepository.insertSelective(quotationLine);
        return Results.success(quotationLine);
    }

    @ApiOperation(value = "修改报价单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<QuotationLine> update(@RequestBody QuotationLine quotationLine) {
        SecurityTokenHelper.validToken(quotationLine);
        quotationLineRepository.updateByPrimaryKeySelective(quotationLine);
        return Results.success(quotationLine);
    }

    @ApiOperation(value = "删除报价单行表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody QuotationLine quotationLine) {
        SecurityTokenHelper.validToken(quotationLine);
        quotationLineRepository.deleteByPrimaryKey(quotationLine);
        return Results.success();
    }

}
