package com.thomas.moviestrailer.ui.movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import com.thomas.moviestrailer.API.model.MoviesItem;
import com.thomas.moviestrailer.R;
import com.thomas.moviestrailer.databinding.FragmentMoviesBinding;
import com.thomas.moviestrailer.ui.movieDetail.MovieDetailActivity;
import com.thomas.moviestrailer.ui.movies.adapter.MoviesAdapter;

import java.util.List;

public class MoviesFragment extends Fragment {

    MoviesAdapter moviesAdapter;
    public static int movieId;
    List<MoviesItem> list;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMoviesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false);

        MoviesViewModel moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        View root = binding.getRoot();

        moviesViewModel.getMovies();
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.recyclerView.setHasFixedSize(true);

        moviesViewModel.mutableLiveData.observe(getViewLifecycleOwner(), moviesItems -> {
            list = moviesItems.getResults();
            Log.e("MOVIES*******", list.toString());
            Log.e("RESPOND******", moviesItems.toString());
            moviesAdapter = new MoviesAdapter(getContext(), list);
            binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
            binding.recyclerView.setAdapter(moviesAdapter);
            moviesAdapter.notifyDataSetChanged();

            moviesAdapter.setOnItemClickListener(moviesItem -> {
                movieId = moviesItem.getId();
                Intent intent = new Intent(getContext(), MovieDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("movieId", movieId);
                intent.putExtras(bundle);
                startActivity(intent);
            });
        });
        return root;
    }
}