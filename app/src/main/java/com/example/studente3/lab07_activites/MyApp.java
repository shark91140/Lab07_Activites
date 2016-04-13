package com.example.studente3.lab07_activites;

import android.app.Application;
import android.content.Context;

/**
 * Created by student on 2016/4/12.
 */
public class MyApp extends Application{
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public MyApp() {
        context = this;
    }
}
