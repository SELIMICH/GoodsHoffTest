package com.example.goodshofftest.adapters;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.goodshofftest.R;
import com.example.goodshofftest.database.App;
import com.example.goodshofftest.model.Items;
import com.example.goodshofftest.screens.hoffgoodsactivity.HoffGoodsList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {
    private final List<Items> mItems;

     public GoodsAdapter(List<Items> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class GoodsViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mItemsImage;
        private final TextView mItemsTitle;
        private final TextView mItemsPrice;
        private final TextView mItemsOldPrice;
        private final TextView mStatusText;
        private final TextView mItemsSale;
        private final TextView mNumberOfReviews;
        private final RatingBar mRatingBarSmall;
        private Button mBtn_add_to_favorite;
        private Boolean backgroundOfmBtn_add_to_favorite_Is_Fill = false;


        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemsImage = itemView.findViewById(R.id.imageItem);
            mItemsTitle = itemView.findViewById(R.id.item_title);
            mItemsPrice = itemView.findViewById(R.id.price);
            mItemsOldPrice = itemView.findViewById(R.id.old_price);
            mItemsSale = itemView.findViewById(R.id.sale);
            mStatusText = itemView.findViewById(R.id.status_text);
            mBtn_add_to_favorite = itemView.findViewById(R.id.favorite);
            mRatingBarSmall = itemView.findViewById(R.id.ratingBar_small);
            mNumberOfReviews = itemView.findViewById(R.id.numberOfReviews);
            mBtn_add_to_favorite = itemView.findViewById(R.id.favorite);

        }

        @SuppressLint("SetTextI18n")
        private void bind(final Items items) {

            backgroundOfmBtn_add_to_favorite_Is_Fill = Boolean.parseBoolean(App.loadDataBoolean(items,mItemsImage.getContext()));
            if (!backgroundOfmBtn_add_to_favorite_Is_Fill){
                mBtn_add_to_favorite.setBackgroundResource(R.drawable.favorite);
                backgroundOfmBtn_add_to_favorite_Is_Fill = true;

            }else {
                mBtn_add_to_favorite.setBackgroundResource(R.drawable.ic_favorite_fill);
                backgroundOfmBtn_add_to_favorite_Is_Fill = false;
            }

            mItemsTitle.setText(items.getName());
            mItemsPrice.setText(items.getPrices().getNew().toString() + mItemsImage.getContext().getString(R.string.rub_sign));
            mItemsOldPrice.setPaintFlags(mItemsOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            mStatusText.setText(items.getStatusText());
            mRatingBarSmall.setRating(items.getRating());
            mNumberOfReviews.setText("(" + items.getNumberOfReviews() + ")");

            int tempNewPrice = Integer.parseInt(String.valueOf(items.getPrices().getNew()));
            int tempOldPrice = Integer.parseInt(String.valueOf(items.getPrices().getOld()));

            // проверяется есть ли скидка на товар
            if (tempNewPrice < tempOldPrice) {
                mItemsOldPrice.setVisibility(View.VISIBLE);
                mItemsSale.setVisibility(View.VISIBLE);
                mItemsOldPrice.setText(tempOldPrice + mItemsImage.getContext().getString(R.string.rub_sign));
                mItemsSale.setText(-(100 - ((tempNewPrice * 100) / tempOldPrice)) + "%");
            }else{
                mItemsOldPrice.setVisibility(View.INVISIBLE);
                mItemsSale.setVisibility(View.INVISIBLE);
            }

            Glide.with(mItemsImage.getContext())
                    .load(items.getImage())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_baseline_refresh_24)
                            .centerCrop()
                            .error(R.drawable.ic_launcher_foreground))
                    .into(mItemsImage);

            mBtn_add_to_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!backgroundOfmBtn_add_to_favorite_Is_Fill){
                        mBtn_add_to_favorite.setBackgroundResource(R.drawable.ic_favorite_fill);
                        App.saveData(items,mItemsImage.getContext(), true);
                        backgroundOfmBtn_add_to_favorite_Is_Fill = true;
                    }else {
                        mBtn_add_to_favorite.setBackgroundResource(R.drawable.favorite);
                        App.saveData(items,mItemsImage.getContext(), false);
                        backgroundOfmBtn_add_to_favorite_Is_Fill = false;
                    }
                }
            });
        }


    }
        //сортировка товаров по: сначала дешевые
        public static List<Items> sortByCheapGoods(List<Items> items) {
            Collections.sort(items, Collections.reverseOrder());
            return items;
        }

        //сортировка товаров по: сначала дорогие
        public static List<Items> sortByExpensiveGoods(List<Items> items) {
            Collections.sort(items);
            return items;
        }

        //сортировка товаров по скидкам
        public static List<Items> sortBySaleGoods(List<Items> items) {
            Comparator<Items> comparator = (left, right) -> (100 - ((right.getPrices().getNew() * 100) / right.getPrices().getOld())) -
                                                            (100 - (( left.getPrices().getNew() * 100) / left.getPrices().getOld()));
            Collections.sort(items, comparator);
            return items;
        }

        //сортировка товаров по: сначала популярные
        public static List<Items> sortByPopularGoods(List<Items> items) {
            Comparator<Items> comparator = (left, right) ->
                    right.getNumberOfReviews() - left.getNumberOfReviews();

            Collections.sort(items, comparator);
            return items;
        }
}
