package com.thomas.moviestrailer.ui.movies;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.MoviesRespond;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoviesViewModel extends ViewModel {

    MutableLiveData<MoviesRespond> mutableLiveData = new MutableLiveData<>();

    public void getMovies() {
        APIManager.getApi().getAllMovie(APIManager.API_KEY).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviesRespond -> {
                    mutableLiveData.setValue(moviesRespond);
                }, throwable -> Log.e("get series", throwable.getMessage()));
    }
}

