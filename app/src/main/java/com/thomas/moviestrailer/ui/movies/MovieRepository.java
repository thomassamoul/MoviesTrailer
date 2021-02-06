package com.thomas.moviestrailer.ui.movies;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.WebService;
import com.thomas.moviestrailer.API.model.MoviesItem;
import com.thomas.moviestrailer.API.model.MoviesRespond;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<MoviesItem> moviesItems = new ArrayList<>();

    private MutableLiveData<List<MoviesItem>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<MoviesItem>> getMutableLiveData() {
        WebService webService = APIManager.getApi();
        Call<MoviesRespond> call = webService.getAllMovie(APIManager.API_KEY);

        call.enqueue(new Callback<MoviesRespond>() {
            @Override
            public void onResponse(Call<MoviesRespond> call, Response<MoviesRespond> response) {
                MoviesRespond moviesRespond = response.body();
                if (moviesRespond != null && moviesRespond.getResults() != null) {

                    moviesItems = (ArrayList<MoviesItem>) moviesRespond.getResults();
                    mutableLiveData.setValue(moviesItems);
                }
            }

            @Override
            public void onFailure(Call<MoviesRespond> call, Throwable t) {
                Toast.makeText(application, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}

