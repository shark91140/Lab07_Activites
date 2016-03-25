package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class one_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_);
    }

    public void oneNext(View view) {
        Intent intent = new Intent(this,two_Activity.class);
        startActivity(intent);


    }
}
