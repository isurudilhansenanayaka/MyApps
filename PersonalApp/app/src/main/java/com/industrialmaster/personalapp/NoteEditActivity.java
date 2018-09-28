package com.industrialmaster.personalapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
    }

    public void saveNote(View v){
        EditText et = findViewById(R.id.note_editor);
        String content = et.getText().toString();

        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd-hh-mm");
            String fileName = sdf.format(date);

            File file = new File(getFilesDir()+File.separator+"notes"+
                    File.separator+fileName+".txt");
            FileOutputStream fos = 	new FileOutputStream(file);


            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, NoteListActivity.class);
            startActivity(intent);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error Writing to Storage", Toast.LENGTH_SHORT).show();
        }
    }
}
