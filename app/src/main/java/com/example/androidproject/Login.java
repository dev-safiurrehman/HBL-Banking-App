package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mEmail,mPassword;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);

        // initialize the shared preference in private mode
        ref = getSharedPreferences("myapp",MODE_PRIVATE);

    }

    public void Login(View view) {

        String sEmail = ref.getString("loginEmail","");
        String sPassword = ref.getString("loginPassword","");

        if(sEmail.equals(mEmail.getText().toString()) && sPassword.equals(mPassword.getText().toString())){
            ref.edit().putBoolean("login",true).apply();
            Intent i = new Intent( Login.this,MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(this,"Invalid User", Toast.LENGTH_SHORT).show();
        }

    }

    public void goToSignup(View view) {
        Intent i = new Intent( Login.this,Signup.class);
        startActivity(i);
    }
}