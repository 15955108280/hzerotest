package org.hzero.test1.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 询价单供应商行
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@ApiModel("询价单供应商行")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_line_supplier")
public class LineSupplier extends AuditDomain {

    public static final String FIELD_RFX_LINE_SUPPLIER_ID = "rfxLineSupplierId";
    public static final String FIELD_RFX_HEADER_ID = "rfxHeaderId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_SUPPLIER_TENANT_ID = "supplierTenantId";
    public static final String FIELD_SUPPLIER_COMPANY_ID = "supplierCompanyId";
    public static final String FIELD_SUPPLIER_COMPANY_NAME = "supplierCompanyName";
    public static final String FIELD_SUPPLIER_CONTACT_ID = "supplierContactId";
    public static final String FIELD_CONTACT_NAME = "contactName";
    public static final String FIELD_CONTACT_MAIL = "contactMail";
    public static final String FIELD_CONTACT_MOBILEPHONE = "contactMobilephone";
    public static final String FIELD_CONTACT_TELEPHONE = "contactTelephone";
    public static final String FIELD_FEEDBACK_STATUS = "feedbackStatus";
    public static final String FIELD_FEEDBACK_REMARK = "feedbackRemark";
    public static final String FIELD_READ_FLAG = "readFlag";
    public static final String FIELD_ABANDON_REMARK = "abandonRemark";
    public static final String FIELD_APPEND_FLAG = "appendFlag";
    public static final String FIELD_APPEND_REMARK = "appendRemark";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long rfxLineSupplierId;
    @ApiModelProperty(value = "询价单头ID", required = true)
    @NotNull
    private Long rfxHeaderId;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id", required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "")
    private Long supplierTenantId;
    @ApiModelProperty(value = "")
    private Long supplierCompanyId;
    @ApiModelProperty(value = "供应方企业名称", required = true)
    @NotBlank
    private String supplierCompanyName;
    @ApiModelProperty(value = "供应商联系人ID")
    private Long supplierContactId;
    @ApiModelProperty(value = "联系人姓名", required = true)
    @NotBlank
    private String contactName;
    @ApiModelProperty(value = "联系人邮箱", required = true)
    @NotBlank
    private String contactMail;
    @ApiModelProperty(value = "联系人手机号", required = true)
    @NotBlank
    private String contactMobilephone;
    @ApiModelProperty(value = "联系人固话")
    private String contactTelephone;
    @ApiModelProperty(value = "反馈状态SSRC.RFX_FEEDBACK_STATUS(PARTICIPATED/参与|ABANDONED/不参与|NEW/未反馈)", required = true)
    @NotBlank
    private String feedbackStatus;
    @ApiModelProperty(value = "供应商报价状况备注")
    private String feedbackRemark;
    @ApiModelProperty(value = "供应商已读标识", required = true)
    @NotNull
    private Integer readFlag;
    @ApiModelProperty(value = "放弃理由")
    private String abandonRemark;
    @ApiModelProperty(value = "添加标识", required = true)
    @NotNull
    private Integer appendFlag;
    @ApiModelProperty(value = "添加备注")
    private String appendRemark;

	public LineSupplier(){

	}

	public LineSupplier(Long tenantId,Long rfxLineSupplierId){
		this.tenantId = tenantId;
		this.rfxLineSupplierId = rfxLineSupplierId;
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
    public Long getRfxLineSupplierId() {
        return rfxLineSupplierId;
    }

    public void setRfxLineSupplierId(Long rfxLineSupplierId) {
        this.rfxLineSupplierId = rfxLineSupplierId;
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
     * @return 所属租户ID，hpfm_tenant.tenant_id
     */
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return
     */
    public Long getSupplierTenantId() {
        return supplierTenantId;
    }

    public void setSupplierTenantId(Long supplierTenantId) {
        this.supplierTenantId = supplierTenantId;
    }

    /**
     * @return
     */
    public Long getSupplierCompanyId() {
        return supplierCompanyId;
    }

    public void setSupplierCompanyId(Long supplierCompanyId) {
        this.supplierCompanyId = supplierCompanyId;
    }

    /**
     * @return 供应方企业名称
     */
    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName;
    }

    /**
     * @return 供应商联系人ID
     */
    public Long getSupplierContactId() {
        return supplierContactId;
    }

    public void setSupplierContactId(Long supplierContactId) {
        this.supplierContactId = supplierContactId;
    }

    /**
     * @return 联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return 联系人邮箱
     */
    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    /**
     * @return 联系人手机号
     */
    public String getContactMobilephone() {
        return contactMobilephone;
    }

    public void setContactMobilephone(String contactMobilephone) {
        this.contactMobilephone = contactMobilephone;
    }

    /**
     * @return 联系人固话
     */
    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    /**
     * @return 反馈状态SSRC.RFX_FEEDBACK_STATUS(PARTICIPATED/参与|ABANDONED/不参与|NEW/未反馈)
     */
    public String getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    /**
     * @return 供应商报价状况备注
     */
    public String getFeedbackRemark() {
        return feedbackRemark;
    }

    public void setFeedbackRemark(String feedbackRemark) {
        this.feedbackRemark = feedbackRemark;
    }

    /**
     * @return 供应商已读标识
     */
    public Integer getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Integer readFlag) {
        this.readFlag = readFlag;
    }

    /**
     * @return 放弃理由
     */
    public String getAbandonRemark() {
        return abandonRemark;
    }

    public void setAbandonRemark(String abandonRemark) {
        this.abandonRemark = abandonRemark;
    }

    /**
     * @return 添加标识
     */
    public Integer getAppendFlag() {
        return appendFlag;
    }

    public void setAppendFlag(Integer appendFlag) {
        this.appendFlag = appendFlag;
    }

    /**
     * @return 添加备注
     */
    public String getAppendRemark() {
        return appendRemark;
    }

    public void setAppendRemark(String appendRemark) {
        this.appendRemark = appendRemark;
    }

}
