package com.example.mohamed.stream;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mohamed on 12/7/2017.
 */

public class ChannelDetails implements Parcelable {

    private String mChannelLink;
    private String mTitle;

    public ChannelDetails() {}



    public void setmChannelLink(String mChannelLink) {
        this.mChannelLink = mChannelLink;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmChannelLink() {
        return mChannelLink;
    }

    public String getmTitle() {
        return mTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(mTitle);
        parcel.writeString(mChannelLink);
    }

    protected ChannelDetails(Parcel parcel) {

        mTitle = parcel.readString();
        mChannelLink = parcel.readString();
    }

    public static final Creator<ChannelDetails> CREATOR = new Creator<ChannelDetails>() {
        @Override
        public ChannelDetails createFromParcel(Parcel parcel) {
            return new ChannelDetails(parcel);
        }

        @Override
        public ChannelDetails[] newArray(int i) {
            return new ChannelDetails[i];
        }
    };

}
