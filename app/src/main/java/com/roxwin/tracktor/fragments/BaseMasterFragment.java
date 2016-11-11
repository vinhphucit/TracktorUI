package com.roxwin.tracktor.fragments;

import com.roxwin.tracktor.models.LocationProductModel;

public abstract class BaseMasterFragment extends BaseFragment {
    public void goToDashboardScreen() {
        ((BaseFragmentResponder) getActivity()).goToDashboardScreen();
    }

    public void goToTellUsScreen() {
        ((BaseFragmentResponder) getActivity()).goToTellUsScreen();
    }

    public void goToProductDetail(LocationProductModel productModel) {
        ((BaseFragmentResponder) getActivity()).goToProductDetail(productModel);
    }

    public void goToRentFarmEquipmentScreen() {
        ((BaseFragmentResponder) getActivity()).goToRentFarmEquipmentScreen();
    }

    public void goToFindLocationScreen() {
        ((BaseFragmentResponder) getActivity()).goToFindLocationScreen();
    }

    public void goToLocationProductsScreen(String locationDescription) {
        ((BaseFragmentResponder) getActivity()).goToLocationProductsScreen(locationDescription);
    }

    public void goToLocationOnMap() {
        ((BaseFragmentResponder) getActivity()).goToLocationOnMap();
    }

    public interface BaseFragmentResponder extends BaseFragment.BaseFragmentResponder {
        void goToDashboardScreen();

        void goToTellUsScreen();

        void goToRentFarmEquipmentScreen();

        void goToFindLocationScreen();

        void goToLocationProductsScreen(String locationDescription);

        void goToProductDetail(LocationProductModel productModel);

        void goToLocationOnMap();
    }
}