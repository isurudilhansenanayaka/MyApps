package com.industrialmaster.personalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences profile =
                getSharedPreferences("profile", MODE_PRIVATE);

        if(profile.contains("NAME")){
            setContentView(R.layout.activity_main);
            TextView tvMsg = findViewById(R.id.msg);
            tvMsg.setText("Welcome "+profile.getString("NAME","Guest"));
        }else{
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }



    }

    public void notes(View v){
        Intent intent = new Intent(this, NoteListActivity.class);
        startActivity(intent);
    }
}
