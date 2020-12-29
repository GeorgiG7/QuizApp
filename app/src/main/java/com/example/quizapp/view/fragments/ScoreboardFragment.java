package com.example.quizapp.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp.R;
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