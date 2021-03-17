package com.thomas.moviestrailer.ui.series;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.Series;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SeriesViewModel extends ViewModel {

    MutableLiveData<Series> mutableLiveData = new MutableLiveData<>();

    public void getSeries() {
        APIManager.getApi().getSeries(APIManager.API_KEY, "en-US").
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(series -> {
                    mutableLiveData.setValue(series);


                }, throwable -> Log.e("get series", throwable.getMessage()));
    }

}