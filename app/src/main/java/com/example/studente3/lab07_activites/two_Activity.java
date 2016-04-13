package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class two_Activity extends AppCompatActivity {
    private TextView m_tv_message;
    private TextView m_tv_name;
    private RadioButton m_radio_a;
    private RadioButton m_radio_b;
    private RadioButton m_radio_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_);
        init();
    }
    private void init(){
        m_tv_message = (TextView)findViewById(R.id.tv_question);
        m_tv_name = (TextView)findViewById(R.id.tv_name);
        m_radio_a = (RadioButton)findViewById(R.id.radio_a);
        m_radio_b = (RadioButton)findViewById(R.id.radio_b);
        m_radio_c = (RadioButton)findViewById(R.id.radio_c);
        m_radio_a.setText(getString(R.string.answer2_1));
        m_radio_b.setText(getString(R.string.answer2_2));
        m_radio_c.setText(getString(R.string.answer2_3));
        m_tv_name.setText(getString(R.string.name_2));
        m_tv_message.setText(getString(R.string.question_2));

    }

    public void twoBack(View view) {
       finish();
    }

    public void twoNext(View view) {
        Intent intent = new Intent(this,three_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }
}
