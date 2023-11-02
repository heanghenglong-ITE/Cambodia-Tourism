package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.Domain.MoreDomain;
import kh.edu.rupp.ite.cambodiatourism.R;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder> {

    ArrayList<MoreDomain> items = new ArrayList<>();

    public MoreAdapter(ArrayList<MoreDomain> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public MoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_more,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicPath()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picImg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView picImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            picImg = itemView.findViewById(R.id.catImg);
        }
    }
}
