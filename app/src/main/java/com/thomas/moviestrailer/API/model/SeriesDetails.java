package com.thomas.moviestrailer.API.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeriesDetails {

    @SerializedName("overview")
    private String overview;

    @SerializedName("id")
    private int id;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("seasons")
    private List<SeasonsItem> seasons;

    @SerializedName("original_name")
    private String originalName;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("type")
    private String type;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("status")
    private String status;

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setSeasons(List<SeasonsItem> seasons) {
        this.seasons = seasons;
    }

    public List<SeasonsItem> getSeasons() {
        return seasons;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "SeriesDetails{" +
                        "overview = '" + overview + '\'' +
                        ",original_language = '" + originalLanguage + '\'' +
                        ",seasons = '" + seasons + '\'' +
                        ",production_companies = '" + '\'' +
                        ",original_name = '" + originalName + '\'' +
                        ",popularity = '" + popularity + '\'' +
                        ",vote_average = '" + voteAverage + '\'' +
                        ",type = '" + type + '\'' +
                        ",vote_count = '" + voteCount + '\'' +
                        ",poster_path = '" + posterPath + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}