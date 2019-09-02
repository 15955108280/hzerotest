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

import java.util.Date;

/**
 * 询价单操作记录
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@ApiModel("询价单操作记录")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_action")
public class Action extends AuditDomain {

    public static final String FIELD_RFX_ACTION_ID = "rfxActionId";
    public static final String FIELD_RFX_HEADER_ID = "rfxHeaderId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_PROCESS_USER_ID = "processUserId";
    public static final String FIELD_PROCESS_STATUS = "processStatus";
    public static final String FIELD_PROCESS_DATE = "processDate";
    public static final String FIELD_PROCESS_REMARK = "processRemark";
    public static final String FIELD_PROCESS_OPERATION = "processOperation";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long rfxActionId;
    @ApiModelProperty(value = "发票头ID",required = true)
    @NotNull
    private Long rfxHeaderId;
    @ApiModelProperty(value = "租户ID",required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "处理人",required = true)
    @NotNull
    private Long processUserId;
    @ApiModelProperty(value = "询价单状态SSRC.RFX_STATUS",required = true)
    @NotBlank
    private String processStatus;
    @ApiModelProperty(value = "处理日期",required = true)
    @NotNull
    private Date processDate;
   @ApiModelProperty(value = "处理消息")    
    private String processRemark;
   @ApiModelProperty(value = "询价单操作SSRC.RFX_OPERATION")    
    private String processOperation;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
     */
	public Long getRfxActionId() {
		return rfxActionId;
	}

	public void setRfxActionId(Long rfxActionId) {
		this.rfxActionId = rfxActionId;
	}
    /**
     * @return 发票头ID
     */
	public Long getRfxHeaderId() {
		return rfxHeaderId;
	}

	public void setRfxHeaderId(Long rfxHeaderId) {
		this.rfxHeaderId = rfxHeaderId;
	}
    /**
     * @return 租户ID
     */
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
    /**
     * @return 处理人
     */
	public Long getProcessUserId() {
		return processUserId;
	}

	public void setProcessUserId(Long processUserId) {
		this.processUserId = processUserId;
	}
    /**
     * @return 询价单状态SSRC.RFX_STATUS
     */
	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
    /**
     * @return 处理日期
     */
	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
    /**
     * @return 处理消息
     */
	public String getProcessRemark() {
		return processRemark;
	}

	public void setProcessRemark(String processRemark) {
		this.processRemark = processRemark;
	}
    /**
     * @return 询价单操作SSRC.RFX_OPERATION
     */
	public String getProcessOperation() {
		return processOperation;
	}

	public void setProcessOperation(String processOperation) {
		this.processOperation = processOperation;
	}

}
