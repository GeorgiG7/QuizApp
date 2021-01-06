package com.example.quizapp.view.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.R;
import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.databinding.FragmentQuizBinding;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class QuizFragment extends BaseFragment<FragmentQuizBinding> implements QuizFragmentContract.ViewListener {


    private int counter = 0;
    private int category = 10;
    private int checkedRadioButtonId;

    @Inject
    QuizFragmentContract.PresenterListener presenterListener;

    @Inject
    public QuizFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(getActivity().findViewById(R.id.toolbar));
        setHasOptionsMenu(true);
        presenterListener.setViewListener(this);
        setListeners();
    }

    @Override
    protected FragmentQuizBinding inflateBinding() {
        return FragmentQuizBinding.inflate(LayoutInflater.from(getContext()));
    }

    private void setListeners() {
        binding.btnNextQuestion.setOnClickListener(v -> presenterListener.getNextQuestion(category, this.getContext()));
        binding.radioGroup.setOnCheckedChangeListener((this::setCheckedRadioButtonIdLocally));
        binding.btnSubmitAnswer.setOnClickListener((this::validateChosenAnswer));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.drawer_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.category_geography:
                this.category = 22;
                break;
            case R.id.category_music:
                this.category = 12;
                break;
        }
        return super.onOptionsItemSelected(item);
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
        setEnabledOrDisabled(false);
    }

    private void setCheckedRadioButtonIdLocally(RadioGroup group, int checkedId) {
        checkedRadioButtonId = checkedId;
        binding.btnSubmitAnswer.setEnabled(true);
    }

    private void validateChosenAnswer(View view) {
        if (checkedRadioButtonId == R.id.correct_answer_radio_button) {
            counter++;
            Objects.requireNonNull(getActivity()).findViewById(checkedRadioButtonId).setBackgroundColor(Color.GREEN);
        } else {
            Objects.requireNonNull(getActivity()).findViewById(checkedRadioButtonId).setBackgroundColor(Color.RED);
            Objects.requireNonNull(getActivity()).findViewById(R.id.correct_answer_radio_button).setBackgroundColor(Color.GREEN);
            counter = 0;
        }
        updateCounterTry();
        setEnabledOrDisabled(true);
        setHasOptionsMenu(counter == 0);
        binding.btnSubmitAnswer.setEnabled(false);
    }

    private void setEnabledOrDisabled(boolean isEnabled) {
        for (int i = 0; i < binding.radioGroup.getChildCount(); i++) {
            binding.radioGroup.getChildAt(i).setEnabled(!isEnabled);
            ((RadioButton) binding.radioGroup.getChildAt(i)).setTextColor(Color.BLACK);
        }
    }

    @SuppressLint("SetTextI18n")
    public void updateCounterTry() {
        ((TextView) Objects.requireNonNull(getActivity()).findViewById(R.id.counter_txt)).setText("" + counter);
    }
}