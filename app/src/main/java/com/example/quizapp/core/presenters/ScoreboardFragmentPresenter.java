package com.example.quizapp.core.presenters;

import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.core.constracts.ScoreboardFragmentContract;
import com.example.quizapp.model.database.ScoreDbService;
import com.example.quizapp.utilities.ScoresUtility;

public class ScoreboardFragmentPresenter implements ScoreboardFragmentContract.PresenterListener {

    private ScoreboardFragmentContract.ViewListener viewListener;
    private ScoreDbService service;

    @Override
    public void setViewListener(ScoreboardFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void setScoreDbService(ScoreDbService service) {
        this.service = service;
    }

    @Override
    public void getScoresFromDb() {
        service.getAllScores(data -> {
            ScoresUtility.sortEqualScoresByDate(data);
            viewListener.setScoresToRecView(data);
        });
    }
}
