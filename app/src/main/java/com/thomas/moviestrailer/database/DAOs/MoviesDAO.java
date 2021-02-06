package com.thomas.moviestrailer.database.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.thomas.moviestrailer.database.model.FavouriteMovies;

import java.util.List;

@Dao
public interface MoviesDAO {

    @Insert
    void insertMovie(FavouriteMovies favouriteMovies);

//    @Insert
//    void insertSeries(FavouriteSeries favouriteSeries);

    @Delete
    void deleteMovie(FavouriteMovies favouriteMovies);

//    @Delete
//    void deleteSeries(FavouriteSeries favouriteSeries);


    @Query("delete from FavouriteMovies where id=:id")
    void deleteMovieById(int id);
//
//    @Query("delete from FavouriteSeries where id=:id")
//    void deleteSeriesById(int id);

    @Query("select * from FavouriteMovies")
    LiveData<List<FavouriteMovies>> getFavMovies();

//    @Query("select * from FavouriteSeries")
//    LiveData<List<FavouriteSeries>> getFavSeries();


}
