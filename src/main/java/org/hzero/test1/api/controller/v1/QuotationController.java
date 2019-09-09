package org.hzero.test1.api.controller.v1;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseConstants;
import org.hzero.core.util.Results;
import org.hzero.test1.api.config.SwaggerApiConfig;
import org.hzero.test1.api.dto.*;
import org.hzero.test1.app.service.QuotationService;
import org.hzero.test1.domain.entity.QuotationLine;
import org.hzero.test1.domain.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * description 供应商controller
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 13:21
 */
@Api(tags = SwaggerApiConfig.QUOTATION)
@RestController("quotationController.v1")
@RequestMapping("/v1/{organizationId}/quotations")
public class QuotationController {

    @Autowired
    QuotationService quotationService;
    @Autowired
    QuotationRepository quotationRepository;

    @ApiOperation(value = "查询报价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{supplierCompanyId}")
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    public ResponseEntity<Page<QuotationSummaryDTO>> listLineItem(
                    @ApiParam(value = "租户id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "供应商id", required = true) @PathVariable Long supplierCompanyId,
                    @ApiIgnore PageRequest pageRequest) {
        return Results.success(quotationRepository.listQuotation(pageRequest, tenantId, supplierCompanyId));
    }

    @ApiOperation(value = "报价单保存")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/save")
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    public ResponseEntity<QuotationLine> saveQuotation(
                    @ApiParam(value = "租户", required = true) @PathVariable("organizationId") Long tenantId,
                    @RequestBody SavePriceDTO savePriceDTO) {
        return Results.success(quotationService.saveQuotation(tenantId, savePriceDTO));
    }

    @ApiOperation(value = "报价单提交")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/submit")
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    public ResponseEntity<QuotationLine> submitQuotation(
                    @ApiParam(value = "租户", required = true) @PathVariable("organizationId") Long tenantId,
                    @RequestBody SubmitPriceDTO submitPriceDTO) {
        return Results.success(quotationService.submitQuotation(tenantId, submitPriceDTO));
    }



}
