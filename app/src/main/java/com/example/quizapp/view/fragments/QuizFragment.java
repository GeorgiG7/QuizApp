package com.example.quizapp.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizapp.R;
import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.databinding.FragmentQuizBinding;

import javax.inject.Inject;

public class QuizFragment extends BaseFragment<FragmentQuizBinding> implements QuizFragmentContract.ViewListener {

    @Inject
    QuizFragmentContract.PresenterListener presenterListener;

    @Inject
    public QuizFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presenterListener.setViewListener(this);
    }

    @Override
    protected FragmentQuizBinding inflateBinding() {
        return FragmentQuizBinding.inflate(LayoutInflater.from(getContext()));
    }
}