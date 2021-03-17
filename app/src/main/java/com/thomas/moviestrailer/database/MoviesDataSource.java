package com.thomas.moviestrailer.database;

import com.thomas.moviestrailer.API.model.MovieDetail;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface MoviesDataSource {
    Completable insertMovie(MovieDetail... favouriteMovies);

    Completable deleteMovie(MovieDetail favouriteMovies);

    Flowable<List<MovieDetail>> getFavMovies();

}
