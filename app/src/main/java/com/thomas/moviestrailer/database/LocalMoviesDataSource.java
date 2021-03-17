package com.thomas.moviestrailer.database;

import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.database.DAOs.MoviesDAO;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class LocalMoviesDataSource implements MoviesDataSource {
    public final MoviesDAO moviesDAO;

    public LocalMoviesDataSource(MoviesDAO moviesDAO) {
        this.moviesDAO = moviesDAO;
    }

    @Override
    public Completable insertMovie(MovieDetail... favouriteMovies) {
        return moviesDAO.insertMovie(favouriteMovies);
    }

    @Override
    public Completable deleteMovie(MovieDetail favouriteMovies) {
        return moviesDAO.deleteMovie(favouriteMovies);
    }

    @Override
    public Flowable<List<MovieDetail>> getFavMovies() {
        return moviesDAO.getFavMovies();
    }
}
