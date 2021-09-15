package com.sainsburys.transformers.SalesConsumer.Model;


import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class LineItem {
    private String lineTransType;
    private String lineType;
    private long lineSeq;
    private String posItemID;
    private String eanNumber;
    private String description;
    private String jsItemFlag;
    private String unitPrice;
    private String quantity;
    private String uom;
    private String extendedValue;
    private String returnCode;
    private PriceModifier priceModifier;
    private String source;
    private String consumableGroup;
    private Hierarchy hierarchy;
    private String scanData;
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;

    @JsonProperty("lineTransType")
    public String getLineTransType() { return lineTransType; }
    @JsonProperty("lineTransType")
    public void setLineTransType(String value) { this.lineTransType = value; }

    @JsonProperty("lineType")
    public String getLineType() { return lineType; }
    @JsonProperty("lineType")
    public void setLineType(String value) { this.lineType = value; }

    @JsonProperty("lineSeq")
    public long getLineSeq() { return lineSeq; }
    @JsonProperty("lineSeq")
    public void setLineSeq(long value) { this.lineSeq = value; }

    @JsonProperty("posItemId")
    public String getPosItemID() { return posItemID; }
    @JsonProperty("posItemId")
    public void setPosItemID(String value) { this.posItemID = value; }

    @JsonProperty("eanNumber")
    public String getEanNumber() { return eanNumber; }
    @JsonProperty("eanNumber")
    public void setEanNumber(String value) { this.eanNumber = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("jsItemFlag")
    public String getJSItemFlag() { return jsItemFlag; }
    @JsonProperty("jsItemFlag")
    public void setJSItemFlag(String value) { this.jsItemFlag = value; }

    @JsonProperty("unitPrice")
    public String getUnitPrice() { return unitPrice; }
    @JsonProperty("unitPrice")
    public void setUnitPrice(String value) { this.unitPrice = value; }

    @JsonProperty("quantity")
    public String getQuantity() { return quantity; }
    @JsonProperty("quantity")
    public void setQuantity(String value) { this.quantity = value; }

    @JsonProperty("uom")
    public String getUom() { return uom; }
    @JsonProperty("uom")
    public void setUom(String value) { this.uom = value; }

    @JsonProperty("extendedValue")
    public String getExtendedValue() { return extendedValue; }
    @JsonProperty("extendedValue")
    public void setExtendedValue(String value) { this.extendedValue = value; }

    @JsonProperty("returnCode")
    public String getReturnCode() { return returnCode; }
    @JsonProperty("returnCode")
    public void setReturnCode(String value) { this.returnCode = value; }

    @JsonProperty("priceModifier")
    public PriceModifier getPriceModifier() { return priceModifier; }
    @JsonProperty("priceModifier")
    public void setPriceModifier(PriceModifier value) { this.priceModifier = value; }

    @JsonProperty("source")
    public String getSource() { return source; }
    @JsonProperty("source")
    public void setSource(String value) { this.source = value; }

    @JsonProperty("consumableGroup")
    public String getConsumableGroup() { return consumableGroup; }
    @JsonProperty("consumableGroup")
    public void setConsumableGroup(String value) { this.consumableGroup = value; }

    @JsonProperty("hierarchy")
    public Hierarchy getHierarchy() { return hierarchy; }
    @JsonProperty("hierarchy")
    public void setHierarchy(Hierarchy value) { this.hierarchy = value; }

    @JsonProperty("scanData")
    public String getScanData() { return scanData; }
    @JsonProperty("scanData")
    public void setScanData(String value) { this.scanData = value; }

    @JsonProperty("startDateTime")
    public OffsetDateTime getStartDateTime() { return startDateTime; }
    @JsonProperty("startDateTime")
    public void setStartDateTime(OffsetDateTime value) { this.startDateTime = value; }

    @JsonProperty("endDateTime")
    public OffsetDateTime getEndDateTime() { return endDateTime; }
    @JsonProperty("endDateTime")
    public void setEndDateTime(OffsetDateTime value) { this.endDateTime = value; }
}