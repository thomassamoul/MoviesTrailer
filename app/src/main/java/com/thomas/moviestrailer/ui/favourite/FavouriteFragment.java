package com.thomas.moviestrailer.ui.favourite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.thomas.moviestrailer.R;
import com.thomas.moviestrailer.databinding.FragmentFavouriteBinding;
import com.thomas.moviestrailer.ui.favourite.adapter.FavouriteAdapter;
import com.thomas.moviestrailer.ui.movieDetail.MovieDetailActivity;
import com.thomas.moviestrailer.ui.movies.MoviesFragment;

public class FavouriteFragment extends Fragment {
    FavouriteViewModel viewModel;
    FavouriteAdapter adapter;
    FragmentFavouriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false);


        viewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);


        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.recyclerView.setHasFixedSize(true);

        getFavourites();

        return binding.getRoot();
    }

    private void getFavourites() {
        viewModel.getMovies().observe(getViewLifecycleOwner(), favouriteMovies -> {
            adapter = new FavouriteAdapter(favouriteMovies, getContext());
            adapter.changeData(favouriteMovies);
            binding.recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(favouriteMovies1 -> {
                MoviesFragment.movieId = favouriteMovies1.getId();

                startActivity(new Intent(getContext(), MovieDetailActivity.class));
            });
        });

    }

}