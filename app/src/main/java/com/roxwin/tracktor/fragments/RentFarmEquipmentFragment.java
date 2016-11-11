package com.roxwin.tracktor.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.adapters.RentEquipmentAdapter;
import com.roxwin.tracktor.models.RentEquipmentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by phuctran on 11/6/16.
 */

public class RentFarmEquipmentFragment extends BaseMasterFragment {
    private static final String TAG = RentFarmEquipmentFragment.class.getSimpleName();

    @BindView(R.id.rvRentEquipment)
    RecyclerView rvRentEquipment;

    private RentEquipmentAdapter mRentEquipmentAdapter;
    private List<RentEquipmentModel> mRentData;

    public static RentFarmEquipmentFragment newInstance() {
        return new RentFarmEquipmentFragment();
    }

    @Override
    protected int getActionBarResource() {
        return R.string.rent_farm_equipment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_rent_farm_equipment;
    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRentEquipmentAdapter = new RentEquipmentAdapter(mRentData);
        rvRentEquipment.setLayoutManager(horizontalLayoutManagaer);
        rvRentEquipment.setAdapter(mRentEquipmentAdapter);
    }

    private void initData() {
        mRentData = new ArrayList<>();
        mRentData.add(new RentEquipmentModel(R.drawable.dummy_data_image_1, "10£/hr"));
        mRentData.add(new RentEquipmentModel(R.drawable.dummy_data_image_1, "20£/hr"));
        mRentData.add(new RentEquipmentModel(R.drawable.dummy_data_image_1, "30£/hr"));
        mRentData.add(new RentEquipmentModel(R.drawable.dummy_data_image_1, "40£/hr"));
        mRentData.add(new RentEquipmentModel(R.drawable.dummy_data_image_1, "50£/hr"));
        mRentData.add(new RentEquipmentModel(R.drawable.dummy_data_image_1, "60£/hr"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btn_find_equipment)
    public void onClick() {
        goToFindLocationScreen();
    }
}
