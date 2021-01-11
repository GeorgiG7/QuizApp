package com.example.quizapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.quizapp.R;
import com.example.quizapp.core.constracts.ScoreboardFragmentContract;
import com.example.quizapp.core.treadPool.ThreadingProvider;
import com.example.quizapp.databinding.FragmentScoreboardBinding;
import com.example.quizapp.model.database.Score;
import com.example.quizapp.model.database.ScoreDbService;
import com.example.quizapp.view.adapters.ScoresAdapter;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class ScoreboardFragment extends BaseFragment<FragmentScoreboardBinding> implements ScoreboardFragmentContract.ViewListener {

    @Inject
    ScoreboardFragmentContract.PresenterListener presenterListener;
    @Inject
    ScoreDbService scoreDbService;
    @Inject
    ThreadingProvider provider;

    private ScoresAdapter adapter;

    @Inject
    public ScoreboardFragment() {
    }


    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presenterListener.setViewListener(this);
        scoreDbService.setThreadingProvider(provider);
        presenterListener.setScoreDbService(scoreDbService);
        bindRecyclerView();
    }

    private void hideCounterTextViewFromToolbar() {
        Objects.requireNonNull(getActivity()).findViewById(R.id.counter_txt).setVisibility(View.INVISIBLE);
    }

    @Override
    protected FragmentScoreboardBinding inflateBinding() {
        return FragmentScoreboardBinding.inflate(LayoutInflater.from(getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenterListener.getScoresFromDb();
        hideCounterTextViewFromToolbar();
    }

    private void bindRecyclerView(){
        adapter = new ScoresAdapter();
        binding.recView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recView.setAdapter(adapter);
    }

    @Override
    public void setScoresToRecView(List<Score> scores) {
        adapter.setScores(scores);
    }
}