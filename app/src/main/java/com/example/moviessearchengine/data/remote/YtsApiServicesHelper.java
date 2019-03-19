package com.example.moviessearchengine.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.moviessearchengine.MyApp;
import com.example.moviessearchengine.data.Repository;
import com.example.moviessearchengine.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class YtsApiServicesHelper {

    private static OkHttpClient getClient(Context context) {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        if (MyApp.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpBuilder.interceptors().add(interceptor);
        }
        okHttpBuilder.connectTimeout(10, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(10, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(10, TimeUnit.SECONDS);
        okHttpBuilder.retryOnConnectionFailure(true);

        return okHttpBuilder.build();
    }

    public static YtsApiServices getYtsApiServices(Context context) {

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String baseUrl = Constants.BASE_API ;


        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .client(getClient(context))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(YtsApiServices.class);
    }
}

