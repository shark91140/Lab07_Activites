package com.example.studente3.lab07_activites;

import android.view.View;

public class two_Activity extends QuestionActivity {

    @Override
    protected Class getNextActivityClass() {
        return three_Activity.class;
    }

    @Override
    protected Class getBackActivityClass() {
        return one_Activity.class;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }

    @Override
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }
}
