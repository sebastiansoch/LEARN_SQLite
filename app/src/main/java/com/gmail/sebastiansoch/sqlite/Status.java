package com.gmail.sebastiansoch.sqlite;

import java.io.Serializable;

enum Status implements Serializable {
    NEW("New"),
    PROGRESS("Progress"),
    DONE("Done");

    private String statusName;

    Status() {
    }

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
