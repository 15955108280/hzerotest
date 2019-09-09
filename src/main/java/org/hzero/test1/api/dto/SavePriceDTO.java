package org.hzero.test1.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 15:28
 */
public class SavePriceDTO {
    private Long quotationLineId;
    private Date currentPromisedDate;
    private String currentDeliveryCycle;
    private Date currentExpiryDateFrom;
    private Date currentExpiryDateTo;
    private Long currentQuotedBy;
    private BigDecimal currentQuotationQuantity;
    private BigDecimal currentQuotationPrice;
    private String currentQuotationRemark;
    private Long currentBargainBy;
    private BigDecimal currentBargainQuantity;
    private BigDecimal currentBargainPrice;
    private String currentBargainRemark;

    public Long getQuotationLineId() {
        return quotationLineId;
    }

    public void setQuotationLineId(Long quotationLineId) {
        this.quotationLineId = quotationLineId;
    }

    public Date getCurrentPromisedDate() {
        return currentPromisedDate;
    }

    public void setCurrentPromisedDate(Date currentPromisedDate) {
        this.currentPromisedDate = currentPromisedDate;
    }

    public String getCurrentDeliveryCycle() {
        return currentDeliveryCycle;
    }

    public void setCurrentDeliveryCycle(String currentDeliveryCycle) {
        this.currentDeliveryCycle = currentDeliveryCycle;
    }

    public Date getCurrentExpiryDateFrom() {
        return currentExpiryDateFrom;
    }

    public void setCurrentExpiryDateFrom(Date currentExpiryDateFrom) {
        this.currentExpiryDateFrom = currentExpiryDateFrom;
    }

    public Date getCurrentExpiryDateTo() {
        return currentExpiryDateTo;
    }

    public void setCurrentExpiryDateTo(Date currentExpiryDateTo) {
        this.currentExpiryDateTo = currentExpiryDateTo;
    }

    public Long getCurrentQuotedBy() {
        return currentQuotedBy;
    }

    public void setCurrentQuotedBy(Long currentQuotedBy) {
        this.currentQuotedBy = currentQuotedBy;
    }

    public BigDecimal getCurrentQuotationQuantity() {
        return currentQuotationQuantity;
    }

    public void setCurrentQuotationQuantity(BigDecimal currentQuotationQuantity) {
        this.currentQuotationQuantity = currentQuotationQuantity;
    }

    public BigDecimal getCurrentQuotationPrice() {
        return currentQuotationPrice;
    }

    public void setCurrentQuotationPrice(BigDecimal currentQuotationPrice) {
        this.currentQuotationPrice = currentQuotationPrice;
    }

    public String getCurrentQuotationRemark() {
        return currentQuotationRemark;
    }

    public void setCurrentQuotationRemark(String currentQuotationRemark) {
        this.currentQuotationRemark = currentQuotationRemark;
    }

    public Long getCurrentBargainBy() {
        return currentBargainBy;
    }

    public void setCurrentBargainBy(Long currentBargainBy) {
        this.currentBargainBy = currentBargainBy;
    }

    public BigDecimal getCurrentBargainQuantity() {
        return currentBargainQuantity;
    }

    public void setCurrentBargainQuantity(BigDecimal currentBargainQuantity) {
        this.currentBargainQuantity = currentBargainQuantity;
    }

    public BigDecimal getCurrentBargainPrice() {
        return currentBargainPrice;
    }

    public void setCurrentBargainPrice(BigDecimal currentBargainPrice) {
        this.currentBargainPrice = currentBargainPrice;
    }

    public String getCurrentBargainRemark() {
        return currentBargainRemark;
    }

    public void setCurrentBargainRemark(String currentBargainRemark) {
        this.currentBargainRemark = currentBargainRemark;
    }

    @Override
    public String toString() {
        return "SavePriceDTO{" + "quotationLineId=" + quotationLineId + ", currentPromisedDate=" + currentPromisedDate
                        + ", currentDeliveryCycle='" + currentDeliveryCycle + '\'' + ", currentExpiryDateFrom="
                        + currentExpiryDateFrom + ", currentExpiryDateTo=" + currentExpiryDateTo + ", currentQuotedBy="
                        + currentQuotedBy + ", currentQuotationQuantity=" + currentQuotationQuantity
                        + ", currentQuotationPrice=" + currentQuotationPrice + ", currentQuotationRemark='"
                        + currentQuotationRemark + '\'' + ", currentBargainBy=" + currentBargainBy
                        + ", currentBargainQuantity=" + currentBargainQuantity + ", currentBargainPrice="
                        + currentBargainPrice + ", currentBargainRemark='" + currentBargainRemark + '\'' + '}';
    }
}
