package org.hzero.test1.api.dto;

import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;
import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/04 15:49
 */
@ExcelSheet(zh = "收货记录", en = "Receiving record")
public class ExportDTO {
    @ExcelColumn
    private Long rfxHeaderId;
    @ExcelColumn
    private Long tenantId;
    @ExcelColumn
    private String rfxNum;
    @ExcelColumn
    private String rfxStatus;
    @ExcelColumn
    private String rfxTitle;
    @ExcelColumn
    private Long templateId;
    @ExcelColumn
    private String sourceCategory;
    @ExcelColumn
    private String sourceMethod;
    @ExcelColumn
    private Long purOrganizationId;
    @ExcelColumn
    private Long companyId;
    @ExcelColumn
    private String companyName;
    @ExcelColumn
    private String auctionDirection;
    @ExcelColumn
    private BigDecimal budgetAmount;
    @ExcelColumn
    private Integer taxIncludedFlag;
    @ExcelColumn
    private Long taxId;
    @ExcelColumn
    private BigDecimal taxRate;
    @ExcelColumn
    private String currencyCode;
    @ExcelColumn
    private Long exchangeRateId;
    @ExcelColumn
    private String exchangeRateType;
    @ExcelColumn
    private Date exchangeRateDate;
    @ExcelColumn
    private String exchangeRatePeriod;
    @ExcelColumn
    private BigDecimal exchangeRate;
    @ExcelColumn
    private String rfxRemark;
    @ExcelColumn
    private Date quotationStartDate;
    @ExcelColumn
    private Date quotationEndDate;
    @ExcelColumn
    private Integer sealedQuotationFlag;
    @ExcelColumn
    private String openRule;
    @ExcelColumn
    private String auctionRanking;
    @ExcelColumn
    private String sourceType;
    @ExcelColumn
    private String priceCategory;
    @ExcelColumn
    private Long paymentTypeId;
    @ExcelColumn
    private Long paymentTermId;
    @ExcelColumn
    private Long roundNumber;
    @ExcelColumn
    private String quotationOrderType;
    @ExcelColumn
    private BigDecimal quotationRunningDuration;
    @ExcelColumn
    private BigDecimal quotationInterval;
    @ExcelColumn
    private String auctionRule;
    @ExcelColumn
    private Integer autoDeferFlag;
    @ExcelColumn
    private BigDecimal autoDeferDuration;
    @ExcelColumn
    private Date releasedDate;
    @ExcelColumn
    private Long releasedBy;
    @ExcelColumn
    private Date terminatedDate;
    @ExcelColumn
    private Long terminatedBy;
    @ExcelColumn
    private String terminatedRemark;
    @ExcelColumn
    private Date approvedDate;
    @ExcelColumn
    private Long approvedBy;
    @ExcelColumn
    private String approvedRemark;
    @ExcelColumn
    private Date timeAdjustedDate;
    @ExcelColumn
    private Long timeAdjustedBy;
    @ExcelColumn
    private String timeAdjustedRemark;
    @ExcelColumn
    private Integer closedFlag;
    @ExcelColumn
    private String sourceFrom;
    @ExcelColumn
    private String pretrailRemark;
    @ExcelColumn
    private BigDecimal totalCost;
    @ExcelColumn
    private String costRemark;
    @ExcelColumn
    private String techAttachmentUuid;
    @ExcelColumn
    private String businessAttachmentUuid;
    @ExcelColumn
    private Long pretrialUserId;
    @ExcelColumn
    private String backPretrialRemark;
    @ExcelColumn
    private String pretrialStatus;
    @ExcelColumn
    private String quotationType;
    /*
     * @ExcelColumn private List<LineItem> lineItemList;
     * 
     * @ExcelColumn private List<LineSupplier> lineSupplierList;
     */

    @Override
    public String toString() {
        return "ExportDTO{" + "rfxHeaderId=" + rfxHeaderId + ", tenantId=" + tenantId + ", rfxNum='" + rfxNum + '\''
                        + ", rfxStatus='" + rfxStatus + '\'' + ", rfxTitle='" + rfxTitle + '\'' + ", templateId="
                        + templateId + ", sourceCategory='" + sourceCategory + '\'' + ", sourceMethod='" + sourceMethod
                        + '\'' + ", purOrganizationId=" + purOrganizationId + ", companyId=" + companyId
                        + ", companyName='" + companyName + '\'' + ", auctionDirection='" + auctionDirection + '\''
                        + ", budgetAmount=" + budgetAmount + ", taxIncludedFlag=" + taxIncludedFlag + ", taxId=" + taxId
                        + ", taxRate=" + taxRate + ", currencyCode='" + currencyCode + '\'' + ", exchangeRateId="
                        + exchangeRateId + ", exchangeRateType='" + exchangeRateType + '\'' + ", exchangeRateDate="
                        + exchangeRateDate + ", exchangeRatePeriod='" + exchangeRatePeriod + '\'' + ", exchangeRate="
                        + exchangeRate + ", rfxRemark='" + rfxRemark + '\'' + ", quotationStartDate="
                        + quotationStartDate + ", quotationEndDate=" + quotationEndDate + ", sealedQuotationFlag="
                        + sealedQuotationFlag + ", openRule='" + openRule + '\'' + ", auctionRanking='" + auctionRanking
                        + '\'' + ", sourceType='" + sourceType + '\'' + ", priceCategory='" + priceCategory + '\''
                        + ", paymentTypeId=" + paymentTypeId + ", paymentTermId=" + paymentTermId + ", roundNumber="
                        + roundNumber + ", quotationOrderType='" + quotationOrderType + '\''
                        + ", quotationRunningDuration=" + quotationRunningDuration + ", quotationInterval="
                        + quotationInterval + ", auctionRule='" + auctionRule + '\'' + ", autoDeferFlag="
                        + autoDeferFlag + ", autoDeferDuration=" + autoDeferDuration + ", releasedDate=" + releasedDate
                        + ", releasedBy=" + releasedBy + ", terminatedDate=" + terminatedDate + ", terminatedBy="
                        + terminatedBy + ", terminatedRemark='" + terminatedRemark + '\'' + ", approvedDate="
                        + approvedDate + ", approvedBy=" + approvedBy + ", approvedRemark='" + approvedRemark + '\''
                        + ", timeAdjustedDate=" + timeAdjustedDate + ", timeAdjustedBy=" + timeAdjustedBy
                        + ", timeAdjustedRemark='" + timeAdjustedRemark + '\'' + ", closedFlag=" + closedFlag
                        + ", sourceFrom='" + sourceFrom + '\'' + ", pretrailRemark='" + pretrailRemark + '\''
                        + ", totalCost=" + totalCost + ", costRemark='" + costRemark + '\'' + ", techAttachmentUuid='"
                        + techAttachmentUuid + '\'' + ", businessAttachmentUuid='" + businessAttachmentUuid + '\''
                        + ", pretrialUserId=" + pretrialUserId + ", backPretrialRemark='" + backPretrialRemark + '\''
                        + ", pretrialStatus='" + pretrialStatus + '\'' + ", quotationType='" + quotationType + '\''
                        + '}';
    }
}
