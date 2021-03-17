package com.thomas.moviestrailer.ui.movieDetail;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thomas.moviestrailer.API.model.CastItem;
import com.thomas.moviestrailer.API.model.CrewItem;
import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.R;
import com.thomas.moviestrailer.database.LocalMoviesDataSource;
import com.thomas.moviestrailer.database.MoviesDataSource;
import com.thomas.moviestrailer.database.MoviesDatabase;
import com.thomas.moviestrailer.databinding.ActivityDetailBinding;
import com.thomas.moviestrailer.ui.movieDetail.adapter.MovieCastAdapter;
import com.thomas.moviestrailer.ui.movieDetail.adapter.MovieCrewAdapter;
import com.thomas.moviestrailer.ui.movies.MoviesFragment;
import com.thomas.moviestrailer.utils.SharedPreferencesUtils;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static com.thomas.moviestrailer.constant.Constant.IMAGE_URL;

public class MovieDetailActivity extends AppCompatActivity {

    MovieDetailViewModel movieDetailViewModel;
    MovieCastAdapter movieCastAdapter;
    MovieCrewAdapter movieCrewAdapter;
    Dialog progressDialog;
    MoviesDataSource dataSource;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        mDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        movieDetailViewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);
        movieDetailViewModel.getDetail();
        movieDetailViewModel.getCast();

        dataSource = new LocalMoviesDataSource(MoviesDatabase.getInstance(getApplicationContext()).moviesDAO());

        progressDialog = createProgressDialog(this);

        progressDialog.show();

        if (SharedPreferencesUtils.getInsertState(this, String.valueOf(MoviesFragment.movieId))) {
            binding.favBtn.setImageResource(R.drawable.ic_favorite_white_24dp);
        }

        movieDetailViewModel.movieDetailData.observe(this, movieDetail -> {
            if (movieDetail != null && !movieDetail.getTitle().isEmpty()) {
                progressDialog.dismiss();
            }
            binding.detailMovieTitle.setText(movieDetail.getTitle());
            binding.detailMovieDesc.setText(movieDetail.getOverview());
            binding.detailMovieLanguage.setText(movieDetail.getLanguage());
            binding.detailMovieStatus.setText(movieDetail.getStatus());
            Glide.with(getApplicationContext()).load(IMAGE_URL + movieDetail.getBackdrop()).into(binding.detailMovieCover);
            Glide.with(getApplicationContext()).load(IMAGE_URL + movieDetail.getPosterPath()).into(binding.detailMovieImg);

            binding.favBtn.setOnClickListener(v -> {
                if (!SharedPreferencesUtils.getInsertState(getApplicationContext(), String.valueOf(MoviesFragment.movieId))) {
                    binding.favBtn.setImageResource(R.drawable.ic_favorite_white_24dp);
                    addFavourite(movieDetail);
                    SharedPreferencesUtils.setInsertState(getApplicationContext(), String.valueOf(MoviesFragment.movieId), true);

                } else {
                    binding.favBtn.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    deleteFavourite(movieDetail);
                    SharedPreferencesUtils.setInsertState(getApplicationContext(), String.valueOf(MoviesFragment.movieId), false);

                }


            });
        });

        movieDetailViewModel.castData.observe(this, movieCast -> {
            List<CastItem> castList = movieCast.getCast();
            List<CrewItem> crewItems = movieCast.getCrew();
            movieCastAdapter = new MovieCastAdapter(getApplicationContext(), castList);
            movieCrewAdapter = new MovieCrewAdapter(getApplicationContext(), crewItems);

            binding.castRecyclerview.setAdapter(movieCastAdapter);
            binding.crewRecyclerview.setAdapter(movieCrewAdapter);
            binding.castRecyclerview
                    .setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
            binding.crewRecyclerview
                    .setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));

            movieCastAdapter.setOnItemClickListener(castItem -> {
                String s = "https://www.themoviedb.org/person/" + castItem.getId();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(s);
                intent.setData(uri);
                startActivity(intent);
            });

            movieCrewAdapter.setOnItemClickListener(crewItem -> {
                String s = "https://www.themoviedb.org/person/" + crewItem.getId();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(s);
                intent.setData(uri);
                startActivity(intent);
            });
        });

    }

    private void deleteFavourite(MovieDetail movieDetail) {
        mDisposable.add(dataSource.deleteMovie(movieDetail).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    private void addFavourite(MovieDetail movieDetail) {
        mDisposable.add(dataSource.insertMovie(movieDetail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    public static Dialog createProgressDialog(Context context) {
        Dialog progressDialog = new Dialog(context);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setCancelable(false);
        progressDialog.setContentView(R.layout.dialog_layout);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.show();
        return progressDialog;
    }

}