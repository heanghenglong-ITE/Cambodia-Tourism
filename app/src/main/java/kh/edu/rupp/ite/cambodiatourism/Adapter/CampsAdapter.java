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

import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Data.CampsData;
import kh.edu.rupp.ite.cambodiatourism.R;

public class CampsAdapter extends RecyclerView.Adapter<CampsAdapter.ViewHolder> {
    private Context context;
    private List<CampsData> dataList;

    public void setSearchList(List<CampsData> dataSearchList) {
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public CampsAdapter(List<CampsData> dataList) {
        this.context = context;
        this.dataList = dataList;
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
        CampsData campsData = dataList.get(position);

        // Bind data to views
        holder.campsImage.setImageResource(campsData.getDataImage());
        holder.campsProvince.setText(campsData.getDataName());
        holder.campsTitle.setText(campsData.getDataTitle());

        // Add an OnClickListener if needed
        holder.campseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle item click if needed
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView campsImage;
        TextView campsProvince;
        TextView campsTitle;
        CardView campseCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            campsImage = itemView.findViewById(R.id.campsImage);
            campsProvince = itemView.findViewById(R.id.campsProvince);
            campsTitle = itemView.findViewById(R.id.campsTitle);
            campseCard = itemView.findViewById(R.id.campseCard);
        }
    }
}
