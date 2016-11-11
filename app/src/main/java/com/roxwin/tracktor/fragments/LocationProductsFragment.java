package com.roxwin.tracktor.fragments;

import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.activities.MasterActivity;
import com.roxwin.tracktor.adapters.LocationFoundAdapter;
import com.roxwin.tracktor.adapters.LocationProductAdapter;
import com.roxwin.tracktor.models.LocationFoundModel;
import com.roxwin.tracktor.models.LocationProductModel;
import com.roxwin.tracktor.utils.GridSpacingItemDecoration;
import com.roxwin.tracktor.widgets.edittexts.RoxwinRegularEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phuctran on 11/7/16.
 */

public class LocationProductsFragment extends BaseMasterFragment {
    private static final String TAG = LocationProductsFragment.class.getSimpleName();

    private static final String ARGS_LOCATION_DETAIL = "ARGS_LOCATION_DETAIL";

    @BindView(R.id.rvLocationProducts)
    RecyclerView rvLocationProducts;

    private List<LocationProductModel> data;
    private LocationProductAdapter adapter;

    public static LocationProductsFragment newInstance(String title) {
        LocationProductsFragment fragment = new LocationProductsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_LOCATION_DETAIL, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_location_product, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(((MasterActivity) getActivity()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                          }
                                      }
        );
    }

    @Override
    protected int getActionBarResource() {
        return R.string.find_location;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_location_products;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        setActionBarTitle(getArguments().getString(ARGS_LOCATION_DETAIL, ""));
        initData();
        initRecycleView();
    }

    private void initRecycleView() {
        adapter = new LocationProductAdapter(data);
        adapter.setOnItemClickListener(onItemClickListener);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);

        rvLocationProducts.setLayoutManager(mLayoutManager);
        rvLocationProducts.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(2), true));
        rvLocationProducts.setItemAnimator(new DefaultItemAnimator());
        rvLocationProducts.setAdapter(adapter);
    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }

    private LocationProductAdapter.OnItemClickListener onItemClickListener = new LocationProductAdapter.OnItemClickListener() {
        @Override
        public void onItemClicked(LocationProductModel category) {
            goToProductDetail(category);
        }
    };

    private void initData() {

        //Guadalajara, Monterrey, Oaxaca, Sonora, Veracruz, Chiapas, Yucatan and Aguascalientes
        data = new ArrayList<>();
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));
        data.add(new LocationProductModel("2012", "Kubota L3800 (4WD)", "80£"));
        data.add(new LocationProductModel("2013", "NH TT 75 (2WD)", "75£"));

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

