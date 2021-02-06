package com.thomas.moviestrailer.ui.series;

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

import com.thomas.moviestrailer.API.model.SeriesItem;
import com.thomas.moviestrailer.R;
import com.thomas.moviestrailer.databinding.FragmentSeriesBinding;
import com.thomas.moviestrailer.ui.series.adapter.SeriesAdapter;
import com.thomas.moviestrailer.ui.seriesDetail.SeriesDetailActivity;

import java.util.List;

public class SeriesFragment extends Fragment {

    private SeriesViewModel seriesViewModel;
    SeriesAdapter moviesAdapter;
    public static int seriesId;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentSeriesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_series, container, false);


        seriesViewModel = new ViewModelProvider(this).get(SeriesViewModel.class);
        View root = binding.getRoot();

        seriesViewModel.getSeries();

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.recyclerView.setHasFixedSize(true);

        seriesViewModel.mutableLiveData.observe(getViewLifecycleOwner(), series -> {
            List<SeriesItem> list = series.getResults();
            moviesAdapter = new SeriesAdapter(getContext(), list);
            binding.recyclerView.setAdapter(moviesAdapter);

            moviesAdapter.setOnItemClickListener(moviesItem -> {
                seriesId = moviesItem.getId();
                Intent intent = new Intent(getContext(), SeriesDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("seriesId", seriesId);
                intent.putExtras(bundle);
                startActivity(intent);

            });
        });

        return root;
    }
}