package com.thomas.moviestrailer.ui.favourite;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.database.MoviesDatabase;
import com.thomas.moviestrailer.database.model.FavouriteMovies;

import java.util.List;

public class FavouriteViewModel extends ViewModel {

    MutableLiveData<List<FavouriteMovies>> data = new MutableLiveData<>();

    LiveData<List<FavouriteMovies>> list;

    public void getFav(Context context) {
        list = MoviesDatabase.getInstance(context).moviesDAO().getFavMovies();
    }
}