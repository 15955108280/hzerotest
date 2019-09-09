package org.hzero.test1.api.dto;


import org.hzero.boot.platform.lov.annotation.LovValue;

import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/26 12:28
 */
public class RfxSummaryDTO {
    private Long rfxHeaderId;
    private String rfxNum;
    private String rfxStatus;
    private String rfxTitle;
    @LovValue(lovCode = "SSRC.SOURCE_AUCTION_DIRECTION", meaningField = "auctionDirectionMeaning")
    private String auctionDirection;
    private String auctionDirectionMeaning;
    private List<ItemSummaryDTO> itemSummaryList;

    public String getAuctionDirectionMeaning() {
        return auctionDirectionMeaning;
    }

    public void setAuctionDirectionMeaning(String auctionDirectionMeaning) {
        this.auctionDirectionMeaning = auctionDirectionMeaning;
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

    public List<ItemSummaryDTO> getItemSummaryList() {
        return itemSummaryList;
    }

    public void setItemSummaryList(List<ItemSummaryDTO> itemSummaryList) {
        this.itemSummaryList = itemSummaryList;
    }

    @Override
    public String toString() {
        return "RfxSummaryDTO{" + "HeaderId=" + rfxHeaderId + ", rfxNum='" + rfxNum + '\'' + ", rfxStatus='" + rfxStatus
                        + '\'' + ", rfxTitle='" + rfxTitle + '\'' + ", auctionDirection='" + auctionDirection + '\''
                        + ", itemSummaryDTOList=" + itemSummaryList + '}';
    }
}

