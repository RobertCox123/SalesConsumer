package com.sainsburys.transformers.SalesConsumer.Model;



import com.fasterxml.jackson.annotation.*;

public class Salesmessage {
    private String partnerMessageID;
    private String partnerID;
    private long storeID;
    private String storeName;
    private String timeStamp;
    private PayLoad payLoad;

    @JsonProperty("partnerMessageId")
    public String getPartnerMessageID() { return partnerMessageID; }
    @JsonProperty("partnerMessageId")
    public void setPartnerMessageID(String value) { this.partnerMessageID = value; }

    @JsonProperty("partnerId")
    public String getPartnerID() { return partnerID; }
    @JsonProperty("partnerId")
    public void setPartnerID(String value) { this.partnerID = value; }

    @JsonProperty("storeId")
    public long getStoreID() { return storeID; }
    @JsonProperty("storeId")
    public void setStoreID(long value) { this.storeID = value; }

    @JsonProperty("storeName")
    public String getStoreName() { return storeName; }
    @JsonProperty("storeName")
    public void setStoreName(String value) { this.storeName = value; }

    @JsonProperty("timeStamp")
    public String getTimeStamp() { return timeStamp; }
    @JsonProperty("timeStamp")
    public void setTimeStamp(String value) { this.timeStamp = value; }

    @JsonProperty("payLoad")
    public PayLoad getPayLoad() { return payLoad; }
    @JsonProperty("payLoad")
    public void setPayLoad(PayLoad value) { this.payLoad = value; }
}