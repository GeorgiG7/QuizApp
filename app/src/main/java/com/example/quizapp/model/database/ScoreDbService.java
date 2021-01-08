package com.example.quizapp.model.database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import com.example.quizapp.core.treadPool.ThreadingProvider;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class ScoreDbService {
    private final ScoreDao scoreDao;
    @Inject
    ThreadingProvider threadingProvider;

    @Inject
    public ScoreDbService(Context context) {
        scoreDao = Database.getInstance(context).scoreDao();
    }


//
//    public void getAllScores(DataListener<List<Score>> dataListener){
//        threadingProvider.getDbExecutor().execute(() -> {
//            List<Score> allScores = scoreDao.getAllScores();
//            threadingProvider.getMainThread().post(() -> dataListener.onData(allScores));
//        });
//    }

    public void saveScore(Score score){
        threadingProvider.getDbExecutor().execute(() -> scoreDao.saveScore(score));
    }



    public interface DataListener<T> {
        void onData(T data);
    }
}
