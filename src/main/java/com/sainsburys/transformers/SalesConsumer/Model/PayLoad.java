package com.sainsburys.transformers.SalesConsumer.Model;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class PayLoad {
    private String workstationID;
    private long sequenceNumber;
    private Transaction transaction;
    private LocalDate tradingDayDate;
    private CustomerLoyalty customerLoyalty;
    private StaffDiscount staffDiscount;
    private TransactionLink transactionLink;
    private String totalvalue;
    private String totalGrossAmount;
    private String totalNetAmount;
    private String totalQuantity;
    private OffsetDateTime startTransDateTime;
    private OffsetDateTime endTransDateTime;

    @JsonProperty("workstationId")
    public String getWorkstationID() { return workstationID; }
    @JsonProperty("workstationId")
    public void setWorkstationID(String value) { this.workstationID = value; }

    @JsonProperty("sequenceNumber")
    public long getSequenceNumber() { return sequenceNumber; }
    @JsonProperty("sequenceNumber")
    public void setSequenceNumber(long value) { this.sequenceNumber = value; }

    @JsonProperty("transaction")
    public Transaction getTransaction() { return transaction; }
    @JsonProperty("transaction")
    public void setTransaction(Transaction value) { this.transaction = value; }

    @JsonProperty("tradingDayDate")
    public LocalDate getTradingDayDate() { return tradingDayDate; }
    @JsonProperty("tradingDayDate")
    public void setTradingDayDate(LocalDate value) { this.tradingDayDate = value; }

    @JsonProperty("customerLoyalty")
    public CustomerLoyalty getCustomerLoyalty() { return customerLoyalty; }
    @JsonProperty("customerLoyalty")
    public void setCustomerLoyalty(CustomerLoyalty value) { this.customerLoyalty = value; }

    @JsonProperty("staffDiscount")
    public StaffDiscount getStaffDiscount() { return staffDiscount; }
    @JsonProperty("staffDiscount")
    public void setStaffDiscount(StaffDiscount value) { this.staffDiscount = value; }

    @JsonProperty("transactionLink")
    public TransactionLink getTransactionLink() { return transactionLink; }
    @JsonProperty("transactionLink")
    public void setTransactionLink(TransactionLink value) { this.transactionLink = value; }

    @JsonProperty("totalvalue")
    public String getTotalvalue() { return totalvalue; }
    @JsonProperty("totalvalue")
    public void setTotalvalue(String value) { this.totalvalue = value; }

    @JsonProperty("totalGrossAmount")
    public String getTotalGrossAmount() { return totalGrossAmount; }
    @JsonProperty("totalGrossAmount")
    public void setTotalGrossAmount(String value) { this.totalGrossAmount = value; }

    @JsonProperty("totalNetAmount")
    public String getTotalNetAmount() { return totalNetAmount; }
    @JsonProperty("totalNetAmount")
    public void setTotalNetAmount(String value) { this.totalNetAmount = value; }

    @JsonProperty("totalQuantity")
    public String getTotalQuantity() { return totalQuantity; }
    @JsonProperty("totalQuantity")
    public void setTotalQuantity(String value) { this.totalQuantity = value; }

    @JsonProperty("startTransDateTime")
    public OffsetDateTime getStartTransDateTime() { return startTransDateTime; }
    @JsonProperty("startTransDateTime")
    public void setStartTransDateTime(OffsetDateTime value) { this.startTransDateTime = value; }

    @JsonProperty("endTransDateTime")
    public OffsetDateTime getEndTransDateTime() { return endTransDateTime; }
    @JsonProperty("endTransDateTime")
    public void setEndTransDateTime(OffsetDateTime value) { this.endTransDateTime = value; }
}