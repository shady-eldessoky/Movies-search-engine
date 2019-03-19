package com.example.moviessearchengine.data.remote;

import android.content.Context;

public class APIService {

    private static volatile APIService INSTANCE;
    // reference of YtsApiServices interface which have api services
    private YtsApiServices ytsApiServices;

    /**
     * @param context
     * @return only one instance of APIService
     */
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
        // YtsApiServices declaration using YtsApiServicesHelper method
        ytsApiServices = YtsApiServicesHelper.getYtsApiServices(context);
    }

    /**
     * @return instance of YtsApiServices interface
     */
    public YtsApiServices getYtsApiServices() {
        return ytsApiServices;
    }
}
