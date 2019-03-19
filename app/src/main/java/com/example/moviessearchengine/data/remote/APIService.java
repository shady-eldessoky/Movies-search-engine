package com.example.moviessearchengine.data.remote;

import android.content.Context;

public class APIService {

    private static volatile APIService INSTANCE;
    private YtsApiServices ytsApiServices;

    public static APIService getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (APIService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new APIService(context);
                }
            }
        }
        return INSTANCE;
    }

    private APIService(Context context) {
        ytsApiServices = YtsApiServicesHelper.getYtsApiServices(context);
    }

    public YtsApiServices getYtsApiServices() {
        return ytsApiServices;
    }
}
