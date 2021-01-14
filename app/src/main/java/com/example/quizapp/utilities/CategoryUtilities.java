package com.example.quizapp.utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quizapp.R;

public class CategoryUtilities {

    @SuppressLint("NonConstantResourceId")
    public static int defineSelectedCategory(MenuItem menuItem, Context context) {
        switch (menuItem.getItemId()) {
            case R.id.category_books:
                makeToastForCategory("Books", context);
                return 10;
            case R.id.category_films:
                makeToastForCategory("Films", context);
                return 11;
            case R.id.category_music:
                makeToastForCategory(" Music", context);
                return 12;
            case R.id.category_musicals_and_theatres:
                makeToastForCategory("Musicals and theatres", context);
                return 13;
            case R.id.category_television:
                makeToastForCategory("Television", context);
                return 14;
            case R.id.category_video_games:
                makeToastForCategory("Video games", context);
                return 15;
            case R.id.category_board_games:
                makeToastForCategory("Board games", context);
                return 16;
            case R.id.category_science_and_nature:
                makeToastForCategory("Science and nature", context);
                return 17;
            case R.id.category_computers:
                makeToastForCategory("Computers", context);
                return 18;
            case R.id.category_mathematics:
                makeToastForCategory("Mathematics",context);
                return 19;
            case R.id.category_mythology:
                makeToastForCategory("Mythology" ,context);
                return 20;
            case R.id.category_sports:
                makeToastForCategory("Sports" ,context);
                return 21;
            case R.id.category_geography:
                makeToastForCategory("Geography" ,context);
                return 22;
            case R.id.category_history:
                makeToastForCategory("History" ,context);
                return 23;
            case R.id.category_politics:
                makeToastForCategory("Politics" ,context);
                return 24;
            case R.id.category_art:
                makeToastForCategory("Art" ,context);
                return 25;
            case R.id.category_celebrities:
                makeToastForCategory("Celebrities" ,context);
                return 26;
            case R.id.category_animals:
                makeToastForCategory("Animals" ,context);
                return 27;
            case R.id.category_vehicles:
                makeToastForCategory("Vehicles" ,context);
                return 28;
            case R.id.category_comics:
                makeToastForCategory("Comics",context);
                return 29;
            case R.id.category_gadgets:
                makeToastForCategory("Gadgets" ,context);
                return 30;
            case R.id.category_japanese_anime_and_manga:
                makeToastForCategory("Anime and Mange" ,context);
                return 31;
            case R.id.category_cartoons_and_animations:
                makeToastForCategory("Cartoons and Animations" ,context);
                return 32;
            default:
                makeToastForCategory("General Knowledge" ,context);
                return 9;
        }
    }

    private static void makeToastForCategory(String category, Context context) {
        Toast.makeText(context, "The next question will be category: " + category, Toast.LENGTH_SHORT).show();
    }
}
