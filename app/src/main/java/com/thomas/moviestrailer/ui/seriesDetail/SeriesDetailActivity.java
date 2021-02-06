package com.thomas.moviestrailer.ui.seriesDetail;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.thomas.moviestrailer.API.model.SeriesDetails;
import com.thomas.moviestrailer.R;
import com.thomas.moviestrailer.database.model.FavouriteSeries;
import com.thomas.moviestrailer.databinding.ActivitySeriesDetailBinding;
import com.thomas.moviestrailer.ui.movies.MoviesFragment;
import com.thomas.moviestrailer.utils.SharedPreferencesUtils;

import static com.thomas.moviestrailer.constant.Constant.IMAGE_URL;

public class SeriesDetailActivity extends AppCompatActivity {

    SeriesDetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySeriesDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_series_detail);

        viewModel = new ViewModelProvider(this).get(SeriesDetailViewModel.class);
        viewModel.getDetails();

        viewModel.seriesDetailsMutableLiveData.observe(this, seriesDetails -> {
            binding.detailSeriesTitle.setText(seriesDetails.getOriginalName());
            binding.detailSeriesStatus.setText(seriesDetails.getStatus());
            binding.detailSeriesDesc.setText(seriesDetails.getOverview());
            Glide.with(getApplicationContext()).load(IMAGE_URL + seriesDetails.getPosterPath()).into(binding.detailSeriesCover);
            Glide.with(getApplicationContext()).load(IMAGE_URL + seriesDetails.getPosterPath()).into(binding.detailSeriesImg);


            binding.favBtn.setOnClickListener(v -> {
                if (!SharedPreferencesUtils.getInsertState(getApplicationContext(), String.valueOf(MoviesFragment.movieId))) {
                    binding.favBtn.setImageResource(R.drawable.ic_favorite_white_24dp);
                    addFavourite(seriesDetails);
                    SharedPreferencesUtils.setInsertState(getApplicationContext(), String.valueOf(MoviesFragment.movieId), true);

                } else {
                    binding.favBtn.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    deleteFavourite(seriesDetails);
                    SharedPreferencesUtils.setInsertState(getApplicationContext(), String.valueOf(MoviesFragment.movieId), false);
                }
            });
        });

    }

    private void deleteFavourite(SeriesDetails seriesDetails) {
//        MoviesDatabase.getInstance(getApplicationContext()).moviesDAO().deleteSeriesById(seriesDetails.getId());

    }

    private void addFavourite(SeriesDetails seriesDetails) {
        FavouriteSeries favouriteSeries = new FavouriteSeries(seriesDetails.getId(),
                seriesDetails.getOriginalName(),
                seriesDetails.getPosterPath(),
                seriesDetails.getOverview(),
                seriesDetails.getStatus());
        favouriteSeries.setId(seriesDetails.getId());

//        MoviesDatabase.getInstance(getApplicationContext()).moviesDAO().insertSeries(favouriteSeries);

    }
}
