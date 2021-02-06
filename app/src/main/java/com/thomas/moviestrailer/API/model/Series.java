package com.thomas.moviestrailer.API.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Series {

    @SerializedName("results")
    private List<SeriesItem> results;

    public void setResults(List<SeriesItem> results) {
        this.results = results;
    }

    public List<SeriesItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "Series{" +
                        "results = '" + results + '\'' +
                        "}";
    }
}