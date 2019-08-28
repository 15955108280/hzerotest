package org.hzero.test1.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import io.choerodon.mybatis.domain.AuditDomain;
import java.math.BigDecimal;
import java.util.Date;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 询价单物料料⾏行行
 *
 * @author xingpeng.yang@hand-china.com 2019-08-26 11:38:00
 */
@ApiModel("询价单物料行")
@VersionAudit
@ModifyAudit
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Table(name = "ssrc_rfx_line_item")
public class LineItem extends AuditDomain {

    public static final String FIELD_RFX_LINE_ITEM_ID = "rfxLineItemId";
    public static final String FIELD_RFX_HEADER_ID = "rfxHeaderId";
    public static final String FIELD_RFX_LINE_ITEM_NUM = "rfxLineItemNum";
    public static final String FIELD_TENANT_ID = "tenantId";
    public static final String FIELD_OU_ID = "ouId";
    public static final String FIELD_INV_ORGANIZATION_ID = "invOrganizationId";
    public static final String FIELD_ITEM_ID = "itemId";
    public static final String FIELD_ITEM_CODE = "itemCode";
    public static final String FIELD_ITEM_NAME = "itemName";
    public static final String FIELD_ITEM_CATEGORY_ID = "itemCategoryId";
    public static final String FIELD_DELIVERY_ADDRESS = "deliveryAddress";
    public static final String FIELD_ITEM_REMARK = "itemRemark";
    public static final String FIELD_FREIGHT_INCLUDED_FLAG = "freightIncludedFlag";
    public static final String FIELD_RFX_QUANTITY = "rfxQuantity";
    public static final String FIELD_UOM_ID = "uomId";
    public static final String FIELD_TAX_INCLUDED_FLAG = "taxIncludedFlag";
    public static final String FIELD_TAX_ID = "taxId";
    public static final String FIELD_TAX_RATE = "taxRate";
    public static final String FIELD_QUOTATION_RANGE = "quotationRange";
    public static final String FIELD_MAX_LIMIT_PRICE = "maxLimitPrice";
    public static final String FIELD_MIN_LIMIT_PRICE = "minLimitPrice";
    public static final String FIELD_COST_PRICE = "costPrice";
    public static final String FIELD_SAMPLE_REQUESTED_FLAG = "sampleRequestedFlag";
    public static final String FIELD_DEMAND_DATE = "demandDate";
    public static final String FIELD_ROUND_FLAG = "roundFlag";
    public static final String FIELD_CURRENT_ROUND_NUMBER = "currentRoundNumber";
    public static final String FIELD_FINISHED_FLAG = "finishedFlag";
    public static final String FIELD_QUOTATION_START_DATE = "quotationStartDate";
    public static final String FIELD_QUOTATION_END_DATE = "quotationEndDate";
    public static final String FIELD_LADDER_INQUIRY_FLAG = "ladderInquiryFlag";
    public static final String FIELD_ATTACHMENT_UUID = "attachmentUuid";
    public static final String FIELD_SELECTION_STRATEGY = "selectionStrategy";
    public static final String FIELD_DEFER_COUNT = "deferCount";
    public static final String FIELD_PR_HEADER_ID = "prHeaderId";
    public static final String FIELD_PR_LINE_ID = "prLineId";
    public static final String FIELD_PR_NUM = "prNum";
    public static final String FIELD_PR_LINE_NUM = "prLineNum";

    //
    // 业务方法(按public protected private顺序排列)
    // ------------------------------------------------------------------------------

    //
    // 数据库字段
    // ------------------------------------------------------------------------------



    @ApiModelProperty("")
    @Id
    @GeneratedValue
    private Long rfxLineItemId;
    @ApiModelProperty(value = "询价单头ID", required = true)
    @NotNull
    private Long rfxHeaderId;
    @ApiModelProperty(value = "行号")
    private Long rfxLineItemNum;
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id", required = true)
    @NotNull
    private Long tenantId;
    @ApiModelProperty(value = "业务实体ID", required = true)
    @NotNull
    private Long ouId;
    @ApiModelProperty(value = "")
    private Long invOrganizationId;
    @ApiModelProperty(value = "物料ID")
    private Long itemId;
    @ApiModelProperty(value = "物料代码")
    private String itemCode;
    @ApiModelProperty(value = "物料描述")
    private String itemName;
    @ApiModelProperty(value = "")
    private Long itemCategoryId;
    @ApiModelProperty(value = "收货地址")
    private String deliveryAddress;
    @ApiModelProperty(value = "物品说明")
    private String itemRemark;
    @ApiModelProperty(value = "是否含运费标志", required = true)
    @NotNull
    private Integer freightIncludedFlag;
    @ApiModelProperty(value = "数量")
    private BigDecimal rfxQuantity;
    @ApiModelProperty(value = "单位", required = true)
    @NotNull
    private Long uomId;
    @ApiModelProperty(value = "含税标识", required = true)
    @NotNull
    private Integer taxIncludedFlag;
    @ApiModelProperty(value = "税率ID")
    private Long taxId;
    @ApiModelProperty(value = "税率")
    private BigDecimal taxRate;
    @ApiModelProperty(value = "报价幅度")
    private BigDecimal quotationRange;
    @ApiModelProperty(value = "最高限价")
    private BigDecimal maxLimitPrice;
    @ApiModelProperty(value = "最低限价")
    private BigDecimal minLimitPrice;
    @ApiModelProperty(value = "成本单价")
    private BigDecimal costPrice;
    @ApiModelProperty(value = "需要样品", required = true)
    @NotNull
    private Integer sampleRequestedFlag;
    @ApiModelProperty(value = "需求日期")
    private Date demandDate;
    @ApiModelProperty(value = "多轮报价标志", required = true)
    @NotNull
    private Integer roundFlag;
    @ApiModelProperty(value = "所处轮次", required = true)
    @NotNull
    private Long currentRoundNumber;
    @ApiModelProperty(value = "结束标志", required = true)
    @NotNull
    private Integer finishedFlag;
    @ApiModelProperty(value = "")
    private Date quotationStartDate;
    @ApiModelProperty(value = "报价截止时间")
    private Date quotationEndDate;
    @ApiModelProperty(value = "阶梯报价标志", required = true)
    @NotNull
    private Integer ladderInquiryFlag;
    @ApiModelProperty(value = "附件UUID")
    private String attachmentUuid;
    @ApiModelProperty(value = "询价单选择策略SSRC.RFX_ SELECTION_STRATEGY(RECOMMENDATION/推荐供应商| RELEASE/释放采购申请| CANCEL/不释放采购申请)")
    private String selectionStrategy;
    @ApiModelProperty(value = "延时次数", required = true)
    @NotNull
    private Long deferCount;
    @ApiModelProperty(value = "申请头id")
    private Long prHeaderId;
    @ApiModelProperty(value = "申请行id")
    private Long prLineId;
    @ApiModelProperty(value = "申请编号")
    private String prNum;
    @ApiModelProperty(value = "申请行号")
    private Long prLineNum;

    //
    // 非数据库字段
    // ------------------------------------------------------------------------------

    //
    // getter/setter
    // ------------------------------------------------------------------------------

    public LineItem(Long rfxHeaderId, String itemName, String itemRemark) {
        this.rfxHeaderId = rfxHeaderId;
        this.itemName = itemName;
        this.itemRemark = itemRemark;
    }

    public LineItem(Long tenantId, Long rfxHeaderId) {
        this.tenantId = tenantId;
        this.rfxLineItemId = rfxHeaderId;
    }

    public LineItem(Long rfxHeaderId) {
        this.rfxHeaderId = rfxHeaderId;
    }

    public LineItem() {}

    /**
     * @return
     */
    public Long getRfxLineItemId() {
        return rfxLineItemId;
    }

    public void setRfxLineItemId(Long rfxLineItemId) {
        this.rfxLineItemId = rfxLineItemId;
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
     * @return 行号
     */
    public Long getRfxLineItemNum() {
        return rfxLineItemNum;
    }

    public void setRfxLineItemNum(Long rfxLineItemNum) {
        this.rfxLineItemNum = rfxLineItemNum;
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
     * @return 业务实体ID
     */
    public Long getOuId() {
        return ouId;
    }

    public void setOuId(Long ouId) {
        this.ouId = ouId;
    }

    /**
     * @return
     */
    public Long getInvOrganizationId() {
        return invOrganizationId;
    }

    public void setInvOrganizationId(Long invOrganizationId) {
        this.invOrganizationId = invOrganizationId;
    }

    /**
     * @return 物料ID
     */
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return 物料代码
     */
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return 物料描述
     */
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return
     */
    public Long getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Long itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    /**
     * @return 收货地址
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * @return 物品说明
     */
    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    /**
     * @return 是否含运费标志
     */
    public Integer getFreightIncludedFlag() {
        return freightIncludedFlag;
    }

    public void setFreightIncludedFlag(Integer freightIncludedFlag) {
        this.freightIncludedFlag = freightIncludedFlag;
    }

    /**
     * @return 数量
     */
    public BigDecimal getRfxQuantity() {
        return rfxQuantity;
    }

    public void setRfxQuantity(BigDecimal rfxQuantity) {
        this.rfxQuantity = rfxQuantity;
    }

    /**
     * @return 单位
     */
    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
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
     * @return 报价幅度
     */
    public BigDecimal getQuotationRange() {
        return quotationRange;
    }

    public void setQuotationRange(BigDecimal quotationRange) {
        this.quotationRange = quotationRange;
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
     * @return 成本单价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return 需要样品
     */
    public Integer getSampleRequestedFlag() {
        return sampleRequestedFlag;
    }

    public void setSampleRequestedFlag(Integer sampleRequestedFlag) {
        this.sampleRequestedFlag = sampleRequestedFlag;
    }

    /**
     * @return 需求日期
     */
    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    /**
     * @return 多轮报价标志
     */
    public Integer getRoundFlag() {
        return roundFlag;
    }

    public void setRoundFlag(Integer roundFlag) {
        this.roundFlag = roundFlag;
    }

    /**
     * @return 所处轮次
     */
    public Long getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public void setCurrentRoundNumber(Long currentRoundNumber) {
        this.currentRoundNumber = currentRoundNumber;
    }

    /**
     * @return 结束标志
     */
    public Integer getFinishedFlag() {
        return finishedFlag;
    }

    public void setFinishedFlag(Integer finishedFlag) {
        this.finishedFlag = finishedFlag;
    }

    /**
     * @return
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
     * @return 阶梯报价标志
     */
    public Integer getLadderInquiryFlag() {
        return ladderInquiryFlag;
    }

    public void setLadderInquiryFlag(Integer ladderInquiryFlag) {
        this.ladderInquiryFlag = ladderInquiryFlag;
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
     * @return 询价单选择策略SSRC.RFX_ SELECTION_STRATEGY(RECOMMENDATION/推荐供应商| RELEASE/释放采购申请| CANCEL/不释放采购申请)
     */
    public String getSelectionStrategy() {
        return selectionStrategy;
    }

    public void setSelectionStrategy(String selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    /**
     * @return 延时次数
     */
    public Long getDeferCount() {
        return deferCount;
    }

    public void setDeferCount(Long deferCount) {
        this.deferCount = deferCount;
    }

    /**
     * @return 申请头id
     */
    public Long getPrHeaderId() {
        return prHeaderId;
    }

    public void setPrHeaderId(Long prHeaderId) {
        this.prHeaderId = prHeaderId;
    }

    /**
     * @return 申请行id
     */
    public Long getPrLineId() {
        return prLineId;
    }

    public void setPrLineId(Long prLineId) {
        this.prLineId = prLineId;
    }

    /**
     * @return 申请编号
     */
    public String getPrNum() {
        return prNum;
    }

    public void setPrNum(String prNum) {
        this.prNum = prNum;
    }

    /**
     * @return 申请行号
     */
    public Long getPrLineNum() {
        return prLineNum;
    }

    public void setPrLineNum(Long prLineNum) {
        this.prLineNum = prLineNum;
    }

}
