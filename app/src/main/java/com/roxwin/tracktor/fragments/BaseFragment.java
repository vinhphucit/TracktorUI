package com.roxwin.tracktor.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roxwin.tracktor.activities.MasterActivity;
import com.roxwin.tracktor.utils.Toaster;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by phuctran on 11/5/16.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(getSubclassName(), (new StringBuilder()).append("onCreateView:").append(getClass().getName()).toString());

        final View fragmentView = inflater.inflate(getLayoutResource(), container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        updateActionBarTitle();
        updateFollowingViewBinding(savedInstanceState);
        return fragmentView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getSubclassName(), (new StringBuilder()).append("onCreate:").append(getClass().getName()).toString());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(getSubclassName(), (new StringBuilder()).append("onPause:").append(getClass().getName()).toString());

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getSubclassName(), (new StringBuilder()).append("onResume:").append(getClass().getName()).toString());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(getSubclassName(), (new StringBuilder()).append("onViewCreated:").append(getClass().getName()).toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(getSubclassName(), (new StringBuilder()).append("onAttach:").append(getClass().getName()).toString());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(getSubclassName(), (new StringBuilder()).append("onDetach:").append(getClass().getName()).toString());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(getSubclassName(), (new StringBuilder()).append("onDestroy:").append(getClass().getName()).toString());

    }

    protected void updateActionBarTitle() {
        setActionBarTitle(getActionBarResource());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Log.d(getSubclassName(), (new StringBuilder()).append("onDestroyView:").append(getClass().getName()).toString());

    }


    protected abstract int getActionBarResource();

    protected abstract int getLayoutResource();

    protected abstract void updateFollowingViewBinding(Bundle savedInstanceState);

    protected ActionBar getActionBar() {
        Activity localActivity = getActivity();
        if ((localActivity instanceof AppCompatActivity)) {
            return ((AppCompatActivity) localActivity).getSupportActionBar();
        }
        return null;
    }

    public void showFragment(BaseFragment fragment) {
        Log.d(getSubclassName(), (new StringBuilder()).append("showFragment called with tag: ").append(getSubclassName()).toString());
        ((BaseFragmentResponder) getActivity()).showFragment(fragment, fragment.getSubclassName());
    }

    protected abstract String getSubclassName();

    public void showToast(int i) {
        if (!isAdded()) {
            Log.w(TAG, "showToast - Fragment is not added; aborting showing Toast");
        } else {
            showToast(getResources().getString(i));
        }
    }

    public void showToast(String text) {
        showToast(text, Toaster.Duration.LONG);
    }

    protected void showToast(String text, Toaster.Duration duration) {
        if (getActivity() == null) {
            Log.e(TAG, "showToast - getActivity() is null; aborting showing Toast");
        } else {
            Toaster.showToast(getActivity(), text, duration);
        }
    }

    protected void setActionBarTitle(int i) {
        setActionBarTitle(getResources().getString(i));
    }

    protected void setActionBarTitle(String actionBarTitle) {
        if (getActivity() instanceof MasterActivity) {
            ((BaseFragmentResponder) getActivity()).setActionBarTitle(actionBarTitle);
        } else {
            ActionBar actionbar = getActionBar();
            if (actionbar != null) {
                actionbar.setTitle(actionBarTitle);
            }
        }
    }

    protected void setActionBarTitle(CharSequence actionBarTitle) {
        if (getActivity() instanceof MasterActivity) {
            ((BaseFragmentResponder) getActivity()).setActionBarTitle(actionBarTitle);
        } else {
            ActionBar actionbar = getActionBar();
            if (actionbar != null) {
                actionbar.setTitle(actionBarTitle);
            }
        }
    }

    public interface BaseFragmentResponder {
        void showFragment(BaseFragment fragment, String fragmentTag);

        void setActionBarTitle(int i);

        void setActionBarTitle(String actionBarTitle);

        void setActionBarTitle(CharSequence actionBarTitle);

    }
}
