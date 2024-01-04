package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.CategoryDomain;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<CategoryDomain> categoryDomains;
    private OnItemClickListener onItemClickListener;  // Added listener interface

    public CategoryAdapter(Context context, List<CategoryDomain> categoryDomains) {
        this.context = context;
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryDomain categoryDomain = categoryDomains.get(position);
        holder.textName.setText(categoryDomain.getName());
        holder.textLocation.setText(categoryDomain.getLocation());
        holder.textDescription.setText(categoryDomain.getDescription());

        // Load image using Picasso (add Picasso library to your dependencies)
        Picasso.get().load(categoryDomain.getImageUrl()).into(holder.imageView);

        // Set click listener on the item view
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(categoryDomain);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textName, textLocation, textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textLocation = itemView.findViewById(R.id.textLocation);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }

    public void setData(List<CategoryDomain> newData) {
        categoryDomains.clear();
        categoryDomains.addAll(newData);
        notifyDataSetChanged();
    }

    // Setter for the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(CategoryDomain categoryDomain);
    }
}
