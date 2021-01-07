package com.example.quizapp.core.treadPool;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class Worker {
    private final Executor executor;
    private final MainThread mainThread;
    private Runnable background;
    private Runnable main;

    @Inject
    public Worker(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }

    public Worker inBackground(Runnable task) {
        background = task;
        return this;
    }

    public Worker onMain(Runnable task) {
        main = task;
        return this;
    }

    public void run() {
        checkOperations();

        executor.execute(() -> {
            background.run();

            mainThread.post(main);

            reset();
        });
    }

    private void checkOperations() {
        if (main == null || background == null) {
            throw new IllegalArgumentException("You need to set tasks in order to use this class.");
        }
    }

    private void reset() {
        main = null;
        background = null;
    }

}
