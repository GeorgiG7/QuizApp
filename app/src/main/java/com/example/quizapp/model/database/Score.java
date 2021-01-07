package com.example.quizapp.model.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scores")
public class Score {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "result")
    public int result;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getResult() {
        return result;
    }
}
