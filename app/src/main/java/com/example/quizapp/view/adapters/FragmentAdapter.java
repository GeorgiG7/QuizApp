package com.example.quizapp.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public static final int QUIZ_TAB_POSITION = 0;

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == QUIZ_TAB_POSITION) {
            return new QuizFragment();
        }
        return new ScoreboardFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

