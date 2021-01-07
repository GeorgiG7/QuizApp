package com.example.quizapp.api;

import com.example.quizapp.model.Quiz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiQuizService {
    @GET("api.php?amount=10&difficulty=easy&type=multiple")
    Call<Quiz> getQuizByCategory(@Query("category") int category);


}
