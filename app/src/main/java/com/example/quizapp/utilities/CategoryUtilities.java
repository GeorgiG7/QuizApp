package com.example.quizapp.utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizapp.R;

public class CategoryUtilities {
    @SuppressLint("NonConstantResourceId")
    public static int defineSelectedCategory(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.category_books:
                //Toast.makeText(context, "The next question will be category: " , Toast.LENGTH_SHORT).show();
                return 10;
            case R.id.category_films:
                return 11;
            case R.id.category_music:
                return  12;
            case R.id.category_musicals_and_theatres:
                return 13;
            case R.id.category_television:
                return  14;
            case R.id.category_video_games:
                return  15;
            case R.id.category_board_games:
                return  16;
            case R.id.category_science_and_nature:
                return  17;
            case R.id.category_computers:
                return  18;
            case R.id.category_mathematics:
                return  19;
            case R.id.category_mythology:
                return  20;
            case R.id.category_sports:
                return  21;
            case R.id.category_geography:
                return 22;
            case R.id.category_history:
                return  23;
            case R.id.category_politics:
                return  24;
            case R.id.category_art:
                return  25;
            case R.id.category_celebrities:
                return  26;
            case R.id.category_animals:
                return  27;
            case R.id.category_vehicles:
                return  28;
            case R.id.category_comics:
                return  29;
            case R.id.category_gadgets:
                return  30;
            case R.id.category_japanese_anime_and_manga:
                return  31;
            case R.id.category_cartoons_and_animations:
                return  32;
            default:
                return 9;
        }
    }
}
