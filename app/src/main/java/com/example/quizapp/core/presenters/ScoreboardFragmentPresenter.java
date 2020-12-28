package com.example.quizapp.core.presenters;

import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.core.constracts.ScoreboardFragmentContract;

public class ScoreboardFragmentPresenter implements ScoreboardFragmentContract.PresenterListener {

private ScoreboardFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(ScoreboardFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }
}
