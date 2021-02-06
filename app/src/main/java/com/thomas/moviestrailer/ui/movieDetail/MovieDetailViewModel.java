package com.thomas.moviestrailer.ui.movieDetail;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.CastAndCrew;
import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.ui.movies.MoviesFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailViewModel extends ViewModel {

    public MutableLiveData<MovieDetail> movieDetailData = new MutableLiveData<>();
    MutableLiveData<CastAndCrew> castData = new MutableLiveData<>();
    int movieId = MoviesFragment.movieId;

    public void getDetail() {
        APIManager.getApi().getMovieDetail(movieId, APIManager.API_KEY).enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                movieDetailData.setValue(response.body());
                Log.e("detailTAG", response.body().toString());
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
            }
        });
    }

    public void getCast() {
        APIManager.getApi().getMovieCast(movieId, APIManager.API_KEY).enqueue(new Callback<CastAndCrew>() {
            @Override
            public void onResponse(Call<CastAndCrew> call, Response<CastAndCrew> response) {
                castData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CastAndCrew> call, Throwable t) {

            }
        });
    }
}
