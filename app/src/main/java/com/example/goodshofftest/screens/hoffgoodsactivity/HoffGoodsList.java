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
import com.example.goodshofftest.model.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HoffGoodsList extends AppCompatActivity implements HoffGoodsListView {
    private GoodsAdapter mAdapter;
    private RecyclerView mRecyclerViewGoods;
    private List<Items> mItemsSort;

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
                GoodsAdapter.sortByCheapGoods(mItemsSort);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.action_expensive:
                GoodsAdapter.sortByExpensiveGoods(mItemsSort);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.action_sale:
                GoodsAdapter.sortBySaleGoods(mItemsSort);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.action_popular:
                GoodsAdapter.sortByPopularGoods(mItemsSort);
                mAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



