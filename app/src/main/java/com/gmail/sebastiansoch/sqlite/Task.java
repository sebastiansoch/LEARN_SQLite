package com.gmail.sebastiansoch.sqlite;

import java.io.Serializable;

class Task implements Serializable {
    int id;
    String name;
    Category category;
    Status status;

    public Task() {
    }

    public Task(int id, String name, Category category, Status status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name + " : " + "  Category: " + category.getCategoryName() + " Status: " + status.getStatusName();
    }
}
