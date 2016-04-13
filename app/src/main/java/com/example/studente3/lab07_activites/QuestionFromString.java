package com.example.studente3.lab07_activites;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/4/12.
 */
public class QuestionFromString implements QuestionAdapter {
   private List<Question> list = new ArrayList<>();

    public QuestionFromString(Resources res) {
        list.add(new Question(res.getString(R.string.question_1)
                ,res.getString(R.string.answer1_1)
                ,res.getString(R.string.answer1_2)
                ,res.getString(R.string.answer1_3)));
        list.add(new Question(res.getString(R.string.question_2)
                ,res.getString(R.string.answer2_1)
                ,res.getString(R.string.answer2_2)
                ,res.getString(R.string.answer2_3)));
        list.add(new Question(res.getString(R.string.question_3)
                ,res.getString(R.string.answer3_1)
                ,res.getString(R.string.answer3_2)
                ,res.getString(R.string.answer3_3)));
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getQuestion(int index) {
        Question question = list.get(index);
        String text = question.getQuestion();
        return text;
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
