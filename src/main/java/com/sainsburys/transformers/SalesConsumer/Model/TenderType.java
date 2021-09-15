package com.sainsburys.transformers.SalesConsumer.Model;


import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class TenderType {
    private String tenderType;
    private long lineSeq;
    private String amount;
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;

    @JsonProperty("tenderType")
    public String getTenderType() { return tenderType; }
    @JsonProperty("tenderType")
    public void setTenderType(String value) { this.tenderType = value; }

    @JsonProperty("lineSeq")
    public long getLineSeq() { return lineSeq; }
    @JsonProperty("lineSeq")
    public void setLineSeq(long value) { this.lineSeq = value; }

    @JsonProperty("amount")
    public String getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(String value) { this.amount = value; }

    @JsonProperty("startDateTime")
    public OffsetDateTime getStartDateTime() { return startDateTime; }
    @JsonProperty("startDateTime")
    public void setStartDateTime(OffsetDateTime value) { this.startDateTime = value; }

    @JsonProperty("endDateTime")
    public OffsetDateTime getEndDateTime() { return endDateTime; }
    @JsonProperty("endDateTime")
    public void setEndDateTime(OffsetDateTime value) { this.endDateTime = value; }
}