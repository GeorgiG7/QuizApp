package com.example.quizapp.core.treadPool;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Named;

public class ThreadingProvider {

    private final Executor executor;
    private final MainThread mainThread;
    private final Worker worker;
    private final Executor db;

    @Inject
    public ThreadingProvider(Executor executor, MainThread mainThread, @Named("dbExecutor") Executor dbExecutor) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.worker = new Worker(executor, mainThread);
        this.db = dbExecutor;
    }

    public Executor getDbExecutor() {
        return db;
    }

    public Executor getExecutor() {
        return executor;
    }

    public MainThread getMainThread() {
        return mainThread;
    }

    public Worker getWorker() {
        return worker;
    }
}
