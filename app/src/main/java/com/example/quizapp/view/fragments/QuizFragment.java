package com.example.quizapp.view.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.quizapp.R;
import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.databinding.FragmentQuizBinding;

import java.util.List;

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
        binding.btnNextQuestion.setOnClickListener(v -> presenterListener.getNextQuestion());
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.correct_answer_radio_button) {
                    getActivity().findViewById(checkedId).setBackgroundColor(Color.RED);
                }
                getActivity().findViewById(R.id.correct_answer_radio_button).setBackgroundColor(Color.GREEN);
            }
        });
    }

    @Override
    protected FragmentQuizBinding inflateBinding() {
        return FragmentQuizBinding.inflate(LayoutInflater.from(getContext()));
    }

    @Override
    public void setQuestions(String question, List<String> answers, String correctAnswer) {
        binding.question.setText(question);
        binding.radioGroup.removeAllViews();
        for (String answer: answers) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(answer);
            if (answer.equals(correctAnswer)) radioButton.setId(R.id.correct_answer_radio_button);
            binding.radioGroup.addView(radioButton);
        }
    }
}