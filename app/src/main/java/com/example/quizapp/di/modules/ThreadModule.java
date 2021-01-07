package com.example.quizapp.di.modules;

import android.os.Handler;
import android.os.Looper;

import com.example.quizapp.core.treadPool.HandlerMainThread;
import com.example.quizapp.core.treadPool.MainThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreadModule {

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Named("dbExecutor")
    @Provides
    @Singleton
    public Executor provideDbExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    public MainThread provideMainThread() {
        return new HandlerMainThread(new Handler(Looper.getMainLooper()));
    }

}
