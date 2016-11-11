package com.roxwin.tracktor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.models.LocationFoundModel;
import com.roxwin.tracktor.models.RentEquipmentModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phuctran on 11/7/16.
 */

public class LocationFoundAdapter extends RecyclerView.Adapter<LocationFoundAdapter.ViewHolder> {

    private List<LocationFoundModel> data;

    public interface OnItemClickListener {
        void onItemClicked(LocationFoundModel groupModel);
    }

    private OnItemClickListener onItemClickListener;

    public LocationFoundAdapter(List<LocationFoundModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location_found, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LocationFoundModel model = data.get(position);
        holder.tvAddress.setText(model.getAddress());
        holder.tvDescription.setText(model.getDescription());
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
        @BindView(R.id.tvAddress)
        TextView tvAddress;
        @BindView(R.id.tvDescription)
        TextView tvDescription;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
