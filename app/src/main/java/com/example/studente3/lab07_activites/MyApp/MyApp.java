package com.example.studente3.lab07_activites.MyApp;

import android.app.Application;
import android.content.Context;

import com.example.studente3.lab07_activites.model.UserAnswer;

/**
 * Created by student on 2016/4/12.
 */
public class MyApp extends Application{
    private static Context context;
    private static UserAnswer userAnswers;


    public static UserAnswer getUserAnswers(){
        if (userAnswers == null){
            userAnswers = new UserAnswer(3);
        }
        return userAnswers;
    }
    public static Context getContext() {
        return context;
    }

    public MyApp() {
        context = this;
    }
}
