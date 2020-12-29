package com.example.quizapp.view.fragments;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewBinding> extends DaggerFragment {

    protected T binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = inflateBinding();
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onFragmentCreated(view, savedInstanceState);
    }


    protected abstract void onFragmentCreated(View view, Bundle savedInstanceState);

    protected abstract T inflateBinding();


}
