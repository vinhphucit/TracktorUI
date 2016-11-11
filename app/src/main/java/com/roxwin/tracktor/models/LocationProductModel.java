package com.roxwin.tracktor.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by phuctran on 11/7/16.
 */

public class LocationProductModel implements Parcelable {
    private String brand;
    private String description;
    private String cost;

    public LocationProductModel(String brand, String description, String cost) {
        this.brand = brand;
        this.description = description;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.brand);
        dest.writeString(this.description);
        dest.writeString(this.cost);
    }

    protected LocationProductModel(Parcel in) {
        this.brand = in.readString();
        this.description = in.readString();
        this.cost = in.readString();
    }

    public static final Parcelable.Creator<LocationProductModel> CREATOR = new Parcelable.Creator<LocationProductModel>() {
        @Override
        public LocationProductModel createFromParcel(Parcel source) {
            return new LocationProductModel(source);
        }

        @Override
        public LocationProductModel[] newArray(int size) {
            return new LocationProductModel[size];
        }
    };
}
