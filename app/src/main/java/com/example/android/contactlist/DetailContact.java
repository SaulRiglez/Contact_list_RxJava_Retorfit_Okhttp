package com.example.android.contactlist;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 2/8/2017.
 */

public class DetailContact implements Parcelable{

    private String contactName;
    private String contactPictureLarge;

    public DetailContact(String contactName, String contactPictureLarge) {
        this.contactName = contactName;
        this.contactPictureLarge = contactPictureLarge;
    }

    protected DetailContact(Parcel in) {
        contactName = in.readString();
        contactPictureLarge = in.readString();
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPictureLarge() {
        return contactPictureLarge;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contactName);

        dest.writeString(contactPictureLarge);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DetailContact> CREATOR = new Creator<DetailContact>() {
        @Override
        public DetailContact createFromParcel(Parcel in) {
            return new DetailContact(in);
        }

        @Override
        public DetailContact[] newArray(int size) {
            return new DetailContact[size];
        }
    };
}
