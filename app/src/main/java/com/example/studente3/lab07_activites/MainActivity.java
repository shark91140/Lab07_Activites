package com.example.studente3.lab07_activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SELECT_COLOR_REQUEST = 0;
    private static final int text_Click = 1;
    private static final int text_Input = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectColor(View view) {
        Intent intent = new Intent(this, ColorPickerActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, SELECT_COLOR_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SELECT_COLOR_REQUEST) {

                Bundle bundle = data.getExtras();
                int colorInt = bundle.getInt(ColorPickerActivity.BUNDLE_KEY_COLOR_INT);
                CharSequence colorName = bundle.getCharSequence(ColorPickerActivity.BUNDLE_KEY_COLOR_NAME);
                TextView tv_color = (TextView) findViewById(R.id.tv_color);
                tv_color.setText(colorName);
                tv_color.setBackgroundColor(colorInt);
        } else if (requestCode == text_Input) {
            Bundle bundle = data.getExtras();
            CharSequence edit_text = bundle.getCharSequence(edit_Text_Activity.BUNDLE_KEY_TEXT);
            TextView tv_color = (TextView) findViewById(R.id.tv_color);
            tv_color.setText(edit_text);
        } else if (requestCode == text_Click) {

        }


    }

    public void textClick(View view) {
        Intent intent = new Intent(this, one_Activity.class);
        startActivityForResult(intent, text_Click);
    }

    public void putText(View view) {
        Intent intent = new Intent(this, edit_Text_Activity.class);
        startActivityForResult(intent, text_Input);
    }
}
