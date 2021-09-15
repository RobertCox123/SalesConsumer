package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

public class PromotionRedemption {
    private String promotionCode;
    private String partnerCode;
    private long redemptionQuantity;

    @JsonProperty("promotionCode")
    public String getPromotionCode() { return promotionCode; }
    @JsonProperty("promotionCode")
    public void setPromotionCode(String value) { this.promotionCode = value; }

    @JsonProperty("partnerCode")
    public String getPartnerCode() { return partnerCode; }
    @JsonProperty("partnerCode")
    public void setPartnerCode(String value) { this.partnerCode = value; }

    @JsonProperty("redemptionQuantity")
    public long getRedemptionQuantity() { return redemptionQuantity; }
    @JsonProperty("redemptionQuantity")
    public void setRedemptionQuantity(long value) { this.redemptionQuantity = value; }
}