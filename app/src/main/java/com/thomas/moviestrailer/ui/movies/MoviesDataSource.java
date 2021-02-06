package com.thomas.moviestrailer.ui.movies;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.WebService;
import com.thomas.moviestrailer.API.model.MoviesItem;
import com.thomas.moviestrailer.API.model.MoviesRespond;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesDataSource extends PageKeyedDataSource<Long, MoviesItem> {
    private WebService webService;
    private Application application;

    public MoviesDataSource(WebService webService, Application application) {
        this.webService = webService;
        this.application = application;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, MoviesItem> callback) {

        webService = APIManager.getApi();
        Call<MoviesRespond> call = webService.getAllMovie(APIManager.API_KEY, 1);

        call.enqueue(new Callback<MoviesRespond>() {
            @Override
            public void onResponse(Call<MoviesRespond> call, Response<MoviesRespond> response) {

                MoviesRespond moviesRespond = response.body();
                ArrayList<MoviesItem> items = new ArrayList<>();

                if (moviesRespond != null && moviesRespond.getResults() != null) {
                    items = (ArrayList<MoviesItem>) moviesRespond.getResults();
                    callback.onResult(items, null, (long) 2);
                }
            }

            @Override
            public void onFailure(Call<MoviesRespond> call, Throwable t) {
                Toast.makeText(application, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, MoviesItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull final LoadCallback<Long, MoviesItem> callback) {

        webService = APIManager.getApi();
        Call<MoviesRespond> call = webService.getAllMovie(APIManager.API_KEY, params.key);

        call.enqueue(new Callback<MoviesRespond>() {
            @Override
            public void onResponse(Call<MoviesRespond> call, Response<MoviesRespond> response) {
                MoviesRespond moviesRespond = response.body();
                ArrayList<MoviesItem> items = new ArrayList<>();

                if (moviesRespond != null && moviesRespond.getResults() != null) {
                    items = (ArrayList<MoviesItem>) moviesRespond.getResults();
                    callback.onResult(items, params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<MoviesRespond> call, Throwable t) {
                Toast.makeText(application, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
