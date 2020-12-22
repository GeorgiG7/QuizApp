package com.example.quizapp;

import android.app.Application;

import com.example.quizapp.di.ApplicationComponent;
import com.example.quizapp.di.DaggerApplicationComponent;

public class QuizApplication extends Application {

    ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
}
