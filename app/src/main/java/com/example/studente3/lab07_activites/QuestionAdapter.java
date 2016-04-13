package com.example.studente3.lab07_activites;

/**
 * Created by student on 2016/4/12.
 */
public interface QuestionAdapter {
    int getQuestionCount();
    CharSequence getQuestion(int index);
    CharSequence getQuestionOptionA(int index);
    CharSequence getQuestionOptionB(int index);
    CharSequence getQuestionOptionC(int index);
}
