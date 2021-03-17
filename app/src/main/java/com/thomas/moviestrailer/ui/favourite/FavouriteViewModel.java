package com.thomas.moviestrailer.ui.favourite;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.database.LocalMoviesDataSource;
import com.thomas.moviestrailer.database.MoviesDataSource;
import com.thomas.moviestrailer.database.MoviesDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavouriteViewModel extends AndroidViewModel {

    MutableLiveData<List<MovieDetail>> data;
    MoviesDataSource dataSource;
    private final CompositeDisposable disposable;

    public FavouriteViewModel(@NonNull Application application) {
        super(application);
        data = new MutableLiveData<>();
        dataSource = new LocalMoviesDataSource(MoviesDatabase.getInstance(application).moviesDAO());
        disposable = new CompositeDisposable();
    }

    public LiveData<List<MovieDetail>> getMovies() {
        disposable.add(dataSource.getFavMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieDetails -> {
                    data.setValue(movieDetails);
                }, throwable -> Toast.makeText(getApplication(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show()));

        return data;
    }

}