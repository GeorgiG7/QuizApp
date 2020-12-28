package com.example.quizapp.di.modules;

import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.core.constracts.ScoreboardFragmentContract;
import com.example.quizapp.core.presenters.QuizFragmentPresenter;
import com.example.quizapp.core.presenters.ScoreboardFragmentPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContractsModule {

    @Singleton
    @Provides
    public QuizFragmentContract.PresenterListener providesQuizFragmentPresenter(){
        return new QuizFragmentPresenter();
    }

    @Singleton
    @Provides
    public ScoreboardFragmentContract.PresenterListener providesScoreboardFragmentPresenter(){
        return new ScoreboardFragmentPresenter();
    }
}
