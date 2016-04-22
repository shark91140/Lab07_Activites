package com.example.studente3.lab07_activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IntDef;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.studente3.lab07_activites.Adapter.QuestionAdapter;
import com.example.studente3.lab07_activites.Adapter.QuestionAdapterFactory;
import com.example.studente3.lab07_activites.MyApp.MyApp;
import com.example.studente3.lab07_activites.model.UserAnswer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class QuestionActivity extends AppCompatActivity
        implements QuestionAdapterFactory.Receiver {

    private TextView m_tv_message;
    private TextView m_tv_name;
    private RadioButton m_radio_a;
    private RadioButton m_radio_b;
    private RadioButton m_radio_c;
    private Button m_btn_back;
    private Button m_btn_next;
    private static int sQuestionIndex = 0;
    private static int sLastQuestionIndex;
    private static QuestionAdapter sAdapter;
    private ContentLoadingProgressBar m_pgb_loading;
    public static final String FILENAME = "QuestionActivity_UserAnswer";
    private static final String TAG = "QuestionActivity";
    private UserAnswer sUserAnswer;

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void saveData() {
        Log.d(TAG, "saveData() Serialize");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeInt(sQuestionIndex);
            oos.writeInt(sLastQuestionIndex);
            oos.writeObject(sUserAnswer);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.toString());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
    }

    private void restoreData() {
        Log.d(TAG, "restoreData() Serialize");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = openFileInput(FILENAME);
            ois = new ObjectInputStream(fis);
            sQuestionIndex = ois.readInt();
            sLastQuestionIndex = ois.readInt();
            sUserAnswer = (UserAnswer) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }finally {
            if(ois != null){
                try{
                    ois.close();
                }catch (IOException e){
                    Log.e(TAG,e.toString());
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initContentLoadingProgressBar();
        initQuestions();
        initBackNextButton();
    }

    private void initContentLoadingProgressBar() {
        m_pgb_loading = (ContentLoadingProgressBar) findViewById(R.id.pgb_loading);
    }

    @SuppressWarnings("ResourceType")
    private void initBackNextButton() {
        m_btn_back = (Button) findViewById(R.id.btn_back);
        m_btn_next = (Button) findViewById(R.id.btn_next);
        m_btn_back.setVisibility(getBackButtonVisibility());
        m_btn_next.setVisibility(getNextButtonVisibility());
    }

    private void initQuestions() {
        m_tv_message = (TextView) findViewById(R.id.tv_question);
        m_tv_name = (TextView) findViewById(R.id.tv_name);
        m_radio_a = (RadioButton) findViewById(R.id.radio_a);
        m_radio_b = (RadioButton) findViewById(R.id.radio_b);
        m_radio_c = (RadioButton) findViewById(R.id.radio_c);


        String no = String.valueOf(sQuestionIndex + 1);
        m_tv_name.setText(no);
        if (sAdapter == null) {
            QuestionAdapterFactory.getQuestionAdapter(this);
        }
        updateQuestionText();
    }

    public void receiveQuestionAdapter(QuestionAdapter adapter) {
        Log.d("adapter", "ok");
        MyApp.setAdapter(adapter);
        sAdapter = adapter;
        if(sUserAnswer == null){
            sUserAnswer = new UserAnswer(sAdapter.getQuestionCount());
        }
      //  findViewById(R.id.pgb_loading).setVisibility(View.GONE);
        updateQuestionText();

    }

    private void updateQuestionText() {
        if (sAdapter == null) {
            return;
        }
        m_pgb_loading.setVisibility(View.GONE);
        m_radio_a.setText(Html.fromHtml(sAdapter.getQuestionOptionA(sQuestionIndex).toString()));
        m_radio_b.setText(Html.fromHtml(sAdapter.getQuestionOptionB(sQuestionIndex).toString()));
        m_radio_c.setText(Html.fromHtml(sAdapter.getQuestionOptionC(sQuestionIndex).toString()));

        m_tv_message.setText(Html.fromHtml(sAdapter.getQuestion(sQuestionIndex).toString()));
    }

    public void Back(View view) {
        sLastQuestionIndex = sQuestionIndex;
        sQuestionIndex--;
        Intent intent = new Intent(this, getBackActivityClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }


    public void Next(View view) {
        sLastQuestionIndex = sQuestionIndex;
        sQuestionIndex++;
        Intent intent = new Intent(this, getNextActivityClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public static void resetQuestions() {
        sLastQuestionIndex = 0;
        sQuestionIndex = 0;
    }

    public void click(View view) {
        Log.d("click", "run");
        RadioButton radioButton = (RadioButton) view;
        //UserAnswer userAnswer = MyApp.getUserAnswers();
        UserAnswer userAnswer = sUserAnswer;
        switch (radioButton.getId()) {
            case R.id.radio_a:
                userAnswer.setAnswers(sQuestionIndex, 'A', radioButton.getText());

                break;
            case R.id.radio_b:
                userAnswer.setAnswers(sQuestionIndex, 'B', radioButton.getText());
                break;
            case R.id.radio_c:
                userAnswer.setAnswers(sQuestionIndex, 'C', radioButton.getText());
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(this.toString(), "onPause,index=" + sQuestionIndex);
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.toString(), "onPause,index=" + sQuestionIndex);
        restoreData();
        initQuestions();
        initBackNextButton();
        if (sQuestionIndex < sLastQuestionIndex) {
            overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
        } else if (sQuestionIndex > sLastQuestionIndex) {
            overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
        }
    }


    public void setBackButtonText(CharSequence text) {
        m_btn_back.setText(text);
    }

    public void setNextButtonText(CharSequence text) {
        m_btn_next.setText(text);
    }

    protected abstract Class getNextActivityClass();

    protected abstract Class getBackActivityClass();

    protected abstract
    @Visibility
    int getBackButtonVisibility();

    protected abstract
    @Visibility
    int getNextButtonVisibility();

    public final static int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;
    public static final int INVISIBLE = View.INVISIBLE;

    @IntDef({VISIBLE, GONE, INVISIBLE})
    public @interface Visibility {

    }
}
