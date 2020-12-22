package com.example.quizapp.di.modules;

import com.example.quizapp.view.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
