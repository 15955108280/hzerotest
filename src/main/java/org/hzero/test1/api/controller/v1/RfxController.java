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
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.app.service.LineItemService;
import org.hzero.test1.app.service.RfxService;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.entity.LineItem;
import org.hzero.test1.domain.repository.HeaderRepository;
import org.hzero.test1.domain.repository.LineItemRepository;
import org.hzero.test1.domain.repository.RfxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "查询询价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    @ProcessLovValue(targetField = BaseConstants.FIELD_BODY) // 值集翻译
    public ResponseEntity<Page<RfxSummaryDTO>> listLineItem(
			@ApiParam(value = "租户id",required = true)@PathVariable("organizationId") Long tenantId,
			QueryDTO queryDTO,
			PageRequest pageRequest) {
        return Results.success(rfxService.list(pageRequest, queryDTO,tenantId));
    }

    @ApiOperation(value = "新增询价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<RfxDTO> createLineItem(
			@ApiParam(value = "租户id",required = true)@PathVariable("organizationId") Long tenantId,
			@ApiParam(value = "新增实体类",required = true)@RequestBody RfxDTO rfxDTO) {
        rfxService.create(rfxDTO);
        return Results.success(rfxDTO);
    }

    @ApiOperation(value = "删除询价")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping("/{rfxHeaderId}")
    public ResponseEntity<Header> deleteLineItem(
    		@ApiParam(value = "租户id",required = true)@PathVariable("organizationId") Long tenantId,
			@ApiParam(value = "物料单头id",required = true)@PathVariable Long rfxHeaderId) {
		lineItemService.deleteLineItem(tenantId,rfxHeaderId);
        return Results.success();
    }

    @ApiOperation(value = "更新询价单")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/{rfxLineItemId}")
    public ResponseEntity<LineItem> updateLineItem(
    		@ApiParam(value = "租户Id",required = true)@PathVariable("organizationId") Long tenantId,
			@ApiParam(value = "订单行Id",required = true)@PathVariable Long rfxLineItemId,
			@ApiParam(value = "订单行Id",required = true)@RequestParam String itemRemark,
			@ApiParam(value = "订单行Id",required = true)@RequestParam String itemName) {
        return Results.success(rfxService.updateLineItem(tenantId,rfxLineItemId,itemRemark,itemName));
    }
}
