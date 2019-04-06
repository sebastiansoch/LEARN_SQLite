package com.gmail.sebastiansoch.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class ToolTaskRepoSQLite implements TaskRepo {

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;

    public ToolTaskRepoSQLite(Context context) {
        this.context = context;
    }

    void open() {
        Log.d("SS ", "Call open");
        dbHelper = new DBHelper(context, "todo.db", 4);
        db = dbHelper.getWritableDatabase();
    }

    void close() {
        Log.d("SS ", "Call close");
        db.close();
    }

    @Override
    public List<Task> getAllTasks() {
        Log.d("SS ", "Call getAllTask");
        Cursor cursor = db.query("task", new String[]{"id", "name", "categoryId", "statusId"}, null, null, null, null, null);

        List<Task> tasks = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int taskId = cursor.getInt(cursor.getColumnIndex("id"));
                String taskName = cursor.getString(cursor.getColumnIndex("name"));
                int categoryId = cursor.getInt(cursor.getColumnIndex("categoryId"));
                int statusId = cursor.getInt(cursor.getColumnIndex("statusId"));

                tasks.add(new Task(taskId, taskName, getCategory(categoryId), getStatus(statusId)));
            } while (cursor.moveToNext());
        }

        return tasks;
    }

    private Category getCategory(int categoryId) {
        for (Category category : Category.values()) {
            if (category.ordinal() == categoryId) {
                return category;
            }
        }

        return null;
    }

    private Status getStatus(int statusId) {
        for (Status status : Status.values()) {
            if (status.ordinal() == statusId) {
                return status;
            }
        }

        return null;
    }


    @Override
    public void addTask(Task task) {
        Log.d("SS ", "Call addTask");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", task.getName());
        contentValues.put("categoryId", task.getCategory().ordinal());
        contentValues.put("statusId", task.getStatus().ordinal());
        long taskID = db.insert("task", null, contentValues);
        Log.d("SS ", "taskID");
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, int version) {
            super(context, name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("SS ", "Call onCreate method");

            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS category(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)"
            );
            Log.d("SS ", "Created category table");

            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS status(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)"
            );
            Log.d("SS ", "Created status table");

//            db.execSQL(
//                    "CREATE TABLE task(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, categoryId INT, statusId INT, " +
//                            "FOREIGN KEY(categoryId) REFERENCES category(id), " +
//                            "FOREIGN KEY(statusId) REFERENCES status(id))"
//            );

            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS task(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, categoryId INT, statusId INT)"
            );


            Log.d("SS ", "Created task table");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("SS ", "Call onUpgrade method");
            db.execSQL("DROP TABLE IF EXISTS task");
            Log.d("SS ", "Call DROP TABLE");
            onCreate(db);
        }
    }
}
