package com.example.quizapp.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentScoreboardBinding;

import javax.inject.Inject;

public class ScoreboardFragment extends BaseFragment<FragmentScoreboardBinding> {

    @Inject
    public ScoreboardFragment() {
    }


    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_scoreboard;
    }


}