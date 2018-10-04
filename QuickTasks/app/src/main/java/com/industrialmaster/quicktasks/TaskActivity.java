package com.industrialmaster.quicktasks;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }

    public void save(View v){
        EditText etName = findViewById(R.id.task_name);
        EditText etDate = findViewById(R.id.task_date);

        String name = etName.getText().toString();
        String date = etDate.getText().toString();

        DBHelper dbHelper =  new DBHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql = "INSERT INTO tasks(name,date, complete) VALUES"+
                " ('"+name+"','"+date+"', 'false')";
        db.execSQL(sql);
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();


    }

}
