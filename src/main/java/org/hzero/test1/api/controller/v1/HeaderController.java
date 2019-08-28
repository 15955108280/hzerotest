package org.hzero.test1.api.controller.v1;

import io.swagger.annotations.Api;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hzero.test1.api.config.SwaggerApiConfig;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.repository.HeaderRepository;
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

/**
 * 询价单头表 管理 API
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@Api(tags = SwaggerApiConfig.HEADER)
@RestController("headerController.v1")
@RequestMapping("/v1/{organizationId}/headers")
public class HeaderController extends BaseController {

    @Autowired
    private HeaderRepository headerRepository;

    @ApiOperation(value = "询价单头表列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Header>> list(Header header, @ApiIgnore @SortDefault(value = Header.FIELD_RFX_HEADER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Header> list = headerRepository.pageAndSort(pageRequest, header);
        return Results.success(list);
    }

    @ApiOperation(value = "询价单头表明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{rfxHeaderId}")
    public ResponseEntity<Header> detail(@PathVariable Long rfxHeaderId) {
        Header header = headerRepository.selectByPrimaryKey(rfxHeaderId);
        return Results.success(header);
    }

    @ApiOperation(value = "创建询价单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<Header> create(@RequestBody Header header) {
        validObject(header);
        headerRepository.insertSelective(header);
        return Results.success(header);
    }

    @ApiOperation(value = "修改询价单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<Header> update(@RequestBody Header header) {
        SecurityTokenHelper.validToken(header);
        headerRepository.updateByPrimaryKeySelective(header);
        return Results.success(header);
    }

    @ApiOperation(value = "删除询价单头表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Header header) {
        SecurityTokenHelper.validToken(header);
        headerRepository.deleteByPrimaryKey(header);
        return Results.success();
    }

}
