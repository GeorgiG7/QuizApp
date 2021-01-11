package com.example.quizapp.view.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.model.database.Score;
import com.example.quizapp.model.database.ScoreDbService;

import java.util.ArrayList;
import java.util.List;

public class ScoresAdapter extends RecyclerView.Adapter<ScoresAdapter.ViewHolder> {

    private List<Score> scores = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.score.setText(Integer.toString(scores.get(position).getResult()));
        holder.date.setText(scores.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView scoreText;
        private TextView score;
        private TextView dateText;
        private TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            scoreText = itemView.findViewById(R.id.score_text);
            score = itemView.findViewById(R.id.score);
            dateText = itemView.findViewById(R.id.date_text);
            date = itemView.findViewById(R.id.date);
        }
    }
}
