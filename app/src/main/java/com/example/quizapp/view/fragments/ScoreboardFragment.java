package com.example.quizapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.quizapp.core.constracts.ScoreboardFragmentContract;
import com.example.quizapp.databinding.FragmentScoreboardBinding;

import javax.inject.Inject;

public class ScoreboardFragment extends BaseFragment<FragmentScoreboardBinding> implements ScoreboardFragmentContract.ViewListener {

    @Inject
    ScoreboardFragmentContract.PresenterListener presenterListener;

    @Inject
    public ScoreboardFragment() {
    }


    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presenterListener.setViewListener(this);
    }

    @Override
    protected FragmentScoreboardBinding inflateBinding() {
        return FragmentScoreboardBinding.inflate(LayoutInflater.from(getContext()));
    }



}