package com.gmail.sebastiansoch.sqlite;

import java.util.List;

public interface TaskRepo {
    List<Task> getAllTasks();
    void addTask(Task task);

}
