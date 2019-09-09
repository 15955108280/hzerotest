package org.hzero.test1.api.controller.v1;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.test1.domain.entity.QuotationHeader;
import org.hzero.test1.domain.repository.QuotationHeaderRepository;
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
 * 报价单头表 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@RestController("quotationHeaderController.v1")
@RequestMapping("/v1/{organizationId}/quotation-headers")
public class QuotationHeaderController extends BaseController {

    @Autowired
    private QuotationHeaderRepository quotationHeaderRepository;

    @ApiOperation(value = "报价单头表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<QuotationHeader>> list(QuotationHeader quotationHeader,
                    @ApiIgnore @SortDefault(value = QuotationHeader.FIELD_QUOTATION_HEADER_ID,
                                    direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<QuotationHeader> list = quotationHeaderRepository.pageAndSort(pageRequest, quotationHeader);
        return Results.success(list);
    }

    @ApiOperation(value = "报价单头表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{quotationHeaderId}")
    public ResponseEntity<QuotationHeader> detail(@PathVariable Long quotationHeaderId) {
        QuotationHeader quotationHeader = quotationHeaderRepository.selectByPrimaryKey(quotationHeaderId);
        return Results.success(quotationHeader);
    }

    @ApiOperation(value = "创建报价单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<QuotationHeader> create(@RequestBody QuotationHeader quotationHeader) {
        validObject(quotationHeader);
        quotationHeaderRepository.insertSelective(quotationHeader);
        return Results.success(quotationHeader);
    }

    @ApiOperation(value = "修改报价单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<QuotationHeader> update(@RequestBody QuotationHeader quotationHeader) {
        SecurityTokenHelper.validToken(quotationHeader);
        quotationHeaderRepository.updateByPrimaryKeySelective(quotationHeader);
        return Results.success(quotationHeader);
    }

    @ApiOperation(value = "删除报价单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody QuotationHeader quotationHeader) {
        SecurityTokenHelper.validToken(quotationHeader);
        quotationHeaderRepository.deleteByPrimaryKey(quotationHeader);
        return Results.success();
    }

}
