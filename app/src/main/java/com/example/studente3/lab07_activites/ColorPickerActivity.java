package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class ColorPickerActivity extends AppCompatActivity {
    public static final String BUNDLE_KEY_COLOR_INT = "studentE3.example.com.colorInt";
    public static final String BUNDLE_KEY_COLOR_NAME = "studentE3.example.com.colorName";
    private int mColorInt;
    private CharSequence mColorName;
    private static final String TAG = "ColorPickerActivity";

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG,"SaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG,"RestoreInstanceState");
    }

    private void saveDate(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(BUNDLE_KEY_COLOR_INT,mColorInt);
        editor.putString(BUNDLE_KEY_COLOR_NAME, mColorName.toString());
        editor.commit();
        Log.d(TAG, "saveDate mColorInt:" + mColorInt + "mColorName" + mColorName);
    }
    private void restoreData(){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        mColorInt = prefs.getInt(BUNDLE_KEY_COLOR_INT,0);
        mColorName = prefs.getString(BUNDLE_KEY_COLOR_NAME, "holo_red_light");
        Log.d(TAG, "restoreData()  mColorInt:" + mColorInt + "mColorName:" + mColorName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
        restoreData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        saveDate();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        Log.d(TAG,"onCreat");
        initColorData();
    }

    private void initColorData() {
        RadioButton radio = (RadioButton) findViewById(R.id.radio_red);
        mColorInt = radio.getCurrentTextColor();
        mColorName = radio.getText();
        Log.d(TAG,"ClickColor()  mColorInt = "+ mColorInt+"mColorName"+mColorName);
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
