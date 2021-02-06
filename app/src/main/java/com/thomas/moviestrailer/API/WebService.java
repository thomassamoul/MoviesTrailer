package com.thomas.moviestrailer.API;

import com.thomas.moviestrailer.API.model.CastAndCrew;
import com.thomas.moviestrailer.API.model.MovieDetail;
import com.thomas.moviestrailer.API.model.MoviesRespond;
import com.thomas.moviestrailer.API.model.Series;
import com.thomas.moviestrailer.API.model.SeriesDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {

    @GET("movie/{movie_id}")
    Call<MovieDetail> getMovieDetail(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/credits")
    Call<CastAndCrew> getMovieCast(@Path("movie_id") int MovieId, @Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MoviesRespond> getAllMovie(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MoviesRespond> getAllMovie(@Query("api_key") String apiKey, @Query("page") long page);

    @GET("tv/popular")
    Call<Series> getSeries(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("tv/{tv_id}")
    Call<SeriesDetails> getSeriesDetails(@Path("tv_id") int movieId, @Query("api_key") String apiKey);
}
