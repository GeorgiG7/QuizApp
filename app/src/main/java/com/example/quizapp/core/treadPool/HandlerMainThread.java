package com.example.quizapp.core.treadPool;


import android.os.Handler;

public class HandlerMainThread implements MainThread {

    Handler mainHandler;

    public HandlerMainThread(Handler mainHandler) {
        this.mainHandler = mainHandler;
    }

    @Override
    public void post(Runnable runnable) {
        mainHandler.post(runnable);
    }
}

