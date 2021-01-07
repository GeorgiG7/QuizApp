package com.example.quizapp.model.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreDao {

    List<Score> getAllScores();
}
