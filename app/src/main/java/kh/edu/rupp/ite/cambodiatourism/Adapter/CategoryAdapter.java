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

public class CategoryAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<CategoryData> dataList;

    public  void setSearchList(List<CategoryData> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public CategoryAdapter(Context context, List<CategoryData> dataList){
        this.context = context;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (dataList != null && position < dataList.size()) {
            CategoryData currentData = dataList.get(position);
            if (currentData != null) {
                holder.categoryImage.setImageResource(currentData.getDataImage());
                holder.categoryTitle.setText(currentData.getDataTitle());

                holder.categoryCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, currentData.getDestinationActivityClass());
                        intent.putExtra("Image", currentData.getDataImage());
                        intent.putExtra("Title", currentData.getDataTitle());

                        context.startActivity(intent);
                    }
                });
            }
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView categoryImage;
    TextView categoryTitle;
    CardView categoryCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryImage = itemView.findViewById(R.id.categoryImage);
        categoryTitle = itemView.findViewById(R.id.categoryTitle);
        categoryCard = itemView.findViewById(R.id.categoryCard);
    }
}
