package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

public class Transaction {
    private LineItem[] lineItems;
    private TenderType[] tenderTypes;
    private PromotionRedemption[] promotionRedemption;

    @JsonProperty("lineItems")
    public LineItem[] getLineItems() { return lineItems; }
    @JsonProperty("lineItems")
    public void setLineItems(LineItem[] value) { this.lineItems = value; }

    @JsonProperty("tenderTypes")
    public TenderType[] getTenderTypes() { return tenderTypes; }
    @JsonProperty("tenderTypes")
    public void setTenderTypes(TenderType[] value) { this.tenderTypes = value; }

    @JsonProperty("promotionRedemption")
    public PromotionRedemption[] getPromotionRedemption() { return promotionRedemption; }
    @JsonProperty("promotionRedemption")
    public void setPromotionRedemption(PromotionRedemption[] value) { this.promotionRedemption = value; }
}