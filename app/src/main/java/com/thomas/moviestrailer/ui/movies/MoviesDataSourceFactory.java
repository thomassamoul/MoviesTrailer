package com.thomas.moviestrailer.ui.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.thomas.moviestrailer.API.WebService;

public class MoviesDataSourceFactory extends DataSource.Factory {

    private MoviesDataSource moviesDataSource;
    private WebService webService;
    private Application application;
    private MutableLiveData<MoviesDataSource> mutableLiveData;

    public MoviesDataSourceFactory(WebService webService, Application application) {
        this.webService = webService;
        this.application = application;
        mutableLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        moviesDataSource = new MoviesDataSource(webService, application);
        mutableLiveData.postValue(moviesDataSource);
        return moviesDataSource;
    }

    public MutableLiveData<MoviesDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

}
