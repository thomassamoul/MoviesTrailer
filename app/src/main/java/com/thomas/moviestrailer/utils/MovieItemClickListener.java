package com.thomas.moviestrailer.utils;

import android.widget.ImageView;

import com.thomas.moviestrailer.API.model.MoviesItem;

public interface MovieItemClickListener {
    void onMovieClick(MoviesItem moviesItem, ImageView imageView);
}
