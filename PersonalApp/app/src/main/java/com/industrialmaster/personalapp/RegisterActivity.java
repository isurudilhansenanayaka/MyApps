package com.industrialmaster.personalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void exit(View v){
        finish();
        System.exit(0);
    }

    public void save(View v){
        EditText etName = findViewById(R.id.name);
        EditText etEmail = findViewById(R.id.email);
        EditText etPhone = findViewById(R.id.phone);

        SharedPreferences profile =
                getSharedPreferences("profile", MODE_PRIVATE);
        SharedPreferences.Editor editor = profile.edit();
        editor.putString("NAME", etName.getText().toString());
        editor.putString("EMAIL", etEmail.getText().toString());
        editor.putString("PHONE", etPhone.getText().toString());

        editor.commit();

        Toast.makeText(this, "Success !", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }

}
