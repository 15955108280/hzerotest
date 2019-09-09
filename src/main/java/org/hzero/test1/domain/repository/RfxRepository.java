package org.hzero.test1.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.ExportDTO;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxBySupplierDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;

import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/26 13:02
 */
public interface RfxRepository {
    /**
     * 查询询价单
     * 
     * @param pageRequest 分页参数
     * @param queryDTO 查询条件
     * @return 分页查询结果
     */
    Page<RfxSummaryDTO> listLineItem(PageRequest pageRequest, QueryDTO queryDTO);

    /**
     * 供应商查询询价单
     * 
     * @param tenantId 供应商id
     * @param pageRequest 分页参数
     * @param supplierCompanyId 公司id
     * @return 询价单列表
     */
    Page<RfxBySupplierDTO> listRfxBySupplier(Long tenantId, PageRequest pageRequest, Long supplierCompanyId);

    /**
     * 表格导出
     * 
     * @param tenantId 租户id
     * @param rfxHeaderId 询价单头id
     * @return 导出数据
     */
    List<ExportDTO> exportRfx(Long tenantId, Long rfxHeaderId);
}
