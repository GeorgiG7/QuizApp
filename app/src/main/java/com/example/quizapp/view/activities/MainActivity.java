package com.example.quizapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizapp.R;
import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    Button btn;

    @Inject
    QuizFragment quizFragment;

    @Inject
    ScoreboardFragment scoreboardFragment;

    @Override
    protected void onViewCreated() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_host, quizFragment);
        fragmentTransaction.commit();
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frag_host, scoreboardFragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}