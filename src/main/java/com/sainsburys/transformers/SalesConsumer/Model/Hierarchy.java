package com.sainsburys.transformers.SalesConsumer.Model;
import com.fasterxml.jackson.annotation.*;

public class Hierarchy {
    private String groupID;
    private String subcategoryID;
    private String categoryID;

    @JsonProperty("groupId")
    public String getGroupID() { return groupID; }
    @JsonProperty("groupId")
    public void setGroupID(String value) { this.groupID = value; }

    @JsonProperty("subcategoryId")
    public String getSubcategoryID() { return subcategoryID; }
    @JsonProperty("subcategoryId")
    public void setSubcategoryID(String value) { this.subcategoryID = value; }

    @JsonProperty("categoryId")
    public String getCategoryID() { return categoryID; }
    @JsonProperty("categoryId")
    public void setCategoryID(String value) { this.categoryID = value; }
}