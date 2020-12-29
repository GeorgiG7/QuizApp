package com.example.quizapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding>{

    @Inject
    QuizFragment quizFragment;

    @Inject
    ScoreboardFragment scoreboardFragment;

    @Override
    protected void onViewCreated() {

    }

    @Override
    protected ActivityMainBinding inflateBinding() {
        return ActivityMainBinding.inflate(LayoutInflater.from(this));
    }
}