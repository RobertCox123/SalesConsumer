package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

public class StaffDiscount {
    private String staffDiscountCard;
    private String qualifyingSpend;
    private String discountRate;

    @JsonProperty("staffDiscountCard")
    public String getStaffDiscountCard() { return staffDiscountCard; }
    @JsonProperty("staffDiscountCard")
    public void setStaffDiscountCard(String value) { this.staffDiscountCard = value; }

    @JsonProperty("qualifyingSpend")
    public String getQualifyingSpend() { return qualifyingSpend; }
    @JsonProperty("qualifyingSpend")
    public void setQualifyingSpend(String value) { this.qualifyingSpend = value; }

    @JsonProperty("discountRate")
    public String getDiscountRate() { return discountRate; }
    @JsonProperty("discountRate")
    public void setDiscountRate(String value) { this.discountRate = value; }
}