package com.example.quizapp.view.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.example.quizapp.R;
import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.databinding.FragmentQuizBinding;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class QuizFragment extends BaseFragment<FragmentQuizBinding> implements QuizFragmentContract.ViewListener {


    int counter = 5;

    @Inject
    QuizFragmentContract.PresenterListener presenterListener;

    @Inject
    public QuizFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        presenterListener.setViewListener(this);
        binding.btnNextQuestion.setOnClickListener(v -> presenterListener.getNextQuestion());
        binding.radioGroup.setOnCheckedChangeListener((this::validateChosenAnswer));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected FragmentQuizBinding inflateBinding() {
        return FragmentQuizBinding.inflate(LayoutInflater.from(getContext()));
    }

    @Override
    public void setQuestions(String question, List<String> answers, String correctAnswer) {
        binding.question.setText(question);
        binding.radioGroup.removeAllViews();
        for (String answer : answers) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(answer);
            if (answer.equals(correctAnswer)) radioButton.setId(R.id.correct_answer_radio_button);
            binding.radioGroup.addView(radioButton);
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.drawer_menu, menu);
    }

    private void tryT(){

    }


    private void validateChosenAnswer(RadioGroup group, int checkedId) {
        if (checkedId != R.id.correct_answer_radio_button) {
            Objects.requireNonNull(getActivity()).findViewById(checkedId).setBackgroundColor(Color.RED);
        }
        Objects.requireNonNull(getActivity()).findViewById(R.id.correct_answer_radio_button).setBackgroundColor(Color.GREEN);
    }
}