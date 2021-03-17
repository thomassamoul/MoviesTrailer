package com.thomas.moviestrailer.ui.seriesDetail;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.SeriesDetails;
import com.thomas.moviestrailer.ui.series.SeriesFragment;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SeriesDetailViewModel extends ViewModel {

    MutableLiveData<SeriesDetails> seriesDetailsMutableLiveData = new MutableLiveData<>();

    int tv_id = SeriesFragment.seriesId;

    public void getDetails() {
        APIManager.getApi().getSeriesDetails(tv_id, APIManager.API_KEY).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(seriesDetails -> {
                    seriesDetailsMutableLiveData.setValue(seriesDetails);
                }, throwable -> Log.e("get details", throwable.getMessage()));
    }


}
