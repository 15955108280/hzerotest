package org.hzero.test1.api.dto;

/**
 * description
 *
 * @author YXP 2019/08/26 13:42
 */
public class ItemSummaryDTO {
	private Long rfxLineItemId;
	private Long rfxLineItemNum;
	private Long tenantId;
	private String itemCode;
	private String itemName;
	private String deliveryAddress;
	private String itemRemark;

	public Long getRfxLineItemId() {
		return rfxLineItemId;
	}

	public void setRfxLineItemId(Long rfxLineItemId) {
		this.rfxLineItemId = rfxLineItemId;
	}

	public Long getRfxLineItemNum() {
		return rfxLineItemNum;
	}

	public void setRfxLineItemNum(Long rfxLineItemNum) {
		this.rfxLineItemNum = rfxLineItemNum;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
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

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getItemRemark() {
		return itemRemark;
	}

	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}

	@Override
	public String toString() {
		return "ItemSummaryDTO{" +
				"rfxLineItemId=" + rfxLineItemId +
				", rfxLineItemNum=" + rfxLineItemNum +
				", tenantId=" + tenantId +
				", itemCode='" + itemCode + '\'' +
				", itemName='" + itemName + '\'' +
				", deliveryAddress='" + deliveryAddress + '\'' +
				", itemRemark='" + itemRemark + '\'' +
				'}';
	}
}
