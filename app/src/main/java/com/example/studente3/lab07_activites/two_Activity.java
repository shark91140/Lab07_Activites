package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class two_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_);
    }

    public void twoBack(View view) {
       finish();
    }

    public void twoNext(View view) {
        Intent intent = new Intent(this,three_Activity.class);
        startActivity(intent);
    }
}
