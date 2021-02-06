package com.thomas.moviestrailer.ui.series;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.Series;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesViewModel extends ViewModel {

    MutableLiveData<Series> mutableLiveData = new MutableLiveData<>();

    public void getSeries() {
        APIManager.getApi().getSeries(APIManager.API_KEY, "en-US").enqueue(new Callback<Series>() {
            @Override
            public void onResponse(Call<Series> call, Response<Series> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Series> call, Throwable t) {

            }
        });
    }

}