package com.example.quizapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {

    @SerializedName("results")
    List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }
}
