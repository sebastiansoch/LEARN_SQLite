package com.gmail.sebastiansoch.sqlite;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class TasksArrayAdapter extends ArrayAdapter<String> {

    private TaskRepo taskRepoInterface;

    public TasksArrayAdapter(Context context, int resource, TaskRepo taskRepoInterface) {
        super(context, resource);
        this.taskRepoInterface = taskRepoInterface;
    }

    void refresh() {
        List<String> sAllTasks = Helper.toListString(taskRepoInterface.getAllTasks());
        clear();
        addAll(sAllTasks);
    }

}
