package com.example.quizapp.core.presenters;

import com.example.quizapp.core.constracts.QuizFragmentContract;

public class QuizFragmentPresenter implements QuizFragmentContract.PresenterListener {

    private QuizFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(QuizFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }
}
