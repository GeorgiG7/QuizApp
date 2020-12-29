package com.example.quizapp.view.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<T extends ViewBinding> extends DaggerAppCompatActivity {

    protected T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = inflateBinding();
        View view = binding.getRoot();
        setContentView(view);
        onViewCreated();
    }


    protected abstract T inflateBinding();

    protected abstract void onViewCreated();
}
