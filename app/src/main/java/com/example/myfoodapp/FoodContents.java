package com.example.myfoodapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodContents implements Parcelable {
    int img;

    public FoodContents(int img, String txt1, String txt2) {
        this.img = img;
        this.txt1 = txt1;
        this.txt2 = txt2;
    }

    String txt1 , txt2;

    protected FoodContents(Parcel in) {
        img = in.readInt();
        txt1 = in.readString();
        txt2 = in.readString();
    }

    public static final Creator<FoodContents> CREATOR = new Creator<FoodContents>() {
        @Override
        public FoodContents createFromParcel(Parcel in) {
            return new FoodContents(in);
        }

        @Override
        public FoodContents[] newArray(int size) {
            return new FoodContents[size];
        }
    };

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(img);
        dest.writeString(txt1);
        dest.writeString(txt2);
    }
}
