package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.model.Domain.ExploreDomain;
import kh.edu.rupp.ite.cambodiatourism.R;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    ArrayList<ExploreDomain> items = new ArrayList<>();

    public ExploreAdapter(ArrayList<ExploreDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ExploreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_explore,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreAdapter.ViewHolder holder, int position) {
        holder.placeName.setText(items.get(position).getPlaceName());
        holder.desImg.setText(items.get(position).getDesImg());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getImgPlace()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.imagePlace);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView placeName;
        TextView desImg;
        ImageView imagePlace;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePlace= itemView.findViewById(R.id.imgPlace);
            placeName= itemView.findViewById(R.id.placetitle);
            desImg= itemView.findViewById(R.id.placeceDetail);
        }
    }
}
