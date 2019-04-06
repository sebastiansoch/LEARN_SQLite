package com.gmail.sebastiansoch.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

    }

    public void saveNewTask(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText taskName = findViewById(R.id.taskNameEditText);
        Task task = new Task(0, taskName.getText().toString(), Category.HOME, Status.NEW);
        intent.putExtra("task", task);
        setResult(2, intent);
        finish();
    }
}
