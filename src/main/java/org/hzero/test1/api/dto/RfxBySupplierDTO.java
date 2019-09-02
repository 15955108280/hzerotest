package org.hzero.test1.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * description
 *
 * @author xingpeng.yang@hand-china.com 2019/09/02 17:19
 */
public class RfxBySupplierDTO {
	private Date quotationStartDate;
	private Date quotationEndDate;
	private String rfxNum;
	private String rfxTitle;
	private String feedbackStatus;
	private String rfxStatus;

	public String getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	public String getRfxStatus() {
		return rfxStatus;
	}

	public void setRfxStatus(String rfxStatus) {
		this.rfxStatus = rfxStatus;
	}

	public Date getQuotationStartDate() {
		return quotationStartDate;
	}

	public void setQuotationStartDate(Date quotationStartDate) {
		this.quotationStartDate = quotationStartDate;
	}

	public Date getQuotationEndDate() {
		return quotationEndDate;
	}

	public void setQuotationEndDate(Date quotationEndDate) {
		this.quotationEndDate = quotationEndDate;
	}

	public String getRfxNum() {
		return rfxNum;
	}

	public void setRfxNum(String rfxNum) {
		this.rfxNum = rfxNum;
	}

	public String getRfxTitle() {
		return rfxTitle;
	}

	public void setRfxTitle(String rfxTitle) {
		this.rfxTitle = rfxTitle;
	}
}
