package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ColorPickerActivity extends AppCompatActivity {
    public static final String BUNDLE_KEY_COLOR_INT = "studentE3.example.com.colorInt";
    public static final String BUNDLE_KEY_COLOR_NAME = "studentE3.example.com.colorName";
    private int mColorInt;
    private CharSequence mColorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        initColorData();
    }

    private void initColorData() {
        RadioButton radio = (RadioButton) findViewById(R.id.radio_red);
        mColorInt = radio.getCurrentTextColor();
        mColorName = radio.getText();
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();

    }

    public void ok(View view) {
        Intent intent = new Intent();
        intent.putExtra(BUNDLE_KEY_COLOR_INT, mColorInt);
        intent.putExtra(BUNDLE_KEY_COLOR_NAME, mColorName);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void ClickColor(View view) {
        RadioButton radio = (RadioButton) view;
        mColorInt = radio.getCurrentTextColor();
        mColorName = radio.getText();
    }
}
