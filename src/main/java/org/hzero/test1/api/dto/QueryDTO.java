package org.hzero.test1.api.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * description
 *
 * @author YXP 2019/08/27 15:56
 */
@ApiModel("询价单头表")
public class QueryDTO {
    @ApiModelProperty(value = "所属租户ID，hpfm_tenant.tenant_id")
    private Long rfxHeaderId;
    @ApiModelProperty(value = "询价单单号")
    private String rfxNum;
    @ApiModelProperty(value = "询价单状态")
    private String rfxStatus;
    @ApiModelProperty(value = "询价单标题")
    private String rfxTitle;
    @ApiModelProperty(value = "竞价方向SSRC.SOURCE_AUCTION_DIRECTION(FORWARD/正向|REVERSE/反向)")
    private String auctionDirection;
    @ApiModelProperty(value = "询价单行id")
    private Long rfxLineItemId;
    @ApiModelProperty(value = "行号")
    private Long rfxLineItemNum;
    @ApiModelProperty(value = "租户Id")
    private Long tenantId;
    @ApiModelProperty(value = "物料代码")
    private String itemCode;
    @ApiModelProperty(value = "物料描述")
    private String itemName;
    @ApiModelProperty(value = "收货地址")
    private String deliveryAddress;
    @ApiModelProperty(value = "物品说明")
    private String itemRemark;

    @Override
    public String toString() {
        return "QueryDTO{" + "rfxHeaderId=" + rfxHeaderId + ", rfxNum='" + rfxNum + '\'' + ", rfxStatus='" + rfxStatus
                        + '\'' + ", rfxTitle='" + rfxTitle + '\'' + ", auctionDirection='" + auctionDirection + '\''
                        + ", rfxLineItemId=" + rfxLineItemId + ", rfxLineItemNum=" + rfxLineItemNum + ", tenantId="
                        + tenantId + ", itemCode='" + itemCode + '\'' + ", itemName='" + itemName + '\''
                        + ", deliveryAddress='" + deliveryAddress + '\'' + ", itemRemark='" + itemRemark + '\'' + '}';
    }

    public QueryDTO(Long tenantId) {
        this.tenantId = tenantId;
    }
    public  QueryDTO(){

    }
    public Long getRfxHeaderId() {
        return rfxHeaderId;
    }

    public void setRfxHeaderId(Long rfxHeaderId) {
        this.rfxHeaderId = rfxHeaderId;
    }

    public String getRfxNum() {
        return rfxNum;
    }

    public void setRfxNum(String rfxNum) {
        this.rfxNum = rfxNum;
    }

    public String getRfxStatus() {
        return rfxStatus;
    }

    public void setRfxStatus(String rfxStatus) {
        this.rfxStatus = rfxStatus;
    }

    public String getRfxTitle() {
        return rfxTitle;
    }

    public void setRfxTitle(String rfxTitle) {
        this.rfxTitle = rfxTitle;
    }

    public String getAuctionDirection() {
        return auctionDirection;
    }

    public void setAuctionDirection(String auctionDirection) {
        this.auctionDirection = auctionDirection;
    }

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
}
