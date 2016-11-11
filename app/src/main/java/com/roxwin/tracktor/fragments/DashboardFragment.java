package com.roxwin.tracktor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roxwin.tracktor.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by phuctran on 11/7/16.
 */

public class DashboardFragment extends BaseMasterFragment {
    private static final String TAG = DashboardFragment.class.getSimpleName();

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    protected int getActionBarResource() {
        return R.string.action_bar_dashboard;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {

    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }

    @OnClick(R.id.btn_find_equipment)
    public void onClickFindEquipment() {
        goToFindLocationScreen();
    }

    @OnClick(R.id.btn_list_equipment)
    public void onClickListEquipment() {
        goToTellUsScreen();
    }
}
