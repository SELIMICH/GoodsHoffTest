package com.example.goodshofftest.screens.hoffgoodsactivity;

import com.example.goodshofftest.model.Items;

import java.util.List;

public interface HoffGoodsListView {
    void showData(List<Items> items);
    void showError(Throwable e);
}
