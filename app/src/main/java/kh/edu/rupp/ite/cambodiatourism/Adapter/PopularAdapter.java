package kh.edu.rupp.ite.cambodiatourism.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Domain.PopularDomain;
import kh.edu.rupp.ite.cambodiatourism.R;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<PopularDomain> items;
    DecimalFormat formatter;

    public PopularAdapter(Context context,ArrayList<PopularDomain> items){

        this.items = items;
        formatter = new DecimalFormat("###,###,###,###");
    }

    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.locationTxt.setText(items.get(position).getLocation());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicImg()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new CenterCrop(), new GranularRoundedCorners(40, 40,40,40))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt,locationTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.titleTxt);
            locationTxt = itemView.findViewById(R.id.pLocation);
            pic = itemView.findViewById(R.id.p_picImg);
        }
    }
}