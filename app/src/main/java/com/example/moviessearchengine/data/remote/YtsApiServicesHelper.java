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
        // adding interceptor
        /*okHttpBuilder.interceptors().add(chain -> {
            Request.Builder ongoing = chain.request().newBuilder();

            ongoing.addHeader("Accept", "application/json; charset=utf-8");

            Log.d("HeadersToken", Repository.getInstance(context).getUserAccessToken());

            ongoing.addHeader("Authorization", "Bearer " + Repository.getInstance(context).getUserAccessToken());

            return chain.proceed(ongoing.build());
        });*/

        // adding interceptor
        /*okHttpBuilder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();
                Response response = doRequest(chain, request);
                int tryCount = 0;
                int RetryCount = 2;
                while (response == null && tryCount <= RetryCount) {
                    String url = request.url().toString();
                    Request newRequest = request.newBuilder().url(url).build();
                    tryCount++;
                    response = doRequest(chain, newRequest);
                }
                if (response == null) {//important ,should throw an exception here
                    throw new IOException();
                } else if (response.code() == 401) {
                    throw new IOException("UnAuthenticated");
//
                }
                return response;
            }

            private Response doRequest(Interceptor.Chain chain, Request request) {
                Response response = null;
                try {
                    response = chain.proceed(request);
                } catch (Exception e) {
                    Log.e("doRequest OkHttp3", e.getMessage() != null ? e.getMessage() : "Something Went Wrong!!");
                }
                return response;
            }
        });*/
        return okHttpBuilder.build();
    }

    public static YtsApiServices getYtsApiServices(Context context) {

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String baseUrl = Constants.BASE_API ;

        // we have 2 services in english and arabic
        /*Log.d("BASE_API", Repository.getInstanceWithoutAPIService(context).getAppLanguage());
        if (Repository.getInstanceWithoutAPIService(context).getAppLanguage().equals("en")) {
            baseUrl = Constants.BASE_API + "en/";
            Log.d("BASE_API", baseUrl);
        } else {
            baseUrl = Constants.BASE_API + "ar/";
            Log.d("BASE_API", baseUrl);
        }*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .client(getClient(context))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(YtsApiServices.class);
    }
}
/*
*  another way to make Retrofit client

    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }


    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }


    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }


    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
*
*
* */
