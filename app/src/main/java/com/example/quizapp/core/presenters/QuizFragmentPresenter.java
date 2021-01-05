package com.example.quizapp.core.presenters;

import com.example.quizapp.api.Api;
import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizFragmentPresenter implements QuizFragmentContract.PresenterListener {

    List<Question> questionList = new ArrayList<>();
    QuizFragmentContract.ViewListener viewListener;
    int index = 0;
    int quizCategory = 12;

    @Override
    public void setViewListener(QuizFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public void getQuiz(int category) {
        Api.getInstance().getQuiz(category, new Api.ApiListener() {
            @Override
            public void onQuizReceived(Quiz quiz) {
                questionList = quiz.getQuestions();
                setQuestionsInView();
            }

            @Override
            public void onFailure() {

            }
        });
    }

    @Override
    public void getNextQuestion(int category) {
        if (index == 10 || index == 0 || category != quizCategory) {
            index = 0;
            getQuiz(category);
            quizCategory = category;
        } else
            setQuestionsInView();

    }

    private void setQuestionsInView() {
        Question question = questionList.get(index);
        index++;
        List<String> allAnswers = question.getIncorrectAnswers();
        Random random = new Random();
        int pos = random.nextInt(allAnswers.size() + 1);
        allAnswers.add(pos, question.getCorrectAnswer());
        viewListener.setQuestions(question.getQuestion(), allAnswers, question.getCorrectAnswer());
    }


}
