package com.example.quizapp.core.constracts;

import com.example.quizapp.model.database.Score;
import com.example.quizapp.model.database.ScoreDbService;

import java.util.List;

public interface ScoreboardFragmentContract {

    interface ViewListener{
        void setScoresToRecView(List<Score> scores);
    }

    interface PresenterListener{
        void setViewListener(ScoreboardFragmentContract.ViewListener viewListener);
        void setScoreDbService(ScoreDbService service);
        void getScoresFromDb();
    }
}
