package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

public class PriceModifier {
    private String promotionCode;
    private String partnerCode;
    private String promotionDiscount;
    private String staffDiscount;
    private String newPrice;
    private String promotionType;
    private String promotionDescription;

    @JsonProperty("promotionCode")
    public String getPromotionCode() { return promotionCode; }
    @JsonProperty("promotionCode")
    public void setPromotionCode(String value) { this.promotionCode = value; }

    @JsonProperty("partnerCode")
    public String getPartnerCode() { return partnerCode; }
    @JsonProperty("partnerCode")
    public void setPartnerCode(String value) { this.partnerCode = value; }

    @JsonProperty("promotionDiscount")
    public String getPromotionDiscount() { return promotionDiscount; }
    @JsonProperty("promotionDiscount")
    public void setPromotionDiscount(String value) { this.promotionDiscount = value; }

    @JsonProperty("staffDiscount")
    public String getStaffDiscount() { return staffDiscount; }
    @JsonProperty("staffDiscount")
    public void setStaffDiscount(String value) { this.staffDiscount = value; }

    @JsonProperty("newPrice")
    public String getNewPrice() { return newPrice; }
    @JsonProperty("newPrice")
    public void setNewPrice(String value) { this.newPrice = value; }

    @JsonProperty("promotionType")
    public String getPromotionType() { return promotionType; }
    @JsonProperty("promotionType")
    public void setPromotionType(String value) { this.promotionType = value; }

    @JsonProperty("promotionDescription")
    public String getPromotionDescription() { return promotionDescription; }
    @JsonProperty("promotionDescription")
    public void setPromotionDescription(String value) { this.promotionDescription = value; }
}
