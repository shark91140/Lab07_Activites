package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class edit_Text_Activity extends AppCompatActivity {
    public final static String BUNDLE_KEY_TEXT = "studentE3.example.com.edit_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__text_);
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void ok(View view) {
        EditText editText = (EditText)findViewById(R.id.edit_text);
        CharSequence text = editText.getText();
        Intent intent = new Intent();
        intent.putExtra(BUNDLE_KEY_TEXT,text);
        setResult(RESULT_OK,intent);
        finish();
    }
}
