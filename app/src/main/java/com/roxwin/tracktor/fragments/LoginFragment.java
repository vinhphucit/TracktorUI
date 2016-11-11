package com.roxwin.tracktor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roxwin.tracktor.R;
import com.roxwin.tracktor.widgets.buttons.RoxwinRegularButton;
import com.roxwin.tracktor.widgets.edittexts.RoxwinRegularEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by phuctran on 11/5/16.
 */

public class LoginFragment extends BaseLoginFragment {
    private static final String TAG = LoginFragment.class.getSimpleName();

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected int getActionBarResource() {
        return R.string.login;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_login;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {

    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.login_btn)
    public void onClick() {
        startMasterActivity();
    }
}
