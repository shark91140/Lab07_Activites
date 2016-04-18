package com.example.studente3.lab07_activites.Adapter;

import android.content.res.Resources;
import android.util.Log;

import com.example.studente3.lab07_activites.MyApp.MyApp;

/**
 * Created by student on 2016/4/12.
 */
public class QuestionAdapterFactory {
    private static QuestionAdapter adapter;

    public static QuestionAdapter getQuestionAdapter() {
        if (adapter == null) {
            Resources res = MyApp.getContext().getResources();
            //adapter = new QuestionFromString(res);
            try {
                adapter = new QuestionFromXml(res);
            }catch (Exception e){
                Log.d("factory",e.toString());
            }

        }
        return adapter;
    }

    private QuestionAdapterFactory() {

    }
}
