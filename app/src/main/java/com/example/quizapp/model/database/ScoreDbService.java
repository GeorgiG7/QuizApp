package com.example.quizapp.model.database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import com.example.quizapp.core.treadPool.ThreadingProvider;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class ScoreDbService {
    private final ScoreDao scoreDao;
    private  ThreadingProvider threadingProvider;

    public ScoreDbService(Context context) {
        scoreDao = Database.getInstance(context).scoreDao();

    }

    public void setThreadingProvider(ThreadingProvider threadingProvider) {
        this.threadingProvider = threadingProvider;
    }

    public void getAllScores(DataListener<List<Score>> dataListener){
        threadingProvider.getDbExecutor().execute(() -> {
            List<Score> allScores = scoreDao.getBestTenScores();
            threadingProvider.getMainThread().post(() -> {
                try {
                    dataListener.onData(allScores);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public void saveScore(Score score){
        threadingProvider.getDbExecutor().execute(() -> scoreDao.saveScore(score));
    }



    public interface DataListener<T> {
        void onData(T data) throws ParseException;
    }
}
