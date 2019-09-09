package org.hzero.test1.api.dto;

import java.math.BigDecimal;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/03 14:19
 */
public class QuotationSummaryDTO {
    private Long rfxLineItemNum;
    private String itemCode;
    private String itemName;
    private BigDecimal rfxQuantity;
    private String quotationLineStatus;
    private BigDecimal currentQuotationPrice;
    private Integer taxIncludedFlag;
    private BigDecimal taxRate;

    public Long getRfxLineItemNum() {
        return rfxLineItemNum;
    }

    public void setRfxLineItemNum(Long rfxLineItemNum) {
        this.rfxLineItemNum = rfxLineItemNum;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getRfxQuantity() {
        return rfxQuantity;
    }

    public void setRfxQuantity(BigDecimal rfxQuantity) {
        this.rfxQuantity = rfxQuantity;
    }

    public String getQuotationLineStatus() {
        return quotationLineStatus;
    }

    public void setQuotationLineStatus(String quotationLineStatus) {
        this.quotationLineStatus = quotationLineStatus;
    }

    public BigDecimal getCurrentQuotationPrice() {
        return currentQuotationPrice;
    }

    public void setCurrentQuotationPrice(BigDecimal currentQuotationPrice) {
        this.currentQuotationPrice = currentQuotationPrice;
    }

    public Integer getTaxIncludedFlag() {
        return taxIncludedFlag;
    }

    public void setTaxIncludedFlag(Integer taxIncludedFlag) {
        this.taxIncludedFlag = taxIncludedFlag;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return "QuotationSummaryDTO{" + "rfxLineItemNum=" + rfxLineItemNum + ", itemCode='" + itemCode + '\''
                        + ", itemName='" + itemName + '\'' + ", rfxQuantity=" + rfxQuantity + ", quotationLineStatus='"
                        + quotationLineStatus + '\'' + ", currentQuotationPrice=" + currentQuotationPrice
                        + ", taxIncludedFlag=" + taxIncludedFlag + ", taxRate=" + taxRate + '}';
    }
}
