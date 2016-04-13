package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class one_Activity extends AppCompatActivity {

    private TextView m_tv_message;
    private TextView m_tv_name;
    private RadioButton m_radio_a;
    private RadioButton m_radio_b;
    private RadioButton m_radio_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_);

    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    private void init(){
        m_tv_message = (TextView)findViewById(R.id.tv_question);
        m_tv_name = (TextView)findViewById(R.id.tv_name);
        m_radio_a = (RadioButton)findViewById(R.id.radio_a);
        m_radio_b = (RadioButton)findViewById(R.id.radio_b);
        m_radio_c = (RadioButton)findViewById(R.id.radio_c);
        int index = 0;
        String no = String.valueOf(index+1);

        QuestionAdapter adapter = QuestionAdapterFactory.getQuestionAdapter();
        m_radio_a.setText(adapter.getQuestionOptionA(index));
        m_radio_b.setText(adapter.getQuestionOptionB(index));
        m_radio_c.setText(adapter.getQuestionOptionC(index));
        m_tv_name.setText(no);
        m_tv_message.setText(adapter.getQuestion(index));

    }


    public void oneNext(View view) {
        Intent intent = new Intent(this,two_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_in,R.anim.push_left_out);
    }

}
