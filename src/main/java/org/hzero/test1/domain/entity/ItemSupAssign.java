package org.hzero.test1.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 询价单物料-供应商分配关系表
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@ApiModel("询价单物料-供应商分配关系表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_item_sup_assign")
public class ItemSupAssign extends AuditDomain implements Serializable {

    public static final String FIELD_ITEM_SUP_ASSIGN_ID = "itemSupAssignId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_RFX_HEADER_ID = "rfxHeaderId";
    public static final String FIELD_RFX_LINE_ITEM_ID = "rfxLineItemId";
    public static final String FIELD_RFX_LINE_SUPPLIER_ID = "rfxLineSupplierId";
    public static final String FIELD_MAX_LIMIT_PRICE = "maxLimitPrice";
    public static final String FIELD_MIN_LIMIT_PRICE = "minLimitPrice";
    public static final String FIELD_INVITE_FLAG = "inviteFlag";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long itemSupAssignId;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id", required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "询价单头ID", required = true)
    @NotNull
    private Long rfxHeaderId;
    @ApiModelProperty(value = "询价单物料行ID", required = true)
    @NotNull
    private Long rfxLineItemId;
    @ApiModelProperty(value = "询价单供应商行ID", required = true)
    @NotNull
    private Long rfxLineSupplierId;
    @ApiModelProperty(value = "最高限价")
    private BigDecimal maxLimitPrice;
    @ApiModelProperty(value = "最低限价")
    private BigDecimal minLimitPrice;
    @ApiModelProperty(value = "邀请标志")
    private Integer inviteFlag;

    public ItemSupAssign(Long tenantId, Long rfxLineItemId, Long rfxLineSupplierId) {
        this.tenantId = tenantId;
        this.rfxLineItemId = rfxLineItemId;
        this.rfxLineSupplierId = rfxLineSupplierId;
    }

    public ItemSupAssign() {

    }
    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return
     */
    public Long getItemSupAssignId() {
        return itemSupAssignId;
    }

    public void setItemSupAssignId(Long itemSupAssignId) {
        this.itemSupAssignId = itemSupAssignId;
    }

    /**
     * @return 所属租户ID，hpfm_tenant.tenant_id
     */
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return 询价单头ID
     */
    public Long getRfxHeaderId() {
        return rfxHeaderId;
    }

    public void setRfxHeaderId(Long rfxHeaderId) {
        this.rfxHeaderId = rfxHeaderId;
    }

    /**
     * @return 询价单物料行ID
     */
    public Long getRfxLineItemId() {
        return rfxLineItemId;
    }

    public void setRfxLineItemId(Long rfxLineItemId) {
        this.rfxLineItemId = rfxLineItemId;
    }

    /**
     * @return 询价单供应商行ID
     */
    public Long getRfxLineSupplierId() {
        return rfxLineSupplierId;
    }

    public void setRfxLineSupplierId(Long rfxLineSupplierId) {
        this.rfxLineSupplierId = rfxLineSupplierId;
    }

    /**
     * @return 最高限价
     */
    public BigDecimal getMaxLimitPrice() {
        return maxLimitPrice;
    }

    public void setMaxLimitPrice(BigDecimal maxLimitPrice) {
        this.maxLimitPrice = maxLimitPrice;
    }

    /**
     * @return 最低限价
     */
    public BigDecimal getMinLimitPrice() {
        return minLimitPrice;
    }

    public void setMinLimitPrice(BigDecimal minLimitPrice) {
        this.minLimitPrice = minLimitPrice;
    }

    /**
     * @return 邀请标志
     */
    public Integer getInviteFlag() {
        return inviteFlag;
    }

    public void setInviteFlag(Integer inviteFlag) {
        this.inviteFlag = inviteFlag;
    }

}
