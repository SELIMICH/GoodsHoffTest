package com.example.goodshofftest.screens.hoffgoodsactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodshofftest.R;
import com.example.goodshofftest.adapters.GoodsAdapter;
import com.example.goodshofftest.adapters.SimpleDividerItemDecoration;
import com.example.goodshofftest.model.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HoffGoodsList extends AppCompatActivity implements HoffGoodsListView {
    private GoodsAdapter mAdapter;
    private RecyclerView mRecyclerViewGoods;
    private HoffGoodsListPresenter mHoffGoodsListPresenter;
    private String mSortItems;
    private Spinner mActions;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoff_goods_list);
        mActions = findViewById(R.id.spinnerActions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.actions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mActions.setAdapter(adapter);
        mSortItems = "Популярные товары";
        mActions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSortItems = parent.getItemAtPosition(position).toString();
                mHoffGoodsListPresenter.loadData(mSortItems);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        mHoffGoodsListPresenter.loadData(mSortItems);
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



