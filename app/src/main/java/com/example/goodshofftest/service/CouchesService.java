package com.example.goodshofftest.service;

import com.example.goodshofftest.model.GoodsInfo;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CouchesService {
      @GET("get_products_new?category_id=320&sort_by=popular&sort_type=desc&limit=20&offset=0&device_id=3a7612bcc84813b5&isAndroid=true&app_version=1.8.16&location=19&xhoff=36f40b3d665cdb9435904796172dde5e3f13aa8a%3A4630")
      Single<GoodsInfo> getItemsSortByPopular();
      @GET("get_products_new?category_id=320&sort_by=price&sort_type=desc&limit=20&offset=0&device_id=3a7612bcc84813b5&isAndroid=true&app_version=1.8.16&location=19&xhoff=36f40b3d665cdb9435904796172dde5e3f13aa8a%3A4630")
      Single<GoodsInfo> getItemsSortByPriceDesc();
      @GET("get_products_new?category_id=320&sort_by=price&sort_type=asc&limit=20&offset=0&device_id=3a7612bcc84813b5&isAndroid=true&app_version=1.8.16&location=19&xhoff=36f40b3d665cdb9435904796172dde5e3f13aa8a%3A4630")
      Single<GoodsInfo> getItemsSortByPriceAsc();
      @GET("get_products_new?category_id=320&discount=y&sort_type=desc&limit=20&offset=0&device_id=3a7612bcc84813b5&isAndroid=true&app_version=1.8.16&location=19&xhoff=36f40b3d665cdb9435904796172dde5e3f13aa8a%3A4630")
      Single<GoodsInfo> getItemsSortByDiscount();
}
