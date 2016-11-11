package com.roxwin.tracktor.fragments;

public abstract class BaseLoginFragment extends BaseFragment {
    public void startMasterActivity() {
        ((BaseFragmentResponder) getActivity()).startMasterActivity();
    }

    public void goToRegisterFragment() {
        ((BaseFragmentResponder) getActivity()).goToRegisterFragment();
    }

    public interface BaseFragmentResponder extends BaseFragment.BaseFragmentResponder {
        void startMasterActivity();

        void goToRegisterFragment();
    }
}
