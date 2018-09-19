package com.indrustrialmaster.fundapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Created..",Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Stop...",Toast.LENGTH_SHORT).show();
    }
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "Restart...",Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Destroy...",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Strat...",Toast.LENGTH_SHORT).show();
    }

    public void player(View view){
        Intent intent= new Intent(MainActivity.this, PlayerActivity.class);
        startActivity(intent);
    }
    public void download(View view){
        Intent intent= new Intent(MainActivity.this, download.class);
        startActivity(intent);
    }
}
