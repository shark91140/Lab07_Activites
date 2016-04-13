package com.example.studente3.lab07_activites;

import android.content.res.Resources;

/**
 * Created by student on 2016/4/12.
 */
public class QuestionAdapterFactory {
    private static QuestionAdapter adapter;

    public static QuestionAdapter getQuestionAdapter() {
        if (adapter == null) {
            Resources res = MyApp.getContext().getResources();
            adapter = new QuestionFromString(res);
        }
        return adapter;
    }

    private QuestionAdapterFactory() {

    }
}
