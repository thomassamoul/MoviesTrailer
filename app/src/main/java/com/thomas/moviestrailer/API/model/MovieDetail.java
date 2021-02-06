package com.thomas.moviestrailer.API.model;

import com.google.gson.annotations.SerializedName;

public class MovieDetail {

    @SerializedName("overview")
    private String overview;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("original_language")
    private String language;

    @SerializedName("backdrop_path")
    private String backdrop;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("vote_average")
    private double rating;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("id")
    private int id;

    @SerializedName("budget")
    private int budget;

    @SerializedName("status")
    private String status;

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }


    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVideo() {
        return video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTagline() {
        return tagline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "overview='" + overview + '\'' +
                ", runtime=" + runtime +
                ", language='" + language + '\'' +
                ", backdrop='" + backdrop + '\'' +
                ", video=" + video +
                ", title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", revenue=" + revenue +
                ", releaseDate='" + releaseDate + '\'' +
                ", popularity=" + popularity +
                ", rating=" + rating +
                ", tagline='" + tagline + '\'' +
                ", id=" + id +
                ", budget=" + budget +
                ", status='" + status + '\'' +
                '}';
    }
}