package com.roxwin.tracktor.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.fragments.BaseMasterFragment;
import com.roxwin.tracktor.fragments.DashboardFragment;
import com.roxwin.tracktor.fragments.FindLocationFragment;
import com.roxwin.tracktor.fragments.LocationOnMapFragment;
import com.roxwin.tracktor.fragments.LocationProductsFragment;
import com.roxwin.tracktor.fragments.ProductDetailFragment;
import com.roxwin.tracktor.fragments.RentFarmEquipmentFragment;
import com.roxwin.tracktor.fragments.TellUsAboutYourTractorFragment;
import com.roxwin.tracktor.models.LocationProductModel;

import butterknife.BindView;

/**
 * Created by phuctran on 11/5/16.
 */

public class MasterActivity extends BaseActivity implements BaseMasterFragment.BaseFragmentResponder, View.OnClickListener {
    private static final String TAG = MasterActivity.class.getSimpleName();

    private static final String FRAGMENT_DASHBOARD = "FRAGMENT_DASHBOARD";
    private static final String FRAGMENT_RENT_FARM_EQUIPMENT = "FRAGMENT_RENT_FARM_EQUIPMENT";
    private static final String FRAGMENT_FIND_LOCATION = "FRAGMENT_FIND_LOCATION";
    private static final String FRAGMENT_LOCATION_ON_MAP = "FRAGMENT_LOCATION_ON_MAP";
    private static final String FRAGMENT_TELL_US = "FRAGMENT_TELL_US";
    private static final String FRAGMENT_LOCATION_PRODUCTS = "FRAGMENT_LOCATION_PRODUCTS";
    private static final String FRAGMENT_PRODUCT_DETAIL = "FRAGMENT_PRODUCT_DETAIL";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rootLayout)
    DrawerLayout mDrawer;
    @BindView(R.id.left_drawer)
    View mNavigationLayout;

    @BindView(R.id.nav_browse_equipment)
    RelativeLayout navBrowseEquipment;
    @BindView(R.id.nav_dashboard)
    RelativeLayout navDashboard;
    @BindView(R.id.nav_messages)
    RelativeLayout navMessages;
    @BindView(R.id.nav_list_your_equipment)
    RelativeLayout navListYourEquipment;
    @BindView(R.id.nav_rent_history)
    RelativeLayout navRentHistory;
    @BindView(R.id.nav_favourites)
    RelativeLayout navFavourites;
    @BindView(R.id.nav_account)
    RelativeLayout navAccount;
    @BindView(R.id.nav_earn_free_rents)
    RelativeLayout navEarnFreeRents;
    @BindView(R.id.nav_how_tracktor_works)
    RelativeLayout navHowTracktorWorks;
    @BindView(R.id.nav_contact_support)
    RelativeLayout navContactSupport;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_master;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        initActionBar();
        initNavigationBar();
        initView();
        goToDashboardScreen();
    }

    private void initView() {
        navBrowseEquipment.setOnClickListener(this);
        navDashboard.setOnClickListener(this);
        navListYourEquipment.setOnClickListener(this);
    }

    private void initNavigationBar() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        Log.d(TAG, "number of back stack: " + getSupportFragmentManager().getBackStackEntryCount());
//                        if (MasterActivity.this.getSupportFragmentManager().getBackStackEntryCount() == 0) {
//                            onBackPressed();
//                        } else
                        if (MasterActivity.this.getSupportFragmentManager().getBackStackEntryCount() == 1) {
                            MasterActivity.this.updateToolbarWithHomeButton();
                        } else {
                            MasterActivity.this.updateToolbarWithBackButton();
                        }
                    }
                });
        mDrawerToggle.setToolbarNavigationClickListener(v -> onBackPressed());
    }

    private void initActionBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void updateToolbarWithBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if (null != mDrawerToggle && null != actionBar) {
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
//                updateToolbarWithHomeButton();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            Log.d(TAG, "onBackPressed: " + getSupportFragmentManager().getBackStackEntryCount());
            if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
                finish();
            } else {
//                updateToolbarWithHomeButton();
                super.onBackPressed();
            }
        }
    }

    private void updateToolbarWithHomeButton() {
        ActionBar actionBar = getSupportActionBar();
        if (null != mDrawerToggle && null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            mDrawerToggle.syncState();
        }
    }

    private void clearFragmentStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
    }

    private void removePreviousFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        }
    }

    @Override
    public void goToDashboardScreen() {
        clearFragmentStack();
        showFragment(DashboardFragment.newInstance(), FRAGMENT_DASHBOARD);
    }

    @Override
    public void goToTellUsScreen() {

        clearFragmentStack();
        showFragment(TellUsAboutYourTractorFragment.newInstance(), FRAGMENT_TELL_US);
    }

    @Override
    public void goToRentFarmEquipmentScreen() {
        clearFragmentStack();
        showFragment(RentFarmEquipmentFragment.newInstance(), FRAGMENT_RENT_FARM_EQUIPMENT);
    }

    @Override
    public void goToFindLocationScreen() {
        showFragment(FindLocationFragment.newInstance(), FRAGMENT_FIND_LOCATION);
    }

    @Override
    public void goToLocationProductsScreen(String locationDescription) {
        showFragment(LocationProductsFragment.newInstance(locationDescription), FRAGMENT_LOCATION_PRODUCTS);
    }

    @Override
    public void goToProductDetail(LocationProductModel productModel) {
        showFragment(ProductDetailFragment.newInstance(productModel), FRAGMENT_PRODUCT_DETAIL);
    }

    @Override
    public void goToLocationOnMap() {
        showFragment(LocationOnMapFragment.newInstance(), FRAGMENT_LOCATION_ON_MAP);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_browse_equipment:
                goToRentFarmEquipmentScreen();
                break;
            case R.id.nav_dashboard:
                goToDashboardScreen();
                break;
            case R.id.nav_list_your_equipment:
                goToTellUsScreen();
                break;
        }
        mDrawer.closeDrawer(mNavigationLayout);
    }
}
