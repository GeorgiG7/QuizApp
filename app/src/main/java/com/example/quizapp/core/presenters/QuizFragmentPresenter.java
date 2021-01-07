package com.example.quizapp.core.presenters;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.quizapp.api.Api;
import com.example.quizapp.core.constracts.QuizFragmentContract;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.database.Score;
import com.example.quizapp.model.database.ScoreDbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizFragmentPresenter implements QuizFragmentContract.PresenterListener {

    private List<Question> questionList = new ArrayList<>();
    private QuizFragmentContract.ViewListener viewListener;
    private int index = 0;
    private int counter = 0;
    private int quizCategory = 12;
    private int checkedId;
    private ScoreDbService service;

    @Override
    public void setViewListener(QuizFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public int getCheckedId() {
        return checkedId;
    }

    public void getQuiz(int category, Context context) {
        Api.getInstance().getQuiz(category, new Api.ApiListener() {
            @Override
            public void onQuizReceived(Quiz quiz) {
                questionList = quiz.getQuestions();
                setQuestionsInView();
            }

            @Override
            public void onFailure() {
                Toast.makeText(context, "Couldn't retrieve data from Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void getNextQuestion(int category, Context context) {
        if (index == 10 || index == 0 || category != quizCategory) {
            index = 0;
            getQuiz(category, context);
            quizCategory = category;
        } else
            setQuestionsInView();

    }

    @Override
    public void submitAnswer(String submittedAnswer) {
        if (submittedAnswer.equals(questionList.get(index - 1).getCorrectAnswer())) {
            counter++;
        } else {
            counter = 0;
        }
        viewListener.setCorrectAnswerStreakCounterAndShowRightAnswer(counter, checkedId);
    }

    @Override
    public void radioGroupChecked(int checkedId) {
        this.checkedId = checkedId;
        viewListener.unableRadioGroup();
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
