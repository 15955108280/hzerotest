package org.hzero.test1.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 询价单头表
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@ApiModel("询价单头表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_header")
public class Header extends AuditDomain {

    public static final String FIELD_RFX_HEADER_ID = "rfxHeaderId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_RFX_NUM = "rfxNum";
    public static final String FIELD_RFX_STATUS = "rfxStatus";
    public static final String FIELD_RFX_TITLE = "rfxTitle";
    public static final String FIELD_TEMPLATE_ID = "templateId";
    public static final String FIELD_SOURCE_CATEGORY = "sourceCategory";
    public static final String FIELD_SOURCE_METHOD = "sourceMethod";
    public static final String FIELD_PUR_ORGANIZATION_ID = "purOrganizationId";
    public static final String FIELD_COMPANY_ID = "companyId";
    public static final String FIELD_COMPANY_NAME = "companyName";
    public static final String FIELD_AUCTION_DIRECTION = "auctionDirection";
    public static final String FIELD_BUDGET_AMOUNT = "budgetAmount";
    public static final String FIELD_TAX_INCLUDED_FLAG = "taxIncludedFlag";
    public static final String FIELD_TAX_ID = "taxId";
    public static final String FIELD_TAX_RATE = "taxRate";
    public static final String FIELD_CURRENCY_CODE = "currencyCode";
    public static final String FIELD_EXCHANGE_RATE_ID = "exchangeRateId";
    public static final String FIELD_EXCHANGE_RATE_TYPE = "exchangeRateType";
    public static final String FIELD_EXCHANGE_RATE_DATE = "exchangeRateDate";
    public static final String FIELD_EXCHANGE_RATE_PERIOD = "exchangeRatePeriod";
    public static final String FIELD_EXCHANGE_RATE = "exchangeRate";
    public static final String FIELD_RFX_REMARK = "rfxRemark";
    public static final String FIELD_QUOTATION_START_DATE = "quotationStartDate";
    public static final String FIELD_QUOTATION_END_DATE = "quotationEndDate";
    public static final String FIELD_SEALED_QUOTATION_FLAG = "sealedQuotationFlag";
    public static final String FIELD_OPEN_RULE = "openRule";
    public static final String FIELD_AUCTION_RANKING = "auctionRanking";
    public static final String FIELD_SOURCE_TYPE = "sourceType";
    public static final String FIELD_PRICE_CATEGORY = "priceCategory";
    public static final String FIELD_PAYMENT_TYPE_ID = "paymentTypeId";
    public static final String FIELD_PAYMENT_TERM_ID = "paymentTermId";
    public static final String FIELD_ROUND_NUMBER = "roundNumber";
    public static final String FIELD_VERSION_NUMBER = "versionNumber";
    public static final String FIELD_QUOTATION_ORDER_TYPE = "quotationOrderType";
    public static final String FIELD_QUOTATION_RUNNING_DURATION = "quotationRunningDuration";
    public static final String FIELD_QUOTATION_INTERVAL = "quotationInterval";
    public static final String FIELD_AUCTION_RULE = "auctionRule";
    public static final String FIELD_AUTO_DEFER_FLAG = "autoDeferFlag";
    public static final String FIELD_AUTO_DEFER_DURATION = "autoDeferDuration";
    public static final String FIELD_RELEASED_DATE = "releasedDate";
    public static final String FIELD_RELEASED_BY = "releasedBy";
    public static final String FIELD_TERMINATED_DATE = "terminatedDate";
    public static final String FIELD_TERMINATED_BY = "terminatedBy";
    public static final String FIELD_TERMINATED_REMARK = "terminatedRemark";
    public static final String FIELD_APPROVED_DATE = "approvedDate";
    public static final String FIELD_APPROVED_BY = "approvedBy";
    public static final String FIELD_APPROVED_REMARK = "approvedRemark";
    public static final String FIELD_TIME_ADJUSTED_DATE = "timeAdjustedDate";
    public static final String FIELD_TIME_ADJUSTED_BY = "timeAdjustedBy";
    public static final String FIELD_TIME_ADJUSTED_REMARK = "timeAdjustedRemark";
    public static final String FIELD_CLOSED_FLAG = "closedFlag";
    public static final String FIELD_SOURCE_FROM = "sourceFrom";
    public static final String FIELD_PRETRAIL_REMARK = "pretrailRemark";
    public static final String FIELD_TOTAL_COST = "totalCost";
    public static final String FIELD_COST_REMARK = "costRemark";
    public static final String FIELD_TECH_ATTACHMENT_UUID = "techAttachmentUuid";
    public static final String FIELD_BUSINESS_ATTACHMENT_UUID = "businessAttachmentUuid";
    public static final String FIELD_PRETRIAL_USER_ID = "pretrialUserId";
    public static final String FIELD_BACK_PRETRIAL_REMARK = "backPretrialRemark";
    public static final String FIELD_PRETRIAL_STATUS = "pretrialStatus";
    public static final String FIELD_QUOTATION_TYPE = "quotationType";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------
	public Header(Long tenantId, Long rfxHeaderId){
		this.tenantId = tenantId;
		this.rfxHeaderId = rfxHeaderId;
	}
	public Header(Long tenantId){
		this.tenantId = tenantId;
	}
	public Header(){

	}
    @Id
    @GeneratedValue
    private Long rfxHeaderId;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id")
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "询价单单号",required = true)
    @NotBlank
    private String rfxNum;
    @ApiModelProperty(value = "询价单状态SSRC.RFX_STATUS(NEW/新建|RELEASE_APPROVING/发布审批中|RELEASE_REJECTED/发布审批拒绝|NOT_START/未开始|IN_PREQUAL/资格预审中|PREQUAL_CUTOFF/资格预审截止|IN_QUOTATION/报价中|OPEN_BID_PENDING/待开标|PRETRIAL_PENDING/待初审|SCORING/评分中|CHECK_PENDING/待核价|CHECK_APPROVING/核价审批中|CHECK_REJECTED/核价审批拒绝|FINISHED/完成|PAUSED/暂停|CLOSED/关闭|ROUNDED/再次询价|IN_POSTQUAL/资格后审中|POSTQUAL_CUTOFF/资格后审截止)",required = true)
    @NotBlank
    private String rfxStatus;
    @ApiModelProperty(value = "询价单标题",required = true)
    @NotBlank
    private String rfxTitle;
    @ApiModelProperty(value = "寻源模板ID",required = true)
    @NotNull
    private Long templateId;
    @ApiModelProperty(value = "寻源类别SSRC.SOURCE_CATEGORY(RFQ/询价|RFA/竞价|BID/招投标)",required = true)
    @NotBlank
    private String sourceCategory;
    @ApiModelProperty(value = "询价方式SSRC.SOURCE_METHOD(INVITE/邀请|OPEN/合作伙伴公开|ALL_OPEN/全平台公开)",required = true)
    @NotBlank
    private String sourceMethod;
    @ApiModelProperty(value = "采购方采购组织ID")
    private Long purOrganizationId;
    @ApiModelProperty(value = "采购方企业ID",required = true)
    @NotNull
    private Long companyId;
    @ApiModelProperty(value = "采购方企业名称",required = true)
    @NotBlank
    private String companyName;
    @ApiModelProperty(value = "竞价方向SSRC.SOURCE_AUCTION_DIRECTION(FORWARD/正向|REVERSE/反向)")
    private String auctionDirection;
    @ApiModelProperty(value = "预算金额")
    private BigDecimal budgetAmount;
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
    @ApiModelProperty(value = "汇率")
    private BigDecimal exchangeRate;
    @ApiModelProperty(value = "备注")
    private String rfxRemark;
    @ApiModelProperty(value = "报价开始时间")
    private Date quotationStartDate;
    @ApiModelProperty(value = "报价截止时间")
    private Date quotationEndDate;
    @ApiModelProperty(value = "密封报价标志",required = true)
    @NotNull
    private Integer sealedQuotationFlag;
    @ApiModelProperty(value = "公开规则SSRC.RFA_OPEN_RULE(HIDE_IDENTITY_HIDE_QUOTE/隐藏身份隐藏报价|HIDE_IDENTITY_OPEN_QUOTE/隐藏身份公开报价|OPEN_IDENTITY_HIDE_QUOTE/公开身份隐藏报价|OPEN_IDENTITY_OPEN_QUOTE/公开身份公开报价)")
    private String openRule;
    @ApiModelProperty(value = "竞价排名SSRC.RFA_AUCTION_RANKING(OPEN_COUNT_OPEN_RANK显示参与者数目和当前排名|OPEN_COUNT_HIDE_RANK/显示参与者数目隐藏当前排名|HIDE_COUNT_OPEN_RANK/隐藏参与者数目显示当前排名|HIDE_COUNT_HIDE_RANK/隐藏参与者数目和当前排名)")
    private String auctionRanking;
    @ApiModelProperty(value = "寻源类型SSRC.SOURCE_TYPE(常规|OEM|项目|外协|寄售)",required = true)
    @NotBlank
    private String sourceType;
    @ApiModelProperty(value = "价格类型SSRC.SOURCE_PRICE_CATEGORY(STANDARD/标准|SAMPLE/样品)",required = true)
    @NotBlank
    private String priceCategory;
    @ApiModelProperty(value = "付款方式ID")
    private Long paymentTypeId;
    @ApiModelProperty(value = "付款条款")
    private Long paymentTermId;
    @ApiModelProperty(value = "轮次",required = true)
    @NotNull
    private Long roundNumber;
    @ApiModelProperty(value = "版本",required = true)
    @NotNull
    private Long versionNumber;
    @ApiModelProperty(value = "报价次序SSRC.QUOTATION_ORDER_TYPE(SEQUENCE/序列|STAGGER/交错|PARALLEL/并行)")
    private String quotationOrderType;
    @ApiModelProperty(value = "报价运行时间")
    private BigDecimal quotationRunningDuration;
    @ApiModelProperty(value = "报价时间间隔")
    private BigDecimal quotationInterval;
    @ApiModelProperty(value = "竞价规则SSRC.RFA_AUCTION_RULE(NONE/所有排名允许报相同价格|ALL/所有排名不允许报相同价格|TOP_THREE前三名不允许报相同价格)")
    private String auctionRule;
    @ApiModelProperty(value = "是否启用自动延时",required = true)
    @NotNull
    private Integer autoDeferFlag;
    @ApiModelProperty(value = "延时时长")
    private BigDecimal autoDeferDuration;
    @ApiModelProperty(value = "发布日期")
    private Date releasedDate;
    @ApiModelProperty(value = "发布人")
    private Long releasedBy;
    @ApiModelProperty(value = "终止时间")
    private Date terminatedDate;
    @ApiModelProperty(value = "终止人")
    private Long terminatedBy;
    @ApiModelProperty(value = "终止原因")
    private String terminatedRemark;
    @ApiModelProperty(value = "审批日期")
    private Date approvedDate;
    @ApiModelProperty(value = "审批人")
    private Long approvedBy;
    @ApiModelProperty(value = "审批备注")
    private String approvedRemark;
    @ApiModelProperty(value = "调整时间日期")
    private Date timeAdjustedDate;
    @ApiModelProperty(value = "调整时间人")
    private Long timeAdjustedBy;
    @ApiModelProperty(value = "调整时间原因")
    private String timeAdjustedRemark;
    @ApiModelProperty(value = "关闭标识",required = true)
    @NotNull
    private Integer closedFlag;
    @ApiModelProperty(value = "单据来源(MANUAL/手工创建|DEMAND_POOL/需求池|COPY/复制)",required = true)
    @NotBlank
    private String sourceFrom;
    @ApiModelProperty(value = "初审备注")
    private String pretrailRemark;
    @ApiModelProperty(value = "总成本")
    private BigDecimal totalCost;
    @ApiModelProperty(value = "成本备注")
    private String costRemark;
    @ApiModelProperty(value = "技术附件UUID")
    private String techAttachmentUuid;
    @ApiModelProperty(value = "商务附件UUID")
    private String businessAttachmentUuid;
    @ApiModelProperty(value = "初审审批人")
    private Long pretrialUserId;
    @ApiModelProperty(value = "退回至初审原因")
    private String backPretrialRemark;
    @ApiModelProperty(value = "初审状态(NO_TRIAL/未初审 | SUBMITED/初审提交)")
    private String pretrialStatus;
    @ApiModelProperty(value = "报价方式SSRC.QUOTATION_TYPE(ONLINE/线上报价 | OFFLINE/线下报价 | ON_OFF/线上线下并行) | ",required = true)
    @NotBlank
    private String quotationType;
   /* @ApiModelProperty(value = "订单行")
	@Transient
	private List<LineItem> lineItemList;*/

	//
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    /**
     * @return 
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
     * @return 询价单单号
     */
	public String getRfxNum() {
		return rfxNum;
	}

	public void setRfxNum(String rfxNum) {
		this.rfxNum = rfxNum;
	}
    /**
     * @return 询价单状态SSRC.RFX_STATUS(NEW/新建|RELEASE_APPROVING/发布审批中|RELEASE_REJECTED/发布审批拒绝|NOT_START/未开始|IN_PREQUAL/资格预审中|PREQUAL_CUTOFF/资格预审截止|IN_QUOTATION/报价中|OPEN_BID_PENDING/待开标|PRETRIAL_PENDING/待初审|SCORING/评分中|CHECK_PENDING/待核价|CHECK_APPROVING/核价审批中|CHECK_REJECTED/核价审批拒绝|FINISHED/完成|PAUSED/暂停|CLOSED/关闭|ROUNDED/再次询价|IN_POSTQUAL/资格后审中|POSTQUAL_CUTOFF/资格后审截止)
     */
	public String getRfxStatus() {
		return rfxStatus;
	}

	public void setRfxStatus(String rfxStatus) {
		this.rfxStatus = rfxStatus;
	}
    /**
     * @return 询价单标题
     */
	public String getRfxTitle() {
		return rfxTitle;
	}

	public void setRfxTitle(String rfxTitle) {
		this.rfxTitle = rfxTitle;
	}
    /**
     * @return 寻源模板ID
     */
	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
    /**
     * @return 寻源类别SSRC.SOURCE_CATEGORY(RFQ/询价|RFA/竞价|BID/招投标)
     */
	public String getSourceCategory() {
		return sourceCategory;
	}

	public void setSourceCategory(String sourceCategory) {
		this.sourceCategory = sourceCategory;
	}
    /**
     * @return 询价方式SSRC.SOURCE_METHOD(INVITE/邀请|OPEN/合作伙伴公开|ALL_OPEN/全平台公开)
     */
	public String getSourceMethod() {
		return sourceMethod;
	}

	public void setSourceMethod(String sourceMethod) {
		this.sourceMethod = sourceMethod;
	}
    /**
     * @return 采购方采购组织ID
     */
	public Long getPurOrganizationId() {
		return purOrganizationId;
	}

	public void setPurOrganizationId(Long purOrganizationId) {
		this.purOrganizationId = purOrganizationId;
	}
    /**
     * @return 采购方企业ID
     */
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
    /**
     * @return 采购方企业名称
     */
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
    /**
     * @return 竞价方向SSRC.SOURCE_AUCTION_DIRECTION(FORWARD/正向|REVERSE/反向)
     */
	public String getAuctionDirection() {
		return auctionDirection;
	}

	public void setAuctionDirection(String auctionDirection) {
		this.auctionDirection = auctionDirection;
	}
    /**
     * @return 预算金额
     */
	public BigDecimal getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
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
     * @return 汇率
     */
	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
    /**
     * @return 备注
     */
	public String getRfxRemark() {
		return rfxRemark;
	}

	public void setRfxRemark(String rfxRemark) {
		this.rfxRemark = rfxRemark;
	}
    /**
     * @return 报价开始时间
     */
	public Date getQuotationStartDate() {
		return quotationStartDate;
	}

	public void setQuotationStartDate(Date quotationStartDate) {
		this.quotationStartDate = quotationStartDate;
	}
    /**
     * @return 报价截止时间
     */
	public Date getQuotationEndDate() {
		return quotationEndDate;
	}

	public void setQuotationEndDate(Date quotationEndDate) {
		this.quotationEndDate = quotationEndDate;
	}
    /**
     * @return 密封报价标志
     */
	public Integer getSealedQuotationFlag() {
		return sealedQuotationFlag;
	}

	public void setSealedQuotationFlag(Integer sealedQuotationFlag) {
		this.sealedQuotationFlag = sealedQuotationFlag;
	}
    /**
     * @return 公开规则SSRC.RFA_OPEN_RULE(HIDE_IDENTITY_HIDE_QUOTE/隐藏身份隐藏报价|HIDE_IDENTITY_OPEN_QUOTE/隐藏身份公开报价|OPEN_IDENTITY_HIDE_QUOTE/公开身份隐藏报价|OPEN_IDENTITY_OPEN_QUOTE/公开身份公开报价)
     */
	public String getOpenRule() {
		return openRule;
	}

	public void setOpenRule(String openRule) {
		this.openRule = openRule;
	}
    /**
     * @return 竞价排名SSRC.RFA_AUCTION_RANKING(OPEN_COUNT_OPEN_RANK显示参与者数目和当前排名|OPEN_COUNT_HIDE_RANK/显示参与者数目隐藏当前排名|HIDE_COUNT_OPEN_RANK/隐藏参与者数目显示当前排名|HIDE_COUNT_HIDE_RANK/隐藏参与者数目和当前排名)
     */
	public String getAuctionRanking() {
		return auctionRanking;
	}

	public void setAuctionRanking(String auctionRanking) {
		this.auctionRanking = auctionRanking;
	}
    /**
     * @return 寻源类型SSRC.SOURCE_TYPE(常规|OEM|项目|外协|寄售)
     */
	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
    /**
     * @return 价格类型SSRC.SOURCE_PRICE_CATEGORY(STANDARD/标准|SAMPLE/样品)
     */
	public String getPriceCategory() {
		return priceCategory;
	}

	public void setPriceCategory(String priceCategory) {
		this.priceCategory = priceCategory;
	}
    /**
     * @return 付款方式ID
     */
	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
    /**
     * @return 付款条款
     */
	public Long getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
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
     * @return 版本
     */
	public Long getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Long versionNumber) {
		this.versionNumber = versionNumber;
	}
    /**
     * @return 报价次序SSRC.QUOTATION_ORDER_TYPE(SEQUENCE/序列|STAGGER/交错|PARALLEL/并行)
     */
	public String getQuotationOrderType() {
		return quotationOrderType;
	}

	public void setQuotationOrderType(String quotationOrderType) {
		this.quotationOrderType = quotationOrderType;
	}
    /**
     * @return 报价运行时间
     */
	public BigDecimal getQuotationRunningDuration() {
		return quotationRunningDuration;
	}

	public void setQuotationRunningDuration(BigDecimal quotationRunningDuration) {
		this.quotationRunningDuration = quotationRunningDuration;
	}
    /**
     * @return 报价时间间隔
     */
	public BigDecimal getQuotationInterval() {
		return quotationInterval;
	}

	public void setQuotationInterval(BigDecimal quotationInterval) {
		this.quotationInterval = quotationInterval;
	}
    /**
     * @return 竞价规则SSRC.RFA_AUCTION_RULE(NONE/所有排名允许报相同价格|ALL/所有排名不允许报相同价格|TOP_THREE前三名不允许报相同价格)
     */
	public String getAuctionRule() {
		return auctionRule;
	}

	public void setAuctionRule(String auctionRule) {
		this.auctionRule = auctionRule;
	}
    /**
     * @return 是否启用自动延时
     */
	public Integer getAutoDeferFlag() {
		return autoDeferFlag;
	}

	public void setAutoDeferFlag(Integer autoDeferFlag) {
		this.autoDeferFlag = autoDeferFlag;
	}
    /**
     * @return 延时时长
     */
	public BigDecimal getAutoDeferDuration() {
		return autoDeferDuration;
	}

	public void setAutoDeferDuration(BigDecimal autoDeferDuration) {
		this.autoDeferDuration = autoDeferDuration;
	}
    /**
     * @return 发布日期
     */
	public Date getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}
    /**
     * @return 发布人
     */
	public Long getReleasedBy() {
		return releasedBy;
	}

	public void setReleasedBy(Long releasedBy) {
		this.releasedBy = releasedBy;
	}
    /**
     * @return 终止时间
     */
	public Date getTerminatedDate() {
		return terminatedDate;
	}

	public void setTerminatedDate(Date terminatedDate) {
		this.terminatedDate = terminatedDate;
	}
    /**
     * @return 终止人
     */
	public Long getTerminatedBy() {
		return terminatedBy;
	}

	public void setTerminatedBy(Long terminatedBy) {
		this.terminatedBy = terminatedBy;
	}
    /**
     * @return 终止原因
     */
	public String getTerminatedRemark() {
		return terminatedRemark;
	}

	public void setTerminatedRemark(String terminatedRemark) {
		this.terminatedRemark = terminatedRemark;
	}
    /**
     * @return 审批日期
     */
	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
    /**
     * @return 审批人
     */
	public Long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}
    /**
     * @return 审批备注
     */
	public String getApprovedRemark() {
		return approvedRemark;
	}

	public void setApprovedRemark(String approvedRemark) {
		this.approvedRemark = approvedRemark;
	}
    /**
     * @return 调整时间日期
     */
	public Date getTimeAdjustedDate() {
		return timeAdjustedDate;
	}

	public void setTimeAdjustedDate(Date timeAdjustedDate) {
		this.timeAdjustedDate = timeAdjustedDate;
	}
    /**
     * @return 调整时间人
     */
	public Long getTimeAdjustedBy() {
		return timeAdjustedBy;
	}

	public void setTimeAdjustedBy(Long timeAdjustedBy) {
		this.timeAdjustedBy = timeAdjustedBy;
	}
    /**
     * @return 调整时间原因
     */
	public String getTimeAdjustedRemark() {
		return timeAdjustedRemark;
	}

	public void setTimeAdjustedRemark(String timeAdjustedRemark) {
		this.timeAdjustedRemark = timeAdjustedRemark;
	}
    /**
     * @return 关闭标识
     */
	public Integer getClosedFlag() {
		return closedFlag;
	}

	public void setClosedFlag(Integer closedFlag) {
		this.closedFlag = closedFlag;
	}
    /**
     * @return 单据来源(MANUAL/手工创建|DEMAND_POOL/需求池|COPY/复制)
     */
	public String getSourceFrom() {
		return sourceFrom;
	}

	public void setSourceFrom(String sourceFrom) {
		this.sourceFrom = sourceFrom;
	}
    /**
     * @return 初审备注
     */
	public String getPretrailRemark() {
		return pretrailRemark;
	}

	public void setPretrailRemark(String pretrailRemark) {
		this.pretrailRemark = pretrailRemark;
	}
    /**
     * @return 总成本
     */
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
    /**
     * @return 成本备注
     */
	public String getCostRemark() {
		return costRemark;
	}

	public void setCostRemark(String costRemark) {
		this.costRemark = costRemark;
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
     * @return 商务附件UUID
     */
	public String getBusinessAttachmentUuid() {
		return businessAttachmentUuid;
	}

	public void setBusinessAttachmentUuid(String businessAttachmentUuid) {
		this.businessAttachmentUuid = businessAttachmentUuid;
	}
    /**
     * @return 初审审批人
     */
	public Long getPretrialUserId() {
		return pretrialUserId;
	}

	public void setPretrialUserId(Long pretrialUserId) {
		this.pretrialUserId = pretrialUserId;
	}
    /**
     * @return 退回至初审原因
     */
	public String getBackPretrialRemark() {
		return backPretrialRemark;
	}

	public void setBackPretrialRemark(String backPretrialRemark) {
		this.backPretrialRemark = backPretrialRemark;
	}
    /**
     * @return 初审状态(NO_TRIAL/未初审 | SUBMITED/初审提交)
     */
	public String getPretrialStatus() {
		return pretrialStatus;
	}

	public void setPretrialStatus(String pretrialStatus) {
		this.pretrialStatus = pretrialStatus;
	}
    /**
     * @return 报价方式SSRC.QUOTATION_TYPE(ONLINE/线上报价 | OFFLINE/线下报价 | ON_OFF/线上线下并行) | 
     */
	public String getQuotationType() {
		return quotationType;
	}

	public void setQuotationType(String quotationType) {
		this.quotationType = quotationType;
	}

/*	public List<LineItem> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(List<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}*/
}
