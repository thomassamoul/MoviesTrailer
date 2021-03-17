package com.thomas.moviestrailer.database.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.thomas.moviestrailer.API.model.MovieDetail;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface MoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertMovie(MovieDetail... favouriteMovies);

//    @Insert
//    void insertSeries(FavouriteSeries favouriteSeries);

    @Delete
    Completable deleteMovie(MovieDetail favouriteMovies);

//    @Delete
//    void deleteSeries(FavouriteSeries favouriteSeries);


//    @Query("delete from FavouriteMovies where id=:id")
//    void deleteMovieById(int id);
//
//    @Query("delete from FavouriteSeries where id=:id")
//    void deleteSeriesById(int id);

    @Query("select * from MovieDetail")
    Flowable<List<MovieDetail>> getFavMovies();

//    @Query("select * from FavouriteSeries")
//    LiveData<List<FavouriteSeries>> getFavSeries();


}
