package com.example.quizapp.core.constracts;

public interface ScoreboardFragmentContract {

    interface ViewListener{}

    interface PresenterListener{
        void setViewListener(ScoreboardFragmentContract.ViewListener viewListener);
    }
}
