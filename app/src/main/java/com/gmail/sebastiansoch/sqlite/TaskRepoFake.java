package com.gmail.sebastiansoch.sqlite;

import java.util.ArrayList;
import java.util.List;

class TaskRepoFake implements TaskRepo {
    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Zadanie 1", Category.HOME, Status.NEW));
        tasks.add(new Task(2, "Zadanie 2", Category.HOME, Status.NEW));
        tasks.add(new Task(3, "Zadanie 3", Category.PROJECT, Status.PROGRESS));
        tasks.add(new Task(4, "Zadanie 4", Category.TODO, Status.PROGRESS));
        tasks.add(new Task(5, "Zadanie 5", Category.PROJECT, Status.NEW));
        tasks.add(new Task(6, "Zadanie 6", Category.HOME, Status.DONE));
        tasks.add(new Task(7, "Zadanie 7", Category.HOME, Status.DONE));
        tasks.add(new Task(8, "Zadanie 8", Category.TODO, Status.DONE));

        return tasks;
    }

    @Override
    public void addTask(Task task) {

    }
}
