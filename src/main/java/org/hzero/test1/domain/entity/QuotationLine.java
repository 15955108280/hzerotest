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
 * 报价单行表
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@ApiModel("报价单行表")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_quotation_line")
public class QuotationLine extends AuditDomain {

    public static final String FIELD_QUOTATION_LINE_ID = "quotationLineId";
    public static final String FIELD_QUOTATION_HEADER_ID = "quotationHeaderId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_QUOTATION_LINE_STATUS = "quotationLineStatus";
    public static final String FIELD_RFX_LINE_ITEM_ID = "rfxLineItemId";
    public static final String FIELD_ROUND_NUMBER = "roundNumber";
    public static final String FIELD_TAX_INCLUDED_FLAG = "taxIncludedFlag";
    public static final String FIELD_TAX_ID = "taxId";
    public static final String FIELD_TAX_RATE = "taxRate";
    public static final String FIELD_QUOTED_DATE = "quotedDate";
    public static final String FIELD_PRICE_BATCH_QUANTITY = "priceBatchQuantity";
    public static final String FIELD_MIN_PURCHASE_QUANTITY = "minPurchaseQuantity";
    public static final String FIELD_MIN_PACKAGE_QUANTITY = "minPackageQuantity";
    public static final String FIELD_FREIGHT_AMOUNT = "freightAmount";
    public static final String FIELD_BARGAIN_FLAG = "bargainFlag";
    public static final String FIELD_BARGAIN_DATE = "bargainDate";
    public static final String FIELD_VALID_PROMISED_DATE = "validPromisedDate";
    public static final String FIELD_VALID_DELIVERY_CYCLE = "validDeliveryCycle";
    public static final String FIELD_VALID_EXPIRY_DATE_FROM = "validExpiryDateFrom";
    public static final String FIELD_VALID_EXPIRY_DATE_TO = "validExpiryDateTo";
    public static final String FIELD_VALID_QUOTED_BY = "validQuotedBy";
    public static final String FIELD_VALID_QUOTATION_QUANTITY = "validQuotationQuantity";
    public static final String FIELD_VALID_QUOTATION_PRICE = "validQuotationPrice";
    public static final String FIELD_VALID_QUOTATION_REMARK = "validQuotationRemark";
    public static final String FIELD_VALID_BARGAIN_BY = "validBargainBy";
    public static final String FIELD_VALID_BARGAIN_QUANTITY = "validBargainQuantity";
    public static final String FIELD_VALID_BARGAIN_PRICE = "validBargainPrice";
    public static final String FIELD_VALID_BARGAIN_REMARK = "validBargainRemark";
    public static final String FIELD_CURRENT_PROMISED_DATE = "currentPromisedDate";
    public static final String FIELD_CURRENT_DELIVERY_CYCLE = "currentDeliveryCycle";
    public static final String FIELD_CURRENT_EXPIRY_DATE_FROM = "currentExpiryDateFrom";
    public static final String FIELD_CURRENT_EXPIRY_DATE_TO = "currentExpiryDateTo";
    public static final String FIELD_CURRENT_QUOTED_BY = "currentQuotedBy";
    public static final String FIELD_CURRENT_QUOTATION_QUANTITY = "currentQuotationQuantity";
    public static final String FIELD_CURRENT_QUOTATION_PRICE = "currentQuotationPrice";
    public static final String FIELD_CURRENT_QUOTATION_REMARK = "currentQuotationRemark";
    public static final String FIELD_CURRENT_BARGAIN_BY = "currentBargainBy";
    public static final String FIELD_CURRENT_BARGAIN_QUANTITY = "currentBargainQuantity";
    public static final String FIELD_CURRENT_BARGAIN_PRICE = "currentBargainPrice";
    public static final String FIELD_CURRENT_BARGAIN_REMARK = "currentBargainRemark";
    public static final String FIELD_NET_PRICE = "netPrice";
    public static final String FIELD_TAX_PRICE = "taxPrice";
    public static final String FIELD_NET_AMOUNT = "netAmount";
    public static final String FIELD_TAX_AMOUNT = "taxAmount";
    public static final String FIELD_TOTAL_AMOUNT = "totalAmount";
    public static final String FIELD_SUGGESTED_FLAG = "suggestedFlag";
    public static final String FIELD_SUGGESTED_BY = "suggestedBy";
    public static final String FIELD_SUGGESTED_REMARK = "suggestedRemark";
    public static final String FIELD_ALLOTTED_QUANTITY = "allottedQuantity";
    public static final String FIELD_ATTACHMENT_UUID = "attachmentUuid";
    public static final String FIELD_ABANDONED_FLAG = "abandonedFlag";
    public static final String FIELD_CURRENT_ATTACHMENT_UUID = "currentAttachmentUuid";
    public static final String FIELD_RANK = "rank";
    public static final String FIELD_TREND_FLAG = "trendFlag";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long quotationLineId;
    @ApiModelProperty(value = "询价单头ID",required = true)
    @NotNull
    private Long quotationHeaderId;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id",required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "报价单行状态SSRC.RFX_QUOTATION_LINE_STATUS(NEW/新建|SUBMITTED/已报价|BARGAINED/已还价|TAKEN_BACK/收回|ABANDONED/放弃)",required = true)
    @NotBlank
    private String quotationLineStatus;
    @ApiModelProperty(value = "询价单物料行ID",required = true)
    @NotNull
    private Long rfxLineItemId;
    @ApiModelProperty(value = "轮次",required = true)
    @NotNull
    private Long roundNumber;
    @ApiModelProperty(value = "含税标识",required = true)
    @NotNull
    private Integer taxIncludedFlag;
   @ApiModelProperty(value = "税率ID")    
    private Long taxId;
   @ApiModelProperty(value = "税率")    
    private BigDecimal taxRate;
   @ApiModelProperty(value = "报价时间")    
    private Date quotedDate;
   @ApiModelProperty(value = "价格批量")    
    private BigDecimal priceBatchQuantity;
   @ApiModelProperty(value = "最小采购量")    
    private BigDecimal minPurchaseQuantity;
   @ApiModelProperty(value = "最小包装量")    
    private BigDecimal minPackageQuantity;
   @ApiModelProperty(value = "运费金额")    
    private BigDecimal freightAmount;
    @ApiModelProperty(value = "还价标志",required = true)
    @NotNull
    private Integer bargainFlag;
   @ApiModelProperty(value = "还价时间")    
    private Date bargainDate;
   @ApiModelProperty(value = "承诺交货日期")    
    private Date validPromisedDate;
   @ApiModelProperty(value = "供货周期")    
    private String validDeliveryCycle;
   @ApiModelProperty(value = "报价有效期从")    
    private Date validExpiryDateFrom;
   @ApiModelProperty(value = "报价有效期至")    
    private Date validExpiryDateTo;
   @ApiModelProperty(value = "有效报价人")    
    private Long validQuotedBy;
   @ApiModelProperty(value = "有效报价数量")    
    private BigDecimal validQuotationQuantity;
   @ApiModelProperty(value = "有效报价价格")    
    private BigDecimal validQuotationPrice;
   @ApiModelProperty(value = "有效报价理由")    
    private String validQuotationRemark;
   @ApiModelProperty(value = "有效还价人")    
    private Long validBargainBy;
   @ApiModelProperty(value = "有效还价数量")    
    private BigDecimal validBargainQuantity;
   @ApiModelProperty(value = "有效还价单价")    
    private BigDecimal validBargainPrice;
   @ApiModelProperty(value = "有效还价理由")    
    private String validBargainRemark;
   @ApiModelProperty(value = "当前承诺交货日期")    
    private Date currentPromisedDate;
   @ApiModelProperty(value = "当前报价的供货周期")    
    private String currentDeliveryCycle;
   @ApiModelProperty(value = "当前报价有效期从")    
    private Date currentExpiryDateFrom;
   @ApiModelProperty(value = "当前报价有效期到")    
    private Date currentExpiryDateTo;
   @ApiModelProperty(value = "当前报价人")    
    private Long currentQuotedBy;
   @ApiModelProperty(value = "当前报价数量")    
    private BigDecimal currentQuotationQuantity;
   @ApiModelProperty(value = "当前报价单价")    
    private BigDecimal currentQuotationPrice;
   @ApiModelProperty(value = "当前报价理由")    
    private String currentQuotationRemark;
   @ApiModelProperty(value = "当前还价人")    
    private Long currentBargainBy;
   @ApiModelProperty(value = "当前还价数量")    
    private BigDecimal currentBargainQuantity;
   @ApiModelProperty(value = "当前还价单价")    
    private BigDecimal currentBargainPrice;
   @ApiModelProperty(value = "当前还价理由")    
    private String currentBargainRemark;
   @ApiModelProperty(value = "不含税单价")    
    private BigDecimal netPrice;
   @ApiModelProperty(value = "含税单价")    
    private BigDecimal taxPrice;
   @ApiModelProperty(value = "不含税金额")    
    private BigDecimal netAmount;
   @ApiModelProperty(value = "税额")    
    private BigDecimal taxAmount;
   @ApiModelProperty(value = "含税金额")    
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "建议选用标志",required = true)
    @NotNull
    private Integer suggestedFlag;
   @ApiModelProperty(value = "建议人")    
    private Long suggestedBy;
   @ApiModelProperty(value = "建议选用理由")    
    private String suggestedRemark;
   @ApiModelProperty(value = "分配数量")    
    private BigDecimal allottedQuantity;
   @ApiModelProperty(value = "附件UUID")    
    private String attachmentUuid;
    @ApiModelProperty(value = "放弃标识",required = true)
    @NotNull
    private Integer abandonedFlag;
   @ApiModelProperty(value = "当前附件UUID")    
    private String currentAttachmentUuid;
   @ApiModelProperty(value = "排名")    
    private Long rank;
   @ApiModelProperty(value = "趋势")    
    private Long trendFlag;

   public QuotationLine(){

   }
   public QuotationLine(Long tenantId,Long rfxLineItemId){
   	this.tenantId = tenantId;
   	this.rfxLineItemId = rfxLineItemId;
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
	public Long getQuotationLineId() {
		return quotationLineId;
	}

	public void setQuotationLineId(Long quotationLineId) {
		this.quotationLineId = quotationLineId;
	}
    /**
     * @return 询价单头ID
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
     * @return 报价单行状态SSRC.RFX_QUOTATION_LINE_STATUS(NEW/新建|SUBMITTED/已报价|BARGAINED/已还价|TAKEN_BACK/收回|ABANDONED/放弃)
     */
	public String getQuotationLineStatus() {
		return quotationLineStatus;
	}

	public void setQuotationLineStatus(String quotationLineStatus) {
		this.quotationLineStatus = quotationLineStatus;
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
     * @return 轮次
     */
	public Long getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(Long roundNumber) {
		this.roundNumber = roundNumber;
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
     * @return 报价时间
     */
	public Date getQuotedDate() {
		return quotedDate;
	}

	public void setQuotedDate(Date quotedDate) {
		this.quotedDate = quotedDate;
	}
    /**
     * @return 价格批量
     */
	public BigDecimal getPriceBatchQuantity() {
		return priceBatchQuantity;
	}

	public void setPriceBatchQuantity(BigDecimal priceBatchQuantity) {
		this.priceBatchQuantity = priceBatchQuantity;
	}
    /**
     * @return 最小采购量
     */
	public BigDecimal getMinPurchaseQuantity() {
		return minPurchaseQuantity;
	}

	public void setMinPurchaseQuantity(BigDecimal minPurchaseQuantity) {
		this.minPurchaseQuantity = minPurchaseQuantity;
	}
    /**
     * @return 最小包装量
     */
	public BigDecimal getMinPackageQuantity() {
		return minPackageQuantity;
	}

	public void setMinPackageQuantity(BigDecimal minPackageQuantity) {
		this.minPackageQuantity = minPackageQuantity;
	}
    /**
     * @return 运费金额
     */
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}
    /**
     * @return 还价标志
     */
	public Integer getBargainFlag() {
		return bargainFlag;
	}

	public void setBargainFlag(Integer bargainFlag) {
		this.bargainFlag = bargainFlag;
	}
    /**
     * @return 还价时间
     */
	public Date getBargainDate() {
		return bargainDate;
	}

	public void setBargainDate(Date bargainDate) {
		this.bargainDate = bargainDate;
	}
    /**
     * @return 承诺交货日期
     */
	public Date getValidPromisedDate() {
		return validPromisedDate;
	}

	public void setValidPromisedDate(Date validPromisedDate) {
		this.validPromisedDate = validPromisedDate;
	}
    /**
     * @return 供货周期
     */
	public String getValidDeliveryCycle() {
		return validDeliveryCycle;
	}

	public void setValidDeliveryCycle(String validDeliveryCycle) {
		this.validDeliveryCycle = validDeliveryCycle;
	}
    /**
     * @return 报价有效期从
     */
	public Date getValidExpiryDateFrom() {
		return validExpiryDateFrom;
	}

	public void setValidExpiryDateFrom(Date validExpiryDateFrom) {
		this.validExpiryDateFrom = validExpiryDateFrom;
	}
    /**
     * @return 报价有效期至
     */
	public Date getValidExpiryDateTo() {
		return validExpiryDateTo;
	}

	public void setValidExpiryDateTo(Date validExpiryDateTo) {
		this.validExpiryDateTo = validExpiryDateTo;
	}
    /**
     * @return 有效报价人
     */
	public Long getValidQuotedBy() {
		return validQuotedBy;
	}

	public void setValidQuotedBy(Long validQuotedBy) {
		this.validQuotedBy = validQuotedBy;
	}
    /**
     * @return 有效报价数量
     */
	public BigDecimal getValidQuotationQuantity() {
		return validQuotationQuantity;
	}

	public void setValidQuotationQuantity(BigDecimal validQuotationQuantity) {
		this.validQuotationQuantity = validQuotationQuantity;
	}
    /**
     * @return 有效报价价格
     */
	public BigDecimal getValidQuotationPrice() {
		return validQuotationPrice;
	}

	public void setValidQuotationPrice(BigDecimal validQuotationPrice) {
		this.validQuotationPrice = validQuotationPrice;
	}
    /**
     * @return 有效报价理由
     */
	public String getValidQuotationRemark() {
		return validQuotationRemark;
	}

	public void setValidQuotationRemark(String validQuotationRemark) {
		this.validQuotationRemark = validQuotationRemark;
	}
    /**
     * @return 有效还价人
     */
	public Long getValidBargainBy() {
		return validBargainBy;
	}

	public void setValidBargainBy(Long validBargainBy) {
		this.validBargainBy = validBargainBy;
	}
    /**
     * @return 有效还价数量
     */
	public BigDecimal getValidBargainQuantity() {
		return validBargainQuantity;
	}

	public void setValidBargainQuantity(BigDecimal validBargainQuantity) {
		this.validBargainQuantity = validBargainQuantity;
	}
    /**
     * @return 有效还价单价
     */
	public BigDecimal getValidBargainPrice() {
		return validBargainPrice;
	}

	public void setValidBargainPrice(BigDecimal validBargainPrice) {
		this.validBargainPrice = validBargainPrice;
	}
    /**
     * @return 有效还价理由
     */
	public String getValidBargainRemark() {
		return validBargainRemark;
	}

	public void setValidBargainRemark(String validBargainRemark) {
		this.validBargainRemark = validBargainRemark;
	}
    /**
     * @return 当前承诺交货日期
     */
	public Date getCurrentPromisedDate() {
		return currentPromisedDate;
	}

	public void setCurrentPromisedDate(Date currentPromisedDate) {
		this.currentPromisedDate = currentPromisedDate;
	}
    /**
     * @return 当前报价的供货周期
     */
	public String getCurrentDeliveryCycle() {
		return currentDeliveryCycle;
	}

	public void setCurrentDeliveryCycle(String currentDeliveryCycle) {
		this.currentDeliveryCycle = currentDeliveryCycle;
	}
    /**
     * @return 当前报价有效期从
     */
	public Date getCurrentExpiryDateFrom() {
		return currentExpiryDateFrom;
	}

	public void setCurrentExpiryDateFrom(Date currentExpiryDateFrom) {
		this.currentExpiryDateFrom = currentExpiryDateFrom;
	}
    /**
     * @return 当前报价有效期到
     */
	public Date getCurrentExpiryDateTo() {
		return currentExpiryDateTo;
	}

	public void setCurrentExpiryDateTo(Date currentExpiryDateTo) {
		this.currentExpiryDateTo = currentExpiryDateTo;
	}
    /**
     * @return 当前报价人
     */
	public Long getCurrentQuotedBy() {
		return currentQuotedBy;
	}

	public void setCurrentQuotedBy(Long currentQuotedBy) {
		this.currentQuotedBy = currentQuotedBy;
	}
    /**
     * @return 当前报价数量
     */
	public BigDecimal getCurrentQuotationQuantity() {
		return currentQuotationQuantity;
	}

	public void setCurrentQuotationQuantity(BigDecimal currentQuotationQuantity) {
		this.currentQuotationQuantity = currentQuotationQuantity;
	}
    /**
     * @return 当前报价单价
     */
	public BigDecimal getCurrentQuotationPrice() {
		return currentQuotationPrice;
	}

	public void setCurrentQuotationPrice(BigDecimal currentQuotationPrice) {
		this.currentQuotationPrice = currentQuotationPrice;
	}
    /**
     * @return 当前报价理由
     */
	public String getCurrentQuotationRemark() {
		return currentQuotationRemark;
	}

	public void setCurrentQuotationRemark(String currentQuotationRemark) {
		this.currentQuotationRemark = currentQuotationRemark;
	}
    /**
     * @return 当前还价人
     */
	public Long getCurrentBargainBy() {
		return currentBargainBy;
	}

	public void setCurrentBargainBy(Long currentBargainBy) {
		this.currentBargainBy = currentBargainBy;
	}
    /**
     * @return 当前还价数量
     */
	public BigDecimal getCurrentBargainQuantity() {
		return currentBargainQuantity;
	}

	public void setCurrentBargainQuantity(BigDecimal currentBargainQuantity) {
		this.currentBargainQuantity = currentBargainQuantity;
	}
    /**
     * @return 当前还价单价
     */
	public BigDecimal getCurrentBargainPrice() {
		return currentBargainPrice;
	}

	public void setCurrentBargainPrice(BigDecimal currentBargainPrice) {
		this.currentBargainPrice = currentBargainPrice;
	}
    /**
     * @return 当前还价理由
     */
	public String getCurrentBargainRemark() {
		return currentBargainRemark;
	}

	public void setCurrentBargainRemark(String currentBargainRemark) {
		this.currentBargainRemark = currentBargainRemark;
	}
    /**
     * @return 不含税单价
     */
	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}
    /**
     * @return 含税单价
     */
	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}
    /**
     * @return 不含税金额
     */
	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}
    /**
     * @return 税额
     */
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
    /**
     * @return 含税金额
     */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
    /**
     * @return 建议选用标志
     */
	public Integer getSuggestedFlag() {
		return suggestedFlag;
	}

	public void setSuggestedFlag(Integer suggestedFlag) {
		this.suggestedFlag = suggestedFlag;
	}
    /**
     * @return 建议人
     */
	public Long getSuggestedBy() {
		return suggestedBy;
	}

	public void setSuggestedBy(Long suggestedBy) {
		this.suggestedBy = suggestedBy;
	}
    /**
     * @return 建议选用理由
     */
	public String getSuggestedRemark() {
		return suggestedRemark;
	}

	public void setSuggestedRemark(String suggestedRemark) {
		this.suggestedRemark = suggestedRemark;
	}
    /**
     * @return 分配数量
     */
	public BigDecimal getAllottedQuantity() {
		return allottedQuantity;
	}

	public void setAllottedQuantity(BigDecimal allottedQuantity) {
		this.allottedQuantity = allottedQuantity;
	}
    /**
     * @return 附件UUID
     */
	public String getAttachmentUuid() {
		return attachmentUuid;
	}

	public void setAttachmentUuid(String attachmentUuid) {
		this.attachmentUuid = attachmentUuid;
	}
    /**
     * @return 放弃标识
     */
	public Integer getAbandonedFlag() {
		return abandonedFlag;
	}

	public void setAbandonedFlag(Integer abandonedFlag) {
		this.abandonedFlag = abandonedFlag;
	}
    /**
     * @return 当前附件UUID
     */
	public String getCurrentAttachmentUuid() {
		return currentAttachmentUuid;
	}

	public void setCurrentAttachmentUuid(String currentAttachmentUuid) {
		this.currentAttachmentUuid = currentAttachmentUuid;
	}
    /**
     * @return 排名
     */
	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}
    /**
     * @return 趋势
     */
	public Long getTrendFlag() {
		return trendFlag;
	}

	public void setTrendFlag(Long trendFlag) {
		this.trendFlag = trendFlag;
	}

}
