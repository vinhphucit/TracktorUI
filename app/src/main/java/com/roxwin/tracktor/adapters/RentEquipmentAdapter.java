package com.roxwin.tracktor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.models.RentEquipmentModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phuctran on 11/7/16.
 */

public class RentEquipmentAdapter extends RecyclerView.Adapter<RentEquipmentAdapter.ViewHolder> {

    private List<RentEquipmentModel> data;

    public RentEquipmentAdapter(List<RentEquipmentModel> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rent_farm_equipment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RentEquipmentModel model = data.get(position);
        holder.ivLogo.setImageResource(model.getImageResource());
        holder.tvPrice.setText(model.getRate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.ivLogo)
        ImageView ivLogo;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
