package com.thomas.moviestrailer.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class FavouriteMovies {
    @PrimaryKey(autoGenerate = false)
    int id;

    @ColumnInfo(name = "movie_id")
    int movieId;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "original_language")
    private String language;

    @ColumnInfo(name = "backdrop_path")
    private String backdrop;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "poster_path")
    private String posterPath;

    @ColumnInfo(name = "status")
    private String status;

    public FavouriteMovies() {
    }

    @Ignore
    public FavouriteMovies(int movieId, String overview, String language, String backdrop, String title, String posterPath, String status) {
        this.movieId = movieId;
        this.overview = overview;
        this.language = language;
        this.backdrop = backdrop;
        this.title = title;
        this.posterPath = posterPath;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
