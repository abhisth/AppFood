package com.example.myfoodapp;

import android.os.Parcel;
import android.os.Parcelable;

public class DrinksContents implements Parcelable {
    int img;

    protected DrinksContents(Parcel in) {
        img = in.readInt();
        name = in.readString();
        price = in.readString();
    }

    public static final Creator<DrinksContents> CREATOR = new Creator<DrinksContents>() {
        @Override
        public DrinksContents createFromParcel(Parcel in) {
            return new DrinksContents(in);
        }

        @Override
        public DrinksContents[] newArray(int size) {
            return new DrinksContents[size];
        }
    };

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public DrinksContents(int img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    String name , price;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(img);
        dest.writeString(name);
        dest.writeString(price);
    }
}
