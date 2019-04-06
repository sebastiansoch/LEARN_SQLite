package com.gmail.sebastiansoch.sqlite;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static <T> List<String> toListString(List<T> items) {
        List<String> listString = new ArrayList<>();

        for (T item: items) {
            listString.add(item.toString());
        }

        return listString;
    }
}
