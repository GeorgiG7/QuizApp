package com.example.quizapp.core.constracts;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import java.util.List;

public interface QuizFragmentContract {

    interface ViewListener{
        void setQuestions(String question, List<String> answers, String correctAnswer);
        void setCorrectAnswerStreakCounterAndShowRightAnswer(int counter, int checkedId);
        void unableRadioGroup();
    }

    interface PresenterListener{
        void setViewListener(ViewListener viewListener);

        void getNextQuestion(int category, Context context);

        void submitAnswer(String submittedAnswer);

        void radioGroupChecked(int checkedId);

        int getCheckedId();
    }
}
