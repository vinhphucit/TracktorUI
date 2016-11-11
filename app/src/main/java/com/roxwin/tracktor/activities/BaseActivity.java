package com.roxwin.tracktor.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.fragments.BaseFragment;
import com.roxwin.tracktor.utils.Toaster;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

/**
 * Created by phuctran on 11/5/16.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseFragment.BaseFragmentResponder {
    private static final String TAG = BaseActivity.class.getSimpleName();


    @BindView(R.id.rootLayout)
    View mLayout;
    @Nullable
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        updateFollowingViewBinding(savedInstanceState);
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_right);
    }

    protected abstract int getLayoutResource();

    protected abstract void updateFollowingViewBinding(Bundle savedInstanceState);


    protected void showToast(int resourceText) {
        showToast(getResources().getString(resourceText), Toaster.Duration.LONG);
    }

    protected void showToast(int resourceText, Toaster.Duration duration) {
        showToast(getResources().getString(resourceText), duration);
    }

    protected void showToast(String text) {
        showToast(text, Toaster.Duration.LONG);
    }

    protected void showToast(String text, Toaster.Duration duration) {
        Toaster.showToast(this, text, duration);
    }

    public void setActionBarTitle(CharSequence charsequence) {
        if (charsequence == null) {
            Log.w(TAG, "setActionBarTitle - title is null, so defaulting to full_app_name.");
            charsequence = getString(R.string.app_name);
        }
        mToolbarTitle.setText(charsequence);
    }

    public void setActionBarTitle(int actionBarTitle) {
        setActionBarTitle(getResources().getString(actionBarTitle));
    }

    public void setActionBarTitle(String actionBarTitle) {
        if (actionBarTitle == null) {
            Log.w(TAG, "setActionBarTitle - title is null, so defaulting to full_app_name.");
            actionBarTitle = getString(R.string.app_name);
        }
        mToolbarTitle.setText(actionBarTitle);
    }

    @Override
    public void showFragment(BaseFragment fragment, String fragmentTag) {
        Log.w(TAG, "showFragment - DEFAULT implementation called in BaseActivity");
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmenttransaction.replace(R.id.fragmentContainer, fragment, fragmentTag);
        fragmenttransaction.addToBackStack(fragmentTag);
        fragmenttransaction.commit();
    }

}
