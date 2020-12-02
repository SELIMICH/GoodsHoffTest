package com.example.goodshofftest.screens.hoffgoodsactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodshofftest.R;
import com.example.goodshofftest.adapters.GoodsAdapter;
import com.example.goodshofftest.adapters.SimpleDividerItemDecoration;
import com.example.goodshofftest.model.EmulateResponseManager;
import com.example.goodshofftest.model.GoodsInfo;
import com.example.goodshofftest.model.Items;
import com.example.goodshofftest.service.SortBy;
import com.example.goodshofftest.utils.auto_loading.AutoLoadingRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HoffGoodsList extends AppCompatActivity implements HoffGoodsListView {
    private GoodsAdapter mAdapter;
    private RecyclerView mRecyclerViewGoods;
    private List<Items> mItemsSort;
    private HoffGoodsListPresenter mHoffGoodsListPresenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoff_goods_list);
        Spinner actions = (Spinner) findViewById(R.id.spinnerActions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
        mHoffGoodsListPresenter = new HoffGoodsListPresenter(this);
        mRecyclerViewGoods = findViewById(R.id.recycler_view_couches);
        mAdapter = new GoodsAdapter(new ArrayList<>());
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(HoffGoodsList.this, 2);
        mRecyclerViewGoods.setLayoutManager(layoutManager);
        mRecyclerViewGoods.setAdapter(mAdapter);
        mRecyclerViewGoods.addItemDecoration(new SimpleDividerItemDecoration(this));
        mHoffGoodsListPresenter.loadData("getGoodsSortByPopular");
    }
    @Override
    public void showData(List<Items> items) {
        mAdapter = new GoodsAdapter(items);
        mItemsSort = items;
        mRecyclerViewGoods.setAdapter(mAdapter);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.hoff_goods_list_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cheap:
                mHoffGoodsListPresenter.loadData("getGoodsSortByPriceAsc");
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.action_expensive:
                mHoffGoodsListPresenter.loadData("getGoodsSortByPriceDesc");
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.action_sale:
                mHoffGoodsListPresenter.loadData("getGoodsSortByDiscount");
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.action_popular:
                mHoffGoodsListPresenter.loadData("getGoodsSortByPopular");
                mAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



