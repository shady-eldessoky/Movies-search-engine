package com.example.moviessearchengine;

import android.app.Application;

import com.example.moviessearchengine.data.remote.APIService;

public class MyApp extends Application {

    public static final boolean DEBUG = true;
    private static APIService apiService;

    @Override
    public void onCreate() {
        super.onCreate();

        apiService = APIService.getInstance(this);
    }

    /**
     * @return the instance of APIService and live all app lifetime
     */
    public static APIService getApiService(){
        return apiService;
    }
}
