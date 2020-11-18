package com.example.goodshofftest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prices {
    @SerializedName("new")
    @Expose
    private Integer _new;
    @SerializedName("old")
    @Expose
    private Integer old;

    public Integer getNew() {
        return _new;
    }

    public void setNew(Integer _new) {
        this._new = _new;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }
}
