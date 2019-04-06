package com.gmail.sebastiansoch.sqlite;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private TaskRepo taskRepo;
    private static final int ADD_TASK = 1;
    private TasksArrayAdapter tasksArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.taskListView);
//        TaskRepo taskRepo = new TaskRepoFake();

        if (taskRepo == null) {
            taskRepo = new ToolTaskRepoSQLite(this);
            ((ToolTaskRepoSQLite) taskRepo).open();
        }

        tasksArrayAdapter = new TasksArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, taskRepo);
        tasksArrayAdapter.refresh();
        listView.setAdapter(tasksArrayAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((ToolTaskRepoSQLite) taskRepo).close();
    }

    public void onAddTask(View view) {
        Intent intent = new Intent(this, AddTask.class);
        startActivityForResult(intent, ADD_TASK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_TASK) {
             Task task = (Task) data.getSerializableExtra("task");
            taskRepo.addTask(task);
            tasksArrayAdapter.refresh();
        }
    }
}
