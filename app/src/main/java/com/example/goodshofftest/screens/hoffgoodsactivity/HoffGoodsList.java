package com.example.goodshofftest.screens.hoffgoodsactivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodshofftest.R;
import com.example.goodshofftest.adapters.GoodsAdapter;
import com.example.goodshofftest.model.Items;

import java.util.ArrayList;
import java.util.List;

public class HoffGoodsList extends AppCompatActivity implements HoffGoodsListView {
    private GoodsAdapter mAdapter;
    private RecyclerView mRecyclerViewGoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoff_goods_list);
        HoffGoodsListPresenter mHoffGoodsListPresenter = new HoffGoodsListPresenter(this);
        mRecyclerViewGoods = findViewById(R.id.recycler_view_couches);
        mAdapter = new GoodsAdapter(new ArrayList<>());
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(HoffGoodsList.this, 2);
        mRecyclerViewGoods.setLayoutManager(layoutManager);
        mRecyclerViewGoods.setAdapter(mAdapter);
        mHoffGoodsListPresenter.loadData();
    }
    @Override
    public void showData(List<Items> items) {
        mAdapter = new GoodsAdapter(items);
        mRecyclerViewGoods.setAdapter(mAdapter);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
    }

    }

