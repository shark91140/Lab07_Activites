package com.example.studente3.lab07_activites.Adapter;

import com.example.studente3.lab07_activites.model.Question;

import java.util.List;

/**
 * Created by student on 2016/4/20.
 */
public class QuestionFromGoogleDriveXml implements QuestionAdapter {
    private List<Question> list;

    public QuestionFromGoogleDriveXml(List<Question> list) {
        this.list = list;
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getQuestion(int index) {
        return list.get(index).getDescription();
    }

    @Override
    public CharSequence getQuestionOptionA(int index) {
        return list.get(index).getOptionA();
    }

    @Override
    public CharSequence getQuestionOptionB(int index) {
        return list.get(index).getOptionB();
    }

    @Override
    public CharSequence getQuestionOptionC(int index) {
        return list.get(index).getOptionC();
    }
}
