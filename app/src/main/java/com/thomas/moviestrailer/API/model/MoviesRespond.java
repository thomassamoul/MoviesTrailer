package com.thomas.moviestrailer.API.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesRespond implements Parcelable {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("total_results")
    @Expose
    private Integer totalMovies;

    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    @SerializedName("results")
    private List<MoviesItem> results = null;

    public final static Parcelable.Creator<MoviesRespond> CREATOR = new Creator<MoviesRespond>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MoviesRespond createFromParcel(Parcel in) {
            return new MoviesRespond(in);
        }

        public MoviesRespond[] newArray(int size) {
            return (new MoviesRespond[size]);
        }

    };

    protected MoviesRespond(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalMovies = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (MoviesItem.class.getClassLoader()));
    }


    public void setResults(List<MoviesItem> results) {
        this.results = results;
    }

    public List<MoviesItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "Movies{" +
                        "results = '" + results + '\'' +
                        "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(totalMovies);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }
}