package com.example.goodshofftest.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.goodshofftest.R;
import com.example.goodshofftest.model.Items;

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

        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemsImage = itemView.findViewById(R.id.imageItem);
            mItemsTitle = itemView.findViewById(R.id.item_title);
            mItemsPrice = itemView.findViewById(R.id.price);
            TextView mItemsSale = itemView.findViewById(R.id.sale);
        }

        @SuppressLint("SetTextI18n")
        private void bind(final Items items) {

            mItemsTitle.setText(items.getName());
            mItemsPrice.setText(items.getPrices() + mItemsImage.getContext().getString(R.string.rub_sign));

            Glide.with(mItemsImage.getContext())
                    .load(items.getImage())
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.ic_baseline_refresh_24)
                            .centerCrop()
                            .error(R.drawable.ic_launcher_foreground))
                    .into(mItemsImage);

        }
    }
}
