package com.industrialmaster.personalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        TextView tvNotes = findViewById(R.id.note_viewer);
        
        try {
            FileInputStream fis = 	openFileInput("notes.txt");
            byte[] chars = new byte[fis.available()];
            fis.read(chars);
            fis.close();

            String string = new String(chars);

            tvNotes.setText(string);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error Reading Notes!", Toast.LENGTH_SHORT).show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this, NoteEditActivity.class);
                startActivity(intent);
            }
        });
    }

}
