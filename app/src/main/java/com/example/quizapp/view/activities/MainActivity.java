package com.example.quizapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.quizapp.R;
import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    QuizFragment quizFragment;

    @Inject
    ScoreboardFragment scoreboardFragment;

    @Override
    protected void onViewCreated() {
        
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}