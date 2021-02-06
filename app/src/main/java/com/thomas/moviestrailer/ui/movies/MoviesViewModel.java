package com.thomas.moviestrailer.ui.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.thomas.moviestrailer.API.APIManager;
import com.thomas.moviestrailer.API.WebService;
import com.thomas.moviestrailer.API.model.MoviesItem;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MoviesViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    LiveData<MoviesDataSource> moviesDataSourceLiveData;

    private Executor executor;

    private LiveData<PagedList<MoviesItem>> moviesPagedList;

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);

        WebService webService = APIManager.getApi();

        MoviesDataSourceFactory factory = new MoviesDataSourceFactory(webService, application);
        moviesDataSourceLiveData = factory.getMutableLiveData();

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();


        executor = Executors.newFixedThreadPool(5);

        moviesPagedList = (new LivePagedListBuilder<Long, MoviesItem>(factory, config))
                .setFetchExecutor(executor)
                .build();
    }

    public LiveData<List<MoviesItem>> getAllMovies() {
        return movieRepository.getMutableLiveData();
    }

    public LiveData<PagedList<MoviesItem>> getMoviesPagedList() {
        return moviesPagedList;
    }
}

