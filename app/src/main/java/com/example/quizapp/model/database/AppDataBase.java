package com.example.quizapp.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import javax.inject.Inject;

@Database(entities = {Score.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ScoreDao scoreDao();

}
