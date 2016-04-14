package com.example.studente3.lab07_activites;

public class three_Activity extends QuestionActivity {

    @Override
    protected void onStart() {
        super.onStart();
        setNextButtonText("Finish");
    }

    @Override
    protected Class getNextActivityClass() {
        return null;
    }

    @Override
    protected Class getBackActivityClass() {
        return two_Activity.class;
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
