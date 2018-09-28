package com.industrialmaster.personalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteListActivity.this, NoteEditActivity.class);
                startActivity(intent);
            }
        });

        ListView lv = findViewById(R.id.note_list);

        try {
            File folder = new File(getFilesDir()+File.separator+"notes");
            if(!folder.exists()){
                folder.mkdir();
            }


            List<String> list = new ArrayList<String>();

            String[] files = folder.list();
            for(String fileName: files){

                File file = new File(getFilesDir()+File.separator+"notes"+
                        File.separator+fileName);
                FileInputStream fis = 	new FileInputStream(file);
                byte[] chars = new byte[fis.available()];
                fis.read(chars);
                fis.close();

                String string = new String(chars);
                list.add(string);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, list);

            lv.setAdapter(adapter);


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error Reading Notes.", Toast.LENGTH_SHORT).show();
        }


    }

}
