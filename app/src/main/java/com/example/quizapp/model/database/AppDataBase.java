package com.example.quizapp.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Score.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ScoreDao scoreDao();

}
