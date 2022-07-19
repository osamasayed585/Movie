package com.seenapay.movie.network.Models.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Link implements Parcelable {

    private String type;
    private String url;
    @SerializedName("suggested_link_text")
    private String suggested;

    protected Link(Parcel in) {
        type = in.readString();
        url = in.readString();
        suggested = in.readString();
    }

    public static final Creator<Link> CREATOR = new Creator<Link>() {
        @Override
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        @Override
        public Link[] newArray(int size) {
            return new Link[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(url);
        parcel.writeString(suggested);
    }
}
