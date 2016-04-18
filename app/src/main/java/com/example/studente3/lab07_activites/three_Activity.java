package com.example.studente3.lab07_activites;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import com.example.studente3.lab07_activites.Adapter.QuestionAdapter;
import com.example.studente3.lab07_activites.Adapter.QuestionAdapterFactory;
import com.example.studente3.lab07_activites.MyApp.MyApp;
import com.example.studente3.lab07_activites.model.UserAnswer;

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
    public void Next(View view) {
        QuestionAdapter questionAdapter = QuestionAdapterFactory.getQuestionAdapter();
        UserAnswer userAnswer = MyApp.getUserAnswers();
        StringBuilder message = new StringBuilder();
        message.append("你的作答如下\n\n");
        for (int i = 0; i < questionAdapter.getQuestionCount(); i++) {
            message.append(String.valueOf(i + 1))
                    .append(": ")
                    .append(userAnswer.getAnswer(i))
                    .append("\n")
                    .append(userAnswer.getDescription(i))
                    .append("\n")
                    .append("\n\n");
        }
        message.append("\n確定要結束?");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(three_Activity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        QuestionActivity.resetQuestions();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

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
