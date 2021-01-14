package com.example.quizapp.utilities;

import android.annotation.SuppressLint;

import com.example.quizapp.model.database.Score;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ScoresUtility {

    private static SimpleDateFormat format;

    public static void sortEqualScoresByDate(List<Score> scores) throws ParseException {
        for (int i = 0; i < scores.size() - 1; i++) {
            if (scores.get(i).getResult() == scores.get(i+1).getResult()){
                if (getSimpleDataFormatInstance().parse(scores.get(i).getDate()).compareTo(getSimpleDataFormatInstance().parse(scores.get(i+1).getDate())) > 0){
                    Collections.swap(scores, i, i+1);
                }
            }
        }

    }

    @SuppressLint("SimpleDateFormat")
    public static SimpleDateFormat getSimpleDataFormatInstance(){
        if (format == null) {
            format = new SimpleDateFormat("yyyy-MM-dd");
        }
        return format;
    }

}
