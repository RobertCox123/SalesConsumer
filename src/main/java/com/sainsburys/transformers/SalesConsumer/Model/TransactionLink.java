package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

public class TransactionLink {
    private String linkStoreID;
    private String linkWorkstationID;
    private String linkDate;
    private long linkSequenceNumber;

    @JsonProperty("linkStoreId")
    public String getLinkStoreID() { return linkStoreID; }
    @JsonProperty("linkStoreId")
    public void setLinkStoreID(String value) { this.linkStoreID = value; }

    @JsonProperty("linkWorkstationId")
    public String getLinkWorkstationID() { return linkWorkstationID; }
    @JsonProperty("linkWorkstationId")
    public void setLinkWorkstationID(String value) { this.linkWorkstationID = value; }

    @JsonProperty("linkDate")
    public String getLinkDate() { return linkDate; }
    @JsonProperty("linkDate")
    public void setLinkDate(String value) { this.linkDate = value; }

    @JsonProperty("linkSequenceNumber")
    public long getLinkSequenceNumber() { return linkSequenceNumber; }
    @JsonProperty("linkSequenceNumber")
    public void setLinkSequenceNumber(long value) { this.linkSequenceNumber = value; }
}
