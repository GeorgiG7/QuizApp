package com.example.quizapp.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ScoreDao {

    @Insert
    void saveScore(Score score);

    @Query("SELECT * FROM scores ORDER BY result DESC limit 11")
    List<Score> getBestTenScores();
}
