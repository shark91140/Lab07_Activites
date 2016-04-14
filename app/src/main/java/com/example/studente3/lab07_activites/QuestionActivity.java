package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public abstract class QuestionActivity extends AppCompatActivity {

    private TextView m_tv_message;
    private TextView m_tv_name;
    private RadioButton m_radio_a;
    private RadioButton m_radio_b;
    private RadioButton m_radio_c;
    private Button m_btn_back;
    private Button m_btn_next;
    private static int sQuestionIndex = 0;
    private static QuestionAdapter sAdapter;

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initQuestions();
        initBackNextButton();
    }

    @SuppressWarnings("ResourceType")
    private void initBackNextButton() {
        m_btn_back = (Button)findViewById(R.id.btn_back);
        m_btn_next = (Button)findViewById(R.id.btn_next);
        m_btn_back.setVisibility(getBackButtonVisibility());
        m_btn_next.setVisibility(getNextButtonVisibility());
    }

    private void initQuestions() {
        m_tv_message = (TextView)findViewById(R.id.tv_question);
        m_tv_name = (TextView)findViewById(R.id.tv_name);
        m_radio_a = (RadioButton)findViewById(R.id.radio_a);
        m_radio_b = (RadioButton)findViewById(R.id.radio_b);
        m_radio_c = (RadioButton)findViewById(R.id.radio_c);


        String no = String.valueOf(sQuestionIndex+1);
        if (sAdapter == null){
            sAdapter = QuestionAdapterFactory.getQuestionAdapter();
        }
        m_radio_a.setText(sAdapter.getQuestionOptionA(sQuestionIndex));
        m_radio_b.setText(sAdapter.getQuestionOptionB(sQuestionIndex));
        m_radio_c.setText(sAdapter.getQuestionOptionC(sQuestionIndex));
        m_tv_name.setText(no);
        m_tv_message.setText(sAdapter.getQuestion(sQuestionIndex));
    }

    public void Back(View view) {
        sQuestionIndex--;
        Intent intent = new Intent(this, getBackActivityClass());
        startActivity(intent);
    }


    public void Next(View view) {
        sQuestionIndex++;
        Intent intent = new Intent(this, getNextActivityClass());
        startActivity(intent);
    }
    public void  setBackButtonText(CharSequence text){
        m_btn_back.setText(text);
    }
    public void setNextButtonText(CharSequence text){
        m_btn_next.setText(text);
    }

    protected abstract Class getNextActivityClass();
    protected abstract Class getBackActivityClass();
    protected abstract @Visibility int getBackButtonVisibility();
    protected abstract @Visibility int getNextButtonVisibility();
    public final static int VISIBLE = View.VISIBLE;
    public static final int GONE = View.GONE;
    public static final int INVISIBLE = View.INVISIBLE;
    @IntDef({VISIBLE,GONE,INVISIBLE})
    public @interface Visibility{

    }
}
