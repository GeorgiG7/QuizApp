package com.example.quizapp.di.modules;

import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract QuizFragment providesQuizFragment();

    @ContributesAndroidInjector
    abstract ScoreboardFragment providesScoreBoardFragment();
}
