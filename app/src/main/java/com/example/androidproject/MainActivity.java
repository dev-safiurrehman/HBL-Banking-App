package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mName;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.name);
        // initialize the shared preference
        ref = getSharedPreferences("myapp",MODE_PRIVATE);
        // set the name to edit text after getting it from preferences
        mName.setText(ref.getString("name",""));

    }
}