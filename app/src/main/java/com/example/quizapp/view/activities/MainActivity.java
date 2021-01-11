package com.example.quizapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.view.adapters.FragmentAdapter;
import com.example.quizapp.view.fragments.QuizFragment;
import com.example.quizapp.view.fragments.ScoreboardFragment;
import com.google.android.material.tabs.TabLayoutMediator;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Inject
    QuizFragment quizFragment;

    @Inject
    ScoreboardFragment scoreboardFragment;

    @Override
    protected void onViewCreated() {
        if(isNetworkAvailable()) {
            tabManaging();
        } else {
            displayNotConnectedMessage();
        }
    }

    @Override
    protected ActivityMainBinding inflateBinding() {
        return ActivityMainBinding.inflate(LayoutInflater.from(this));
    }

    private void tabManaging() {
        binding.view.setAdapter(new FragmentAdapter(this, quizFragment, scoreboardFragment));
        new TabLayoutMediator(binding.tabLayout, binding.view, (tab, position) -> {
            if (position == FragmentAdapter.QUIZ_TAB_POSITION) {
                tab.setText("Quiz");
            } else {
                tab.setText("Scoreboard");
            }
        }).attach();
    }

    private void displayNotConnectedMessage(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please check your internet connection and try again")
                    .setTitle("Not connected").setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    recreate();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}