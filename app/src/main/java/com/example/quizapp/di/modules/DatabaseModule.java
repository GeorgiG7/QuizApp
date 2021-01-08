package com.example.quizapp.di.modules;

import android.util.Log;

import androidx.core.content.PermissionChecker;
import androidx.room.RoomDatabase;

import com.example.quizapp.QuizApplication;
import com.example.quizapp.model.database.ScoreDao;
import com.example.quizapp.model.database.ScoreDao_Impl;
import com.example.quizapp.model.database.ScoreDbService;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {


    @Provides
    ScoreDbService provideQuoteService(QuizApplication quizApplication){
        return new ScoreDbService(quizApplication);
    }
}
