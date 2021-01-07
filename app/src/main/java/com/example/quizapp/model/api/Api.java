package com.example.quizapp.model.api;

import com.example.quizapp.model.Quiz;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Api instance;
    private final ApiQuizService service;
    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiQuizService.class);
    }
    public static Api getInstance() {
        if (instance == null) instance = new Api();
        return instance;
    }
    public void getQuiz(int category, ApiListener apiListener) {
        service.getQuizByCategory(category).enqueue(new Callback<Quiz>() {
            @Override
            public void onResponse(Call<Quiz> call, Response<Quiz> response) {
                apiListener.onQuizReceived(response.body());
            }
            @Override
            public void onFailure(Call<Quiz> call, Throwable t) {
                apiListener.onFailure();
            }
        });
    }
    public interface ApiListener {
        void onQuizReceived(Quiz quiz);
        void onFailure();
    }
}
