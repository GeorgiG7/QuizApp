package com.example.quizapp.core.constracts;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public interface QuizFragmentContract {

    interface ViewListener{
        void setQuestions(String question, List<String> answers, String correctAnswer);
        void updateCounter(MenuItem menuItem);
    }

    interface PresenterListener{
        void setViewListener(ViewListener viewListener);

        void getNextQuestion();

        void onChosenAnswer(MenuItem menuItem);

    }
}
