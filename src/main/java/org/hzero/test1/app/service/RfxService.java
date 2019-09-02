package org.hzero.test1.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.test1.api.dto.QueryDTO;
import org.hzero.test1.api.dto.RfxDTO;
import org.hzero.test1.api.dto.RfxSummaryDTO;
import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.entity.LineItem;

/**
 * description
 *
 * @author YXP 2019/08/26 15:12
 */
public interface RfxService {

	/**
	 * 创建询价单
	 * @param rfxDTO 询价单
	 * @param tenantId 租户id
	 */
	void createLineItem(RfxDTO rfxDTO,Long tenantId);

	/**
	 * 更新询价单
	 * @param tenantId 租户id
	 * @param rfxLineItemId 物料行id
	 * @param itemRemark 标记
	 * @param itemName 名称
	 * @return LineItem
	 */
	LineItem updateLineItem(Long tenantId,Long rfxLineItemId, String itemRemark, String itemName);

	/**
	 * 查询询价单
	 * @param pageRequest 分页参数
	 * @param queryDTO 查询参数
	 * @param tenantId 租户id
	 * @return 分页查询结果
	 */
	Page<RfxSummaryDTO> listLineItem(PageRequest pageRequest, QueryDTO queryDTO, Long tenantId);

	/**
	 * 发布询价单
	 * @param tenantId 租户id
	 * @param rfxLineItemId 询价单id
	 * @return 询价单
	 */
	Header publishRfx(Long tenantId, Long rfxLineItemId);
}
