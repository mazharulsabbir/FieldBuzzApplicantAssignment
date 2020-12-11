package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static final String TAG = "RetrofitBuilder";
    private static final String BASE_URL = "https://recruitment.fisdev.com/";

    public RetrofitBuilder() {
    }

    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public FieldBuzzApiService getFieldBuzzApiService() {
        return getRetrofit()
                .create(FieldBuzzApiService.class);
    }

    private Retrofit getRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public FieldBuzzApiService getFieldBuzzApiService(OkHttpClient client) {
        return getRetrofit(client)
                .create(FieldBuzzApiService.class);
    }
}
