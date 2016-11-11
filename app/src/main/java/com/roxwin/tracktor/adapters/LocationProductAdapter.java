package com.roxwin.tracktor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.models.LocationFoundModel;
import com.roxwin.tracktor.models.LocationProductModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phuctran on 11/7/16.
 */

public class LocationProductAdapter extends RecyclerView.Adapter<LocationProductAdapter.ViewHolder> {

    private List<LocationProductModel> data;

    public interface OnItemClickListener {
        void onItemClicked(LocationProductModel groupModel);
    }

    private OnItemClickListener onItemClickListener;

    public LocationProductAdapter(List<LocationProductModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocationProductModel model = data.get(position);
        holder.tvDescription.setText(model.getDescription());
        holder.tvCost.setText(model.getCost() + "/day");
        holder.tvYear.setText(model.getBrand());
        holder.ivCarImage.setImageResource(R.drawable.dummy_data_image_1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClicked(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCost)
        TextView tvCost;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @BindView(R.id.tvYear)
        TextView tvYear;
        @BindView(R.id.ivCarImage)
        ImageView ivCarImage;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
