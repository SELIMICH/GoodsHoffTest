package com.example.goodshofftest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Items implements Comparable<Items> {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("isFavorite")
    @Expose
    private Boolean isFavorite;
    @SerializedName("prices")
    @Expose
    private Prices prices;
    @SerializedName("full_set_prices")
    @Expose
    private Object fullSetPrices;
    @SerializedName("isBestPrice")
    @Expose
    private Boolean isBestPrice;
    @SerializedName("tag")
    @Expose
    private Object tag;
    @SerializedName("articul")
    @Expose
    private String articul;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("numberOfReviews")
    @Expose
    private Integer numberOfReviews;
    @SerializedName("statusText")
    @Expose
    private String statusText;
    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("complexAsOne")
    @Expose
    private Object complexAsOne;
    @SerializedName("categoryId")
    @Expose
    private String categoryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public Object getFullSetPrices() {
        return fullSetPrices;
    }

    public void setFullSetPrices(Object fullSetPrices) {
        this.fullSetPrices = fullSetPrices;
    }

    public Boolean getIsBestPrice() {
        return isBestPrice;
    }

    public void setIsBestPrice(Boolean isBestPrice) {
        this.isBestPrice = isBestPrice;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Object getComplexAsOne() {
        return complexAsOne;
    }

    public void setComplexAsOne(Object complexAsOne) {
        this.complexAsOne = complexAsOne;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int compareTo(Items o) {
        return o.getPrices().getNew() - this.getPrices().getNew();
    }
}
