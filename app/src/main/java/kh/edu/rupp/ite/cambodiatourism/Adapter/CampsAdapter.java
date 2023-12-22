package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Data.CampsData;
import kh.edu.rupp.ite.cambodiatourism.R;
import java.util.ArrayList;
public class CampsAdapter extends RecyclerView.Adapter<CampsAdapter.ViewHolder> {

    private List<CampsData> data = new ArrayList<>();

    public void setData(List<CampsData> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_camps, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CampsData item = data.get(position);

        holder.titleTextView.setText(item.getTitle());
        holder.locationTextView.setText(item.getLocation());

        // Load image using Picasso
        Picasso.get().load(item.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView locationTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
        }
    }
}

