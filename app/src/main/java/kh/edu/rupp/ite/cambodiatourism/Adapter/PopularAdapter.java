package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.databinding.ViewholderPopularBinding;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.PopularDomain;
import kh.edu.rupp.ite.cambodiatourism.R;

public class PopularAdapter extends ListAdapter<PopularDomain, PopularAdapter.PlaceViewHolder> {

    public PopularAdapter() {

        super(new DiffUtil.ItemCallback<PopularDomain>() {
            @Override
            public boolean areItemsTheSame(@NonNull PopularDomain oldItem, @NonNull PopularDomain newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull PopularDomain oldItem, @NonNull PopularDomain newItem) {
                return oldItem.getId() == newItem.getId();
            }
        });
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewholderPopularBinding binding = ViewholderPopularBinding.inflate(layoutInflater, parent, false);
        return new PlaceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        PopularDomain item = getItem(position);
        holder.bind(item);

    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        private final ViewholderPopularBinding itemBinding;
        public PlaceViewHolder(ViewholderPopularBinding itemBinding){
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(PopularDomain popularDomain){
            Picasso.get().load(popularDomain.getImageUrl()).into(itemBinding.viewimage);
            itemBinding.titleTxt.setText(popularDomain.getTitle());
            itemBinding.pLocation.setText(popularDomain.getLocation());
        }
    }

}
