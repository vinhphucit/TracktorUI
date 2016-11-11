package com.roxwin.tracktor.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.adapters.LocationFoundAdapter;
import com.roxwin.tracktor.models.LocationFoundModel;
import com.roxwin.tracktor.utils.GridSpacingItemDecoration;
import com.roxwin.tracktor.widgets.edittexts.RoxwinRegularEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phuctran on 11/7/16.
 */

public class FindLocationFragment extends BaseMasterFragment {
    private static final String TAG = FindLocationFragment.class.getSimpleName();
    @BindView(R.id.rvLocationFound)
    RecyclerView rvLocationFound;
    @BindView(R.id.tv_find_equipment)
    RoxwinRegularEditText tvFindEquipment;

    private List<LocationFoundModel> data;
    private LocationFoundAdapter adapter;

    public static FindLocationFragment newInstance() {
        return new FindLocationFragment();
    }

    @Override
    protected int getActionBarResource() {
        return R.string.find_location;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_find_location;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        adapter = new LocationFoundAdapter(data);
        adapter.setOnItemClickListener(onItemClickListener);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);

        rvLocationFound.setLayoutManager(mLayoutManager);
        rvLocationFound.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(2), true));
        rvLocationFound.setItemAnimator(new DefaultItemAnimator());
        rvLocationFound.setAdapter(adapter);
    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }

    private LocationFoundAdapter.OnItemClickListener onItemClickListener = new LocationFoundAdapter.OnItemClickListener() {
        @Override
        public void onItemClicked(LocationFoundModel category) {
            goToLocationProductsScreen(category.getAddress());
        }
    };

    private void initData() {

        //Guadalajara, Monterrey, Oaxaca, Sonora, Veracruz, Chiapas, Yucatan and Aguascalientes
        data = new ArrayList<>();
        data.add(new LocationFoundModel("Guadalajara", "Calz de las Palmas"));
        data.add(new LocationFoundModel("Monterrey", "Moctezuma"));
        data.add(new LocationFoundModel("Oaxaca", "Celestino Gasca, Monterry, Mexico"));
        data.add(new LocationFoundModel("Sonora", "Nuevo Repueblo, Monterrey, Mexico"));
        data.add(new LocationFoundModel("Veracruz", "Independencia, Monterrey, Mexico"));
        data.add(new LocationFoundModel("Chiapas", "Vivienda Popular, Guadalupe, Mexico"));
        data.add(new LocationFoundModel("Yucatan", "Orizaba, Guadalupe, Mexico"));
        data.add(new LocationFoundModel("Aguascalientes", "Rosalinda, Guadalupe, Mexico"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}

