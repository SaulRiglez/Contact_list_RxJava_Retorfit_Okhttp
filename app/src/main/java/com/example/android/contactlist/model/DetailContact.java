package com.example.android.contactlist.model;


import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by User on 2/8/2017.
 */

public class DetailContact implements Parcelable{

    private String contactName;
    private String contactPictureLarge;
    private String contactPhonenumber;
    private String contactCompany;


    public DetailContact(String contactName, String contactPictureLarge
            , String contactPhonenumber
            , String contactCompany) {
        this.contactName = contactName;
        this.contactPictureLarge = contactPictureLarge;
        this.contactPhonenumber = contactPhonenumber;
        this.contactCompany = contactCompany;
    }

    protected DetailContact(Parcel in) {
        contactName = in.readString();
        contactPictureLarge = in.readString();
        contactPhonenumber = in.readString();
        contactCompany = in.readString();
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPictureLarge() {
        return contactPictureLarge;
    }

    public String getContactPhonenumber() {
        return contactPhonenumber;
    }

    public String getContactCompany() {
        return contactCompany;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(contactName);
        dest.writeString(contactPictureLarge);
        dest.writeString(contactPhonenumber);
        dest.writeString(contactCompany);
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
