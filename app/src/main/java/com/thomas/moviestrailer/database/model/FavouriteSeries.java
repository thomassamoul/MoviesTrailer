package com.thomas.moviestrailer.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class FavouriteSeries {

    @PrimaryKey(autoGenerate = false)
    int id;

    @ColumnInfo(name = "original_name")
    private String originalName;

    @ColumnInfo(name = "poster_path")
    private String posterPath;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "status")
    private String status;

//    @E(name = "seasons")
//    private List<SeasonsItem> seasons;

    public FavouriteSeries() {
    }

    @Ignore
    public FavouriteSeries(int id, String originalName, String posterPath, String overview, String status) {
        this.id = id;
        this.originalName = originalName;
        this.posterPath = posterPath;
        this.overview = overview;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
