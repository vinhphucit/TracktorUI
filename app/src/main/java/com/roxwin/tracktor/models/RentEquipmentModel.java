package com.roxwin.tracktor.models;

/**
 * Created by phuctran on 11/7/16.
 */

public class RentEquipmentModel {
    private int imageResource;
    private String rate;

    public RentEquipmentModel(int imageResource, String rate) {
        this.imageResource = imageResource;
        this.rate = rate;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
