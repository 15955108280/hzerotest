package org.hzero.test1.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 16:53
 */
public class SubmitPriceDTO {
    private Long quotationLineId;
    private Long rfxHeaderId;
    private Date validPromisedDate;
    private String validDeliveryCycle;
    private Date validExpiryDateFrom;
    private Long validQuotedBy;
    private BigDecimal validQuotationQuantity;
    private BigDecimal validQuotationPrice;
    private String validQuotationRemark;
    private Long validBargainBy;
    private BigDecimal validBargainQuantity;
    private BigDecimal validBargainPrice;
    private String validBargainRemark;

    public Long getRfxHeaderId() {
        return rfxHeaderId;
    }

    public void setRfxHeaderId(Long rfxHeaderId) {
        this.rfxHeaderId = rfxHeaderId;
    }

    public Long getQuotationLineId() {
        return quotationLineId;
    }

    public void setQuotationLineId(Long quotationLineId) {
        this.quotationLineId = quotationLineId;
    }

    public Date getValidPromisedDate() {
        return validPromisedDate;
    }

    public void setValidPromisedDate(Date validPromisedDate) {
        this.validPromisedDate = validPromisedDate;
    }

    public String getValidDeliveryCycle() {
        return validDeliveryCycle;
    }

    public void setValidDeliveryCycle(String validDeliveryCycle) {
        this.validDeliveryCycle = validDeliveryCycle;
    }

    public Date getValidExpiryDateFrom() {
        return validExpiryDateFrom;
    }

    public void setValidExpiryDateFrom(Date validExpiryDateFrom) {
        this.validExpiryDateFrom = validExpiryDateFrom;
    }

    public Long getValidQuotedBy() {
        return validQuotedBy;
    }

    public void setValidQuotedBy(Long validQuotedBy) {
        this.validQuotedBy = validQuotedBy;
    }

    public BigDecimal getValidQuotationQuantity() {
        return validQuotationQuantity;
    }

    public void setValidQuotationQuantity(BigDecimal validQuotationQuantity) {
        this.validQuotationQuantity = validQuotationQuantity;
    }

    public BigDecimal getValidQuotationPrice() {
        return validQuotationPrice;
    }

    public void setValidQuotationPrice(BigDecimal validQuotationPrice) {
        this.validQuotationPrice = validQuotationPrice;
    }

    public String getValidQuotationRemark() {
        return validQuotationRemark;
    }

    public void setValidQuotationRemark(String validQuotationRemark) {
        this.validQuotationRemark = validQuotationRemark;
    }

    public Long getValidBargainBy() {
        return validBargainBy;
    }

    public void setValidBargainBy(Long validBargainBy) {
        this.validBargainBy = validBargainBy;
    }

    public BigDecimal getValidBargainQuantity() {
        return validBargainQuantity;
    }

    public void setValidBargainQuantity(BigDecimal validBargainQuantity) {
        this.validBargainQuantity = validBargainQuantity;
    }

    public BigDecimal getValidBargainPrice() {
        return validBargainPrice;
    }

    public void setValidBargainPrice(BigDecimal validBargainPrice) {
        this.validBargainPrice = validBargainPrice;
    }

    public String getValidBargainRemark() {
        return validBargainRemark;
    }

    public void setValidBargainRemark(String validBargainRemark) {
        this.validBargainRemark = validBargainRemark;
    }

    @Override
    public String toString() {
        return "SubmitPriceDTO{" + "quotationLineId=" + quotationLineId + ", validPromisedDate=" + validPromisedDate
                        + ", validDeliveryCycle='" + validDeliveryCycle + '\'' + ", validExpiryDateFrom="
                        + validExpiryDateFrom + ", validQuotedBy=" + validQuotedBy + ", validQuotationQuantity="
                        + validQuotationQuantity + ", validQuotationPrice=" + validQuotationPrice
                        + ", validQuotationRemark='" + validQuotationRemark + '\'' + ", validBargainBy="
                        + validBargainBy + ", validBargainQuantity=" + validBargainQuantity + ", validBargainPrice="
                        + validBargainPrice + ", validBargainRemark='" + validBargainRemark + '\'' + '}';
    }
}
