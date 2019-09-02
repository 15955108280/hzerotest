package org.hzero.test1.api.controller.v1;

import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.hzero.test1.domain.entity.QuotationRecord;
import org.hzero.test1.domain.repository.QuotationRecordRepository;
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
 * 所有报价记录 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@RestController("quotationRecordController.v1")
@RequestMapping("/v1/{organizationId}/quotation-records")
public class QuotationRecordController extends BaseController {

    @Autowired
    private QuotationRecordRepository quotationRecordRepository;

    @ApiOperation(value = "所有报价记录列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<QuotationRecord>> list(QuotationRecord quotationRecord, @ApiIgnore @SortDefault(value = QuotationRecord.FIELD_RECORD_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<QuotationRecord> list = quotationRecordRepository.pageAndSort(pageRequest, quotationRecord);
        return Results.success(list);
    }

    @ApiOperation(value = "所有报价记录明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{recordId}")
    public ResponseEntity<QuotationRecord> detail(@PathVariable Long recordId) {
        QuotationRecord quotationRecord = quotationRecordRepository.selectByPrimaryKey(recordId);
        return Results.success(quotationRecord);
    }

    @ApiOperation(value = "创建所有报价记录")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<QuotationRecord> create(@RequestBody QuotationRecord quotationRecord) {
        validObject(quotationRecord);
        quotationRecordRepository.insertSelective(quotationRecord);
        return Results.success(quotationRecord);
    }

    @ApiOperation(value = "修改所有报价记录")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<QuotationRecord> update(@RequestBody QuotationRecord quotationRecord) {
        SecurityTokenHelper.validToken(quotationRecord);
        quotationRecordRepository.updateByPrimaryKeySelective(quotationRecord);
        return Results.success(quotationRecord);
    }

    @ApiOperation(value = "删除所有报价记录")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody QuotationRecord quotationRecord) {
        SecurityTokenHelper.validToken(quotationRecord);
        quotationRecordRepository.deleteByPrimaryKey(quotationRecord);
        return Results.success();
    }

}
