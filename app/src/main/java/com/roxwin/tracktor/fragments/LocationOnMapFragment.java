package com.roxwin.tracktor.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.roxwin.tracktor.R;

import butterknife.BindView;

/**
 * Created by phuctran on 11/7/16.
 */

public class LocationOnMapFragment extends BaseMasterFragment implements OnMapReadyCallback {
    private static final String TAG = LocationOnMapFragment.class.getSimpleName();

    @BindView(R.id.mapView)
    MapView mMapView;
    private GoogleMap mGoogleMap;

    public static LocationOnMapFragment newInstance() {
        return new LocationOnMapFragment();
    }

    @Override
    protected int getActionBarResource() {
        return R.string.find_location;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_location_on_map;
    }

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setupGoogleMap(savedInstanceState);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMapView != null)
            mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMapView != null)
            mMapView.onPause();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        Marker marker = mGoogleMap.addMarker(
                new MarkerOptions().
                        position(new LatLng(40.7143528, -74.0059731)).
                        title("US Citizenship and Immigration Service").
                        icon(getMarkerIconFromDrawble(R.drawable.map_marker_ongoing))
        );

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(marker.getPosition());
        LatLngBounds bounds = builder.build();
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(bounds.getCenter(), 15);
        mGoogleMap.moveCamera(cu);
    }

    public static BitmapDescriptor getMarkerIconFromDrawble(int id) {
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(id);

        return icon;
    }

    private void setupGoogleMap(Bundle savedInstanceState) {
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);
    }

    @Override
    protected String getSubclassName() {
        return TAG;
    }
}
