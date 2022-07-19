package com.seenapay.movie.network.Models.beans;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Movie implements Parcelable {


    private Link link;
    private Multimedia multimedia;
    private String byline;
    private String headline;


    @SerializedName("display_title")
    private String title;
    @SerializedName("mpaa_rating")
    private String rating;
    @SerializedName("critics_pick")
    private int pick;
    @SerializedName("summary_short")
    private String summary;
    @SerializedName("publication_date")
    private String publicationDate;
    @SerializedName("opening_date")
    private String openingDate;
    @SerializedName("date_updated")
    private String dateUpdated;


    protected Movie(Parcel in) {
        link = in.readParcelable(Link.class.getClassLoader());
        multimedia = in.readParcelable(Multimedia.class.getClassLoader());
        byline = in.readString();
        headline = in.readString();
        title = in.readString();
        rating = in.readString();
        pick = in.readInt();
        summary = in.readString();
        publicationDate = in.readString();
        openingDate = in.readString();
        dateUpdated = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(link, i);
        parcel.writeParcelable(multimedia, i);
        parcel.writeString(byline);
        parcel.writeString(headline);
        parcel.writeString(title);
        parcel.writeString(rating);
        parcel.writeInt(pick);
        parcel.writeString(summary);
        parcel.writeString(publicationDate);
        parcel.writeString(openingDate);
        parcel.writeString(dateUpdated);
    }
}
