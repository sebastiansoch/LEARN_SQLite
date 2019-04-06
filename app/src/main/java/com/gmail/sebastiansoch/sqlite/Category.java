package com.gmail.sebastiansoch.sqlite;

import java.io.Serializable;

enum Category implements Serializable {
    HOME("Home"),
    PROJECT("Project"),
    TODO("Todo");

    private String categoryName;

    Category() {
    }

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
