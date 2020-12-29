package com.example.quizapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {

    @SerializedName("question")
    String question;
    @SerializedName("correct_answer")
    String correctAnswer;
    @SerializedName("incorrect_answers")
    List<String> incorrectAnswers;

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
