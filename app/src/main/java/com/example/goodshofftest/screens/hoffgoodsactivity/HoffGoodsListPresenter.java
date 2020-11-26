package com.example.goodshofftest.screens.hoffgoodsactivity;

import com.example.goodshofftest.model.GoodsInfo;
import com.example.goodshofftest.service.CouchesService;
import com.example.goodshofftest.service.RetrofitInstance;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HoffGoodsListPresenter {
    private final HoffGoodsListView mView;

    public HoffGoodsListPresenter(HoffGoodsListView view) {
        mView = view;
    }

   public void loadData() {

        CouchesService couchesService = RetrofitInstance.getService();
        couchesService.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<GoodsInfo>() {
                    @Override
                    public void onSuccess(@NonNull GoodsInfo goodsInfo) {
                        mView.showData(goodsInfo.getItems());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.showError(e);
                    }
                });

    }


}
