package com.example.quizapp.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;

import javax.inject.Inject;

public class FragmentAdapter extends FragmentStateAdapter {
    public static final int QUIZ_TAB_POSITION = 0;

    private QuizFragment quizFragment;

    private ScoreboardFragment scoreboardFragment;

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity, QuizFragment quizFragment, ScoreboardFragment scoreboardFragment) {
        super(fragmentActivity);
        this.quizFragment = quizFragment;
        this.scoreboardFragment = scoreboardFragment;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == QUIZ_TAB_POSITION) {
            return quizFragment;
        }
        return scoreboardFragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

