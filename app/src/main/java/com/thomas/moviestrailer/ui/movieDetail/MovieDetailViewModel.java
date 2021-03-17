package com.thomas.moviestrailer.ui.movieDetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.CastAndCrew;
import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.ui.movies.MoviesFragment;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieDetailViewModel extends ViewModel {

    public MutableLiveData<MovieDetail> movieDetailData = new MutableLiveData<>();
    MutableLiveData<CastAndCrew> castData = new MutableLiveData<>();
    int movieId = MoviesFragment.movieId;

    public void getDetail() {
        APIManager.getApi().getMovieDetail(movieId, APIManager.API_KEY).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieDetail -> {
                    movieDetailData.setValue(movieDetail);
                });
    }

    public void getCast() {
        APIManager.getApi().getMovieCast(movieId, APIManager.API_KEY).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(castAndCrew -> castData.setValue(castAndCrew));
    }
}
