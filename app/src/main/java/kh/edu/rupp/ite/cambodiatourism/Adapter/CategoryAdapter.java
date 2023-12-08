package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Data.CategoryData;
import kh.edu.rupp.ite.cambodiatourism.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<CategoryData> dataList;

    public void setSearchList(List<CategoryData> dataSearchList) {
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public CategoryAdapter(Context context, List<CategoryData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryData categoryData = dataList.get(position);

        holder.categoryImage.setImageResource(categoryData.getDataImage());
        holder.categoryTitle.setText(categoryData.getDataTitle());

        holder.categoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle item click, e.g., start a new activity or fragment
                Intent intent = new Intent(context, categoryData.getDestinationActivityClass());
                intent.putExtra("Image", categoryData.getDataImage());
                intent.putExtra("Title", categoryData.getDataTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryTitle;
        CardView categoryCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            categoryCard = itemView.findViewById(R.id.categoryCard);
        }
    }
}

