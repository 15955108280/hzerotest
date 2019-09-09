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
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.hzero.test1.api.config.SwaggerApiConfig;
import org.hzero.test1.api.dto.*;
import org.hzero.test1.app.service.ItemSupAssignService;
import org.hzero.test1.app.service.LineItemService;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.entity.ItemSupAssign;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.entity.LineSupplier;
import org.hzero.test1.domain.repository.HeaderRepository;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.repository.RfxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/26 12:38
 */

@Api(tags = SwaggerApiConfig.RFX)
@RestController("rfxController.v1")
@RequestMapping("/v1/{organizationId}/rfxs")
public class RfxController {
    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    RfxRepository rfxRepository;
    @Autowired
    RfxService rfxService;
    @Autowired
    LineItemService lineItemService;
    @Autowired
    ItemSupAssignService itemSupAssignService;

    @ApiOperation(value = "查询询价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY)
    public ResponseEntity<Page<RfxSummaryDTO>> listLineItem(
                    @ApiParam(value = "租户id", required = true) @PathVariable("organizationId") Long tenantId,
                    QueryDTO queryDTO, @ApiIgnore PageRequest pageRequest) {
        return Results.success(rfxService.listLineItem(pageRequest, queryDTO, tenantId));
    }

    @ApiOperation(value = "新增询价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<RfxDTO> createLineItem(
                    @ApiParam(value = "租户id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "新增实体类", required = true) @RequestBody RfxDTO rfxDTO) {
        rfxService.createLineItem(rfxDTO, tenantId);
        return Results.success(rfxDTO);
    }

    @ApiOperation(value = "删除询价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/{rfxHeaderId}")
    public ResponseEntity<Header> deleteLineItem(
                    @ApiParam(value = "租户id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "物料单头id", required = true) @PathVariable Long rfxHeaderId) {
        lineItemService.deleteLineItem(tenantId, rfxHeaderId);
        return Results.success();
    }

    @ApiOperation(value = "更新询价单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/{rfxLineItemId}")
    public ResponseEntity<LineItem> updateLineItem(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "订单行Id", required = true) @PathVariable Long rfxLineItemId,
                    @ApiParam(value = "订单行Id", required = true) @RequestParam String itemRemark,
                    @ApiParam(value = "订单行Id", required = true) @RequestParam String itemName) {
        return Results.success(rfxService.updateLineItem(tenantId, rfxLineItemId, itemRemark, itemName));
    }

    @ApiOperation(value = "供应商新增")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/{rfxHeaderId}/supplier")
    public ResponseEntity<Object> addSupplier(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "询价单Id", required = true) @PathVariable Long rfxHeaderId,
                    @ApiParam(value = "询价行Id", required = true) @RequestBody LineSupplier lineSupplier) {
        return Results.success(rfxService.addSupplier(tenantId, rfxHeaderId, lineSupplier));
    }

    @ApiOperation(value = "物料行分配")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/assign")
    public ResponseEntity<List<ItemSupAssign>> assignLineItem(
                    @ApiParam(value = "租户id", required = true) @PathVariable("organizationId") Long tenantId,
                    @RequestBody List<ItemSupAssign> itemSupAssignList) {
        return Results.success(itemSupAssignService.assignLineItem(itemSupAssignList, tenantId));
    }

    @ApiOperation(value = "数据导出")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/{rfxHeaderId}/export")
    @ExcelExport(ExportDTO.class)
    public ResponseEntity<List<ExportDTO>> exportRfx(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    ExportParam exportParam, HttpServletResponse response,
                    @ApiParam(value = "询价单Id", required = true) @PathVariable Long rfxHeaderId) {
        return Results.success(rfxRepository.exportRfx(tenantId, rfxHeaderId));
    }

    @ApiOperation(value = "询价单发布")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/publish/{rfxHeaderId}")
    public ResponseEntity<Header> publishRfx(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "订单行Id", required = true) @PathVariable Long rfxHeaderId) {
        return Results.success(rfxService.publishRfx(tenantId, rfxHeaderId));
    }

    @ApiOperation(value = "供应商询价单查询")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/supplier/{supplierCompanyId}")
    public ResponseEntity<Page<RfxBySupplierDTO>> listRfxBySupplier(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "供应商公司Id", required = true) @PathVariable Long supplierCompanyId,
                    @ApiIgnore PageRequest pageRequest) {
        return Results.success(rfxRepository.listRfxBySupplier(tenantId, pageRequest, supplierCompanyId));
    }

    @ApiOperation(value = "询价单参与")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/participate/{supplierCompanyId}")
    public ResponseEntity<Object> participateRfx(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "供应商公司Id", required = true) @PathVariable Long supplierCompanyId,
                    @ApiParam(value = "询价单Id", required = true) @RequestParam Long rfxHeaderId,
                    @ApiParam(value = "询价行Id", required = true) @RequestParam Long rfxLineItemId) {
        return Results.success(rfxService.participateRfx(tenantId, supplierCompanyId, rfxHeaderId, rfxLineItemId));
    }

    @ApiOperation(value = "询价单放弃")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/abandon/{supplierCompanyId}")
    public ResponseEntity<Object> abandonRfx(
                    @ApiParam(value = "租户Id", required = true) @PathVariable("organizationId") Long tenantId,
                    @ApiParam(value = "供应商公司Id", required = true) @PathVariable Long supplierCompanyId,
                    @ApiParam(value = "询价单Id", required = true) @RequestParam Long rfxHeaderId) {
        return Results.success(rfxService.abandonRfx(tenantId, supplierCompanyId, rfxHeaderId));
    }



}
