package com.thomas.moviestrailer.ui.seriesDetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.model.SeriesDetails;
import com.thomas.moviestrailer.ui.series.SeriesFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesDetailViewModel extends ViewModel {

    MutableLiveData<SeriesDetails> seriesDetailsMutableLiveData = new MutableLiveData<>();

    int tv_id = SeriesFragment.seriesId;

    public void getDetails() {
        APIManager.getApi().getSeriesDetails(tv_id, APIManager.API_KEY).enqueue(new Callback<SeriesDetails>() {
            @Override
            public void onResponse(Call<SeriesDetails> call, Response<SeriesDetails> response) {
                seriesDetailsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SeriesDetails> call, Throwable t) {

            }
        });
    }


}
