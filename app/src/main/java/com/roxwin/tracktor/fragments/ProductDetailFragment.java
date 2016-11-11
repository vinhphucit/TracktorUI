package com.roxwin.tracktor.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.models.LocationProductModel;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by phuctran on 11/7/16.
 */

public class ProductDetailFragment extends BaseMasterFragment {
    private static final String TAG = ProductDetailFragment.class.getSimpleName();
    private static final String ARGS_PRODUCT = "ARGS_PRODUCT";
    private LocationProductModel productModel;

    public static ProductDetailFragment newInstance(LocationProductModel productModel) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGS_PRODUCT, productModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getActionBarResource() {
        return R.string.find_location;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_product_detail;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        productModel = getArguments().getParcelable(ARGS_PRODUCT);
        setActionBarTitle(productModel.getDescription());
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_product_detail, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btn_book)
    public void onClick() {
        new AlertDialog.Builder(getContext())
                .setTitle("Booking successful")
                .setMessage("Thanks for booking with us")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().onBackPressed();
                    }
                })
                .show();
    }
}
