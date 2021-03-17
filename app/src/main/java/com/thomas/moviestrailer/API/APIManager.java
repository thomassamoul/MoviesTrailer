package com.thomas.moviestrailer.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "5f1c5fe15918a64f67994d21a8b902a9";

    private static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static WebService getApi() {
        return getInstance().create(WebService.class);
    }

}
