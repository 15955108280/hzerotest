package org.hzero.test1.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

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
 * 报价单头表
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@ApiModel("报价单头表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_quotation_header")
public class QuotationHeader extends AuditDomain {

    public static final String FIELD_QUOTATION_HEADER_ID = "quotationHeaderId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_RFX_HEADER_ID = "rfxHeaderId";
    public static final String FIELD_QUOTATION_NUM = "quotationNum";
    public static final String FIELD_ROUND_NUMBER = "roundNumber";
    public static final String FIELD_QUOTATION_STATUS = "quotationStatus";
    public static final String FIELD_SUPPLIER_TENANT_ID = "supplierTenantId";
    public static final String FIELD_SUPPLIER_COMPANY_ID = "supplierCompanyId";
    public static final String FIELD_SUPPLIER_COMPANY_NAME = "supplierCompanyName";
    public static final String FIELD_TAX_INCLUDED_FLAG = "taxIncludedFlag";
    public static final String FIELD_TAX_ID = "taxId";
    public static final String FIELD_TAX_RATE = "taxRate";
    public static final String FIELD_CURRENCY_CODE = "currencyCode";
    public static final String FIELD_EXCHANGE_RATE_ID = "exchangeRateId";
    public static final String FIELD_EXCHANGE_RATE_TYPE = "exchangeRateType";
    public static final String FIELD_EXCHANGE_RATE_DATE = "exchangeRateDate";
    public static final String FIELD_EXCHANGE_RATE_PERIOD = "exchangeRatePeriod";
    public static final String FIELD_QUOTATION_REMARK = "quotationRemark";
    public static final String FIELD_BUSINESS_ATTACHMENT_UUID = "businessAttachmentUuid";
    public static final String FIELD_TECH_ATTACHMENT_UUID = "techAttachmentUuid";
    public static final String FIELD_ENTRY_METHOD = "entryMethod";
    public static final String FIELD_SUBMIT_ATTACHMENT_FLAG = "submitAttachmentFlag";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long quotationHeaderId;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id",required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "RFx单头ID",required = true)
    @NotNull
    private Long rfxHeaderId;
    @ApiModelProperty(value = "RFx报价单号",required = true)
    @NotBlank
    private String quotationNum;
    @ApiModelProperty(value = "轮次",required = true)
    @NotNull
    private Long roundNumber;
    @ApiModelProperty(value = "报价单状态SSRC.RFX_QUOTATION_STATUS(NEW/新建|QUOTED/已报价|FINISHED/结束)",required = true)
    @NotBlank
    private String quotationStatus;
   @ApiModelProperty(value = "")    
    private Long supplierTenantId;
   @ApiModelProperty(value = "")    
    private Long supplierCompanyId;
    @ApiModelProperty(value = "供应方企业名称",required = true)
    @NotBlank
    private String supplierCompanyName;
    @ApiModelProperty(value = "含税标识",required = true)
    @NotNull
    private Integer taxIncludedFlag;
   @ApiModelProperty(value = "税率ID")    
    private Long taxId;
   @ApiModelProperty(value = "税率")    
    private BigDecimal taxRate;
    @ApiModelProperty(value = "币种",required = true)
    @NotBlank
    private String currencyCode;
   @ApiModelProperty(value = "汇率")    
    private Long exchangeRateId;
   @ApiModelProperty(value = "汇率类型")    
    private String exchangeRateType;
   @ApiModelProperty(value = "汇率日期")    
    private Date exchangeRateDate;
   @ApiModelProperty(value = "汇率期间")    
    private String exchangeRatePeriod;
   @ApiModelProperty(value = "备注")    
    private String quotationRemark;
   @ApiModelProperty(value = "商务附件UUID")    
    private String businessAttachmentUuid;
   @ApiModelProperty(value = "技术附件UUID")    
    private String techAttachmentUuid;
    @ApiModelProperty(value = "录入方式，SSRC.RFX_QUOTATION.ENTRY_METHOD(OFFLINE/线下录入|ONLINE/线上录入)",required = true)
    @NotBlank
    private String entryMethod;
   @ApiModelProperty(value = "报价单头附件提交标识")    
    private Integer submitAttachmentFlag;

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
     */
	public Long getQuotationHeaderId() {
		return quotationHeaderId;
	}

	public void setQuotationHeaderId(Long quotationHeaderId) {
		this.quotationHeaderId = quotationHeaderId;
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
     * @return RFx单头ID
     */
	public Long getRfxHeaderId() {
		return rfxHeaderId;
	}

	public void setRfxHeaderId(Long rfxHeaderId) {
		this.rfxHeaderId = rfxHeaderId;
	}
    /**
     * @return RFx报价单号
     */
	public String getQuotationNum() {
		return quotationNum;
	}

	public void setQuotationNum(String quotationNum) {
		this.quotationNum = quotationNum;
	}
    /**
     * @return 轮次
     */
	public Long getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(Long roundNumber) {
		this.roundNumber = roundNumber;
	}
    /**
     * @return 报价单状态SSRC.RFX_QUOTATION_STATUS(NEW/新建|QUOTED/已报价|FINISHED/结束)
     */
	public String getQuotationStatus() {
		return quotationStatus;
	}

	public void setQuotationStatus(String quotationStatus) {
		this.quotationStatus = quotationStatus;
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
     * @return 含税标识
     */
	public Integer getTaxIncludedFlag() {
		return taxIncludedFlag;
	}

	public void setTaxIncludedFlag(Integer taxIncludedFlag) {
		this.taxIncludedFlag = taxIncludedFlag;
	}
    /**
     * @return 税率ID
     */
	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}
    /**
     * @return 税率
     */
	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
    /**
     * @return 币种
     */
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
    /**
     * @return 汇率
     */
	public Long getExchangeRateId() {
		return exchangeRateId;
	}

	public void setExchangeRateId(Long exchangeRateId) {
		this.exchangeRateId = exchangeRateId;
	}
    /**
     * @return 汇率类型
     */
	public String getExchangeRateType() {
		return exchangeRateType;
	}

	public void setExchangeRateType(String exchangeRateType) {
		this.exchangeRateType = exchangeRateType;
	}
    /**
     * @return 汇率日期
     */
	public Date getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}
    /**
     * @return 汇率期间
     */
	public String getExchangeRatePeriod() {
		return exchangeRatePeriod;
	}

	public void setExchangeRatePeriod(String exchangeRatePeriod) {
		this.exchangeRatePeriod = exchangeRatePeriod;
	}
    /**
     * @return 备注
     */
	public String getQuotationRemark() {
		return quotationRemark;
	}

	public void setQuotationRemark(String quotationRemark) {
		this.quotationRemark = quotationRemark;
	}
    /**
     * @return 商务附件UUID
     */
	public String getBusinessAttachmentUuid() {
		return businessAttachmentUuid;
	}

	public void setBusinessAttachmentUuid(String businessAttachmentUuid) {
		this.businessAttachmentUuid = businessAttachmentUuid;
	}
    /**
     * @return 技术附件UUID
     */
	public String getTechAttachmentUuid() {
		return techAttachmentUuid;
	}

	public void setTechAttachmentUuid(String techAttachmentUuid) {
		this.techAttachmentUuid = techAttachmentUuid;
	}
    /**
     * @return 录入方式，SSRC.RFX_QUOTATION.ENTRY_METHOD(OFFLINE/线下录入|ONLINE/线上录入)
     */
	public String getEntryMethod() {
		return entryMethod;
	}

	public void setEntryMethod(String entryMethod) {
		this.entryMethod = entryMethod;
	}
    /**
     * @return 报价单头附件提交标识
     */
	public Integer getSubmitAttachmentFlag() {
		return submitAttachmentFlag;
	}

	public void setSubmitAttachmentFlag(Integer submitAttachmentFlag) {
		this.submitAttachmentFlag = submitAttachmentFlag;
	}

}
