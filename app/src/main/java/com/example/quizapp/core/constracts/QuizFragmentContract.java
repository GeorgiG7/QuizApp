package com.example.quizapp.core.constracts;

public interface QuizFragmentContract {

    interface ViewListener{}

    interface PresenterListener{
        void setViewListener(ViewListener viewListener);
    }
}
