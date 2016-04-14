package com.example.studente3.lab07_activites;

public class one_Activity extends QuestionActivity {


    @Override
    protected Class getNextActivityClass() {
        return two_Activity.class;
    }

    @Override
    protected Class getBackActivityClass() {
        return null;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.GONE;
    }

    @Override
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }


}
