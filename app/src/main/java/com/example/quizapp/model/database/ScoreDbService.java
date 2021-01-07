package com.example.quizapp.model.database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class ScoreDbService {
    private final ScoreDao scoreDao;

    @Inject
    public ScoreDbService(Context context) {
        scoreDao = Database.getInstance(context).scoreDao();
    }

    

    public interface DataListener<T> {
        void onData(T data);
    }
}
