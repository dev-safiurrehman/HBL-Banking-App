package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    EditText mEmail,mPassword;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);

        // initialize the shared preference in private mode
        ref = getSharedPreferences("myapp",MODE_PRIVATE);

    }
    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Login(View view) {

        String sEmail = ref.getString("email","");
        String sPassword = ref.getString("password","");

        if(sEmail.equals(mEmail.getText().toString()) && sPassword.equals(mPassword.getText().toString())){
            ref.edit().putBoolean("login",true).apply();
            Intent i = new Intent( Loginpage.this,MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(this,"Invalid User", Toast.LENGTH_SHORT).show();
        }

    }

    public void goToSignup(View view) {
        Intent i = new Intent( Loginpage.this,Signup.class);
        startActivity(i);
    }
}