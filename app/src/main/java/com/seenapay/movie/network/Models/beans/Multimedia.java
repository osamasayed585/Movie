package com.seenapay.movie.network.Models.beans;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Multimedia implements Parcelable {

    private String type;
    private String src;
    private int height;
    private int width;

    protected Multimedia(Parcel in) {
        type = in.readString();
        src = in.readString();
        height = in.readInt();
        width = in.readInt();
    }

    public static final Creator<Multimedia> CREATOR = new Creator<Multimedia>() {
        @Override
        public Multimedia createFromParcel(Parcel in) {
            return new Multimedia(in);
        }

        @Override
        public Multimedia[] newArray(int size) {
            return new Multimedia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(type);
        parcel.writeString(src);
        parcel.writeInt(height);
        parcel.writeInt(width);
    }
}

