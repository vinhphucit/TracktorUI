package com.roxwin.tracktor.fragments;

import android.os.Bundle;

import com.roxwin.tracktor.R;

/**
 * Created by phuctran on 11/6/16.
 */

public class TellUsAboutYourTractorFragment extends BaseMasterFragment {
    private static final String TAG = TellUsAboutYourTractorFragment.class.getSimpleName();

    public static TellUsAboutYourTractorFragment newInstance() {
        return new TellUsAboutYourTractorFragment();
    }

    @Override
    protected int getActionBarResource() {
        return R.string.tell_us_about_your_tractor;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tell_us_about_your_tractor;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {

    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }
}
