package com.roxwin.tracktor.models;

/**
 * Created by phuctran on 11/7/16.
 */

public class LocationFoundModel {
    private String address;
    private String description;

    public LocationFoundModel(String address, String description) {
        this.address = description;
        this.description = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
