package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

public class CustomerLoyalty {
    private String nectarCard;
    private String issueNo;
    private long pointsAward;
    private long includesBonus;

    @JsonProperty("nectarCard")
    public String getNectarCard() { return nectarCard; }
    @JsonProperty("nectarCard")
    public void setNectarCard(String value) { this.nectarCard = value; }

    @JsonProperty("issueNo")
    public String getIssueNo() { return issueNo; }
    @JsonProperty("issueNo")
    public void setIssueNo(String value) { this.issueNo = value; }

    @JsonProperty("pointsAward")
    public long getPointsAward() { return pointsAward; }
    @JsonProperty("pointsAward")
    public void setPointsAward(long value) { this.pointsAward = value; }

    @JsonProperty("includesBonus")
    public long getIncludesBonus() { return includesBonus; }
    @JsonProperty("includesBonus")
    public void setIncludesBonus(long value) { this.includesBonus = value; }
}