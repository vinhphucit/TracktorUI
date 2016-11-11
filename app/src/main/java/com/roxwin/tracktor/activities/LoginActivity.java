package com.roxwin.tracktor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.fragments.BaseLoginFragment;
import com.roxwin.tracktor.fragments.LoginFragment;

import butterknife.BindView;

/**
 * Created by phuctran on 11/5/16.
 */

public class LoginActivity extends BaseActivity implements BaseLoginFragment.BaseFragmentResponder {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private static final String FRAGMENT_LOGIN = "FRAGMENT_LOGIN";
    private static final String FRAGMENT_REGISTER = "FRAGMENT_REGISTER";


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().hide();
        loadFirstFragment(savedInstanceState);
    }


    @Override
    public void startMasterActivity() {
        Intent intent = new Intent(this, MasterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void goToRegisterFragment() {

    }

    private void loadFirstFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            Log.d(TAG, "Show Login Fragment");
            showFragment(LoginFragment.newInstance(), FRAGMENT_LOGIN);
        }
    }
}
