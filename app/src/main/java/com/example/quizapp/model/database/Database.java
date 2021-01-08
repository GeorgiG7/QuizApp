package com.example.quizapp.model.database;

import android.content.Context;

import androidx.room.Room;

public class Database {

    private static AppDataBase instance;
    public static final String DATABASE_NAME = "com.example.quizapp.model.database";

    private Database() {
    }

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
