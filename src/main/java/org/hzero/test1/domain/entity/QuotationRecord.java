package org.hzero.test1.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

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
 * 所有报价记录
 *
 * @author xingpeng.yang@hand-china.com 2019-09-02 13:40:49
 */
@ApiModel("所有报价记录")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_quotation_record")
public class QuotationRecord extends AuditDomain {

    public static final String FIELD_RECORD_ID = "recordId";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_QUOTATION_LINE_ID = "quotationLineId";
    public static final String FIELD_QUOTATION_COUNT = "quotationCount";
    public static final String FIELD_QUOTATION_QUANTITY = "quotationQuantity";
    public static final String FIELD_QUOTATION_PRICE = "quotationPrice";
    public static final String FIELD_QUOTATION_REMARK = "quotationRemark";
    public static final String FIELD_QUOTED_DATE = "quotedDate";
    public static final String FIELD_QUOTED_BY = "quotedBy";
    public static final String FIELD_PRICE_BATCH_QUANTITY = "priceBatchQuantity";
    public static final String FIELD_PROMISED_DATE = "promisedDate";
    public static final String FIELD_DELIVERY_CYCLE = "deliveryCycle";
    public static final String FIELD_QUOTATION_EXPIRY_DATE_FROM = "quotationExpiryDateFrom";
    public static final String FIELD_QUOTATION_EXPIRY_DATE_TO = "quotationExpiryDateTo";
    public static final String FIELD_BARGAIN_FLAG = "bargainFlag";
    public static final String FIELD_BARGAIN_DATE = "bargainDate";
    public static final String FIELD_BARGAIN_BY = "bargainBy";
    public static final String FIELD_BARGAIN_QUANTITY = "bargainQuantity";
    public static final String FIELD_BARGAIN_PRICE = "bargainPrice";
    public static final String FIELD_BARGAIN_REMARK = "bargainRemark";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------


    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long recordId;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id", required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "报价行ID", required = true)
    @NotNull
    private Long quotationLineId;
    @ApiModelProperty(value = "报价次数", required = true)
    @NotNull
    private Long quotationCount;
    @ApiModelProperty(value = "报价数量")
    private BigDecimal quotationQuantity;
    @ApiModelProperty(value = "报价价格")
    private BigDecimal quotationPrice;
    @ApiModelProperty(value = "报价理由")
    private String quotationRemark;
    @ApiModelProperty(value = "报价时间")
    private Date quotedDate;
    @ApiModelProperty(value = "有效报价人")
    private Long quotedBy;
    @ApiModelProperty(value = "价格批量")
    private BigDecimal priceBatchQuantity;
    @ApiModelProperty(value = "承诺交货日期")
    private Date promisedDate;
    @ApiModelProperty(value = "供货周期")
    private String deliveryCycle;
    @ApiModelProperty(value = "报价有效期从")
    private Date quotationExpiryDateFrom;
    @ApiModelProperty(value = "报价有效期至")
    private Date quotationExpiryDateTo;
    @ApiModelProperty(value = "还价标志", required = true)
    @NotNull
    private Integer bargainFlag;
    @ApiModelProperty(value = "还价时间")
    private Date bargainDate;
    @ApiModelProperty(value = "还价人")
    private Long bargainBy;
    @ApiModelProperty(value = "还价数量")
    private BigDecimal bargainQuantity;
    @ApiModelProperty(value = "还价单价")
    private BigDecimal bargainPrice;
    @ApiModelProperty(value = "还价理由")
    private String bargainRemark;

    public QuotationRecord() {

    }

    public QuotationRecord(QuotationLine quotationLine) {
        this.tenantId = quotationLine.getTenantId();
        this.quotationLineId = quotationLine.getQuotationLineId();
        this.quotationCount = quotationLine.getQuotationHeaderId();
        this.quotationQuantity = quotationLine.getCurrentQuotationQuantity();
        this.quotationPrice = quotationLine.getCurrentQuotationPrice();
        this.quotationRemark = quotationLine.getCurrentQuotationRemark();
        this.quotedDate = quotationLine.getQuotedDate();
        this.quotedBy = quotationLine.getCurrentQuotedBy();
        this.priceBatchQuantity = quotationLine.getPriceBatchQuantity();
        this.promisedDate = quotationLine.getCurrentPromisedDate();
        this.deliveryCycle = quotationLine.getCurrentDeliveryCycle();
        this.quotationExpiryDateFrom = quotationLine.getCurrentExpiryDateFrom();
        this.quotationExpiryDateTo = quotationLine.getCurrentExpiryDateTo();
        this.bargainFlag = quotationLine.getBargainFlag();
        this.bargainDate = quotationLine.getBargainDate();
        this.bargainBy = quotationLine.getCurrentBargainBy();
        this.bargainQuantity = quotationLine.getCurrentBargainQuantity();
        this.bargainPrice = quotationLine.getCurrentBargainPrice();
        this.bargainRemark = quotationLine.getCurrentBargainRemark();
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
    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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
     * @return 报价行ID
     */
    public Long getQuotationLineId() {
        return quotationLineId;
    }

    public void setQuotationLineId(Long quotationLineId) {
        this.quotationLineId = quotationLineId;
    }

    /**
     * @return 报价次数
     */
    public Long getQuotationCount() {
        return quotationCount;
    }

    public void setQuotationCount(Long quotationCount) {
        this.quotationCount = quotationCount;
    }

    /**
     * @return 报价数量
     */
    public BigDecimal getQuotationQuantity() {
        return quotationQuantity;
    }

    public void setQuotationQuantity(BigDecimal quotationQuantity) {
        this.quotationQuantity = quotationQuantity;
    }

    /**
     * @return 报价价格
     */
    public BigDecimal getQuotationPrice() {
        return quotationPrice;
    }

    public void setQuotationPrice(BigDecimal quotationPrice) {
        this.quotationPrice = quotationPrice;
    }

    /**
     * @return 报价理由
     */
    public String getQuotationRemark() {
        return quotationRemark;
    }

    public void setQuotationRemark(String quotationRemark) {
        this.quotationRemark = quotationRemark;
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
     * @return 有效报价人
     */
    public Long getQuotedBy() {
        return quotedBy;
    }

    public void setQuotedBy(Long quotedBy) {
        this.quotedBy = quotedBy;
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
     * @return 承诺交货日期
     */
    public Date getPromisedDate() {
        return promisedDate;
    }

    public void setPromisedDate(Date promisedDate) {
        this.promisedDate = promisedDate;
    }

    /**
     * @return 供货周期
     */
    public String getDeliveryCycle() {
        return deliveryCycle;
    }

    public void setDeliveryCycle(String deliveryCycle) {
        this.deliveryCycle = deliveryCycle;
    }

    /**
     * @return 报价有效期从
     */
    public Date getQuotationExpiryDateFrom() {
        return quotationExpiryDateFrom;
    }

    public void setQuotationExpiryDateFrom(Date quotationExpiryDateFrom) {
        this.quotationExpiryDateFrom = quotationExpiryDateFrom;
    }

    /**
     * @return 报价有效期至
     */
    public Date getQuotationExpiryDateTo() {
        return quotationExpiryDateTo;
    }

    public void setQuotationExpiryDateTo(Date quotationExpiryDateTo) {
        this.quotationExpiryDateTo = quotationExpiryDateTo;
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
     * @return 还价人
     */
    public Long getBargainBy() {
        return bargainBy;
    }

    public void setBargainBy(Long bargainBy) {
        this.bargainBy = bargainBy;
    }

    /**
     * @return 还价数量
     */
    public BigDecimal getBargainQuantity() {
        return bargainQuantity;
    }

    public void setBargainQuantity(BigDecimal bargainQuantity) {
        this.bargainQuantity = bargainQuantity;
    }

    /**
     * @return 还价单价
     */
    public BigDecimal getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(BigDecimal bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    /**
     * @return 还价理由
     */
    public String getBargainRemark() {
        return bargainRemark;
    }

    public void setBargainRemark(String bargainRemark) {
        this.bargainRemark = bargainRemark;
    }

}
