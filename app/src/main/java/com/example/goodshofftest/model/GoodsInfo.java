package com.example.goodshofftest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoodsInfo {
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("plashka")
    @Expose
    private Object plashka;
    @SerializedName("couches")
    @Expose
    private List<Items> items = null;
    @SerializedName("relatedCategories")
    @Expose
    private List<RelatedCategory> relatedCategories = null;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Object getPlashka() {
        return plashka;
    }

    public void setPlashka(Object plashka) {
        this.plashka = plashka;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<RelatedCategory> getRelatedCategories() {
        return relatedCategories;
    }

    public void setRelatedCategories(List<RelatedCategory> relatedCategories) {
        this.relatedCategories = relatedCategories;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
