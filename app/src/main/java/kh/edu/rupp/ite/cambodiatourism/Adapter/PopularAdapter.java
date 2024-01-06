package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.content.Context;
import android.content.Intent;
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
import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Activity.DetailActivity;
import kh.edu.rupp.ite.cambodiatourism.Activity.PlaceDetailsActivity;
import kh.edu.rupp.ite.cambodiatourism.databinding.ViewholderPopularBinding;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.CategoryDomain;
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

        final PopularDomain item = getItem(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("PlaceId", item.getId());
                v.getContext().startActivity(intent);
            }
        });

    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        private final ViewholderPopularBinding itemBinding;
        private final Context context;
        public PlaceViewHolder(ViewholderPopularBinding itemBinding){
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            this.context = itemBinding.getRoot().getContext();
        }

        public void bind(PopularDomain popularDomain){
            Picasso.get().load(popularDomain.getImageUrl()).into(itemBinding.viewimage);
            itemBinding.titleTxt.setText(popularDomain.getTitle());

            // Set click listener on item view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the PlaceDetailActivity and pass the place id
                    Intent intent = new Intent(context, PlaceDetailsActivity.class);

                    intent.putExtra("placeId", popularDomain.getId());
                    context.startActivity(intent);
                }
            });
        }
    }

}
