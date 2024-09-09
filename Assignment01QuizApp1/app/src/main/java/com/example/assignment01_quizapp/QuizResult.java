package com.example.assignment01_quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResult extends AppCompatActivity {

    Button btnRetry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        TextView tvFinalScore = findViewById(R.id.tvFinalScore);
        TextView tvPercentage = findViewById(R.id.tvPercentage);
        TextView tvCorrectAnswers = findViewById(R.id.tvCorrectAnswers);
        //TextView tvTime = findViewById(R.id.tvTime);
        TextView tvTotalQuestions = findViewById(R.id.tvTotalQuestions);
        btnRetry = (Button)findViewById(R.id.btn_retry);


        int score = getIntent().getIntExtra("finalScore", 0); // Default value is 0 if no extra found
        //int timeInMillis = getIntent().getIntExtra("timeSpent", 0); // Time in milliseconds

        tvFinalScore.setText("Your Score: " + score);

        // Calculate the number of correct answers assuming 5 points per correct answer
        int correctAnswers = score / 5;
        tvCorrectAnswers.setText("Correct Answers: " + correctAnswers);

        int totalQuestions = 20;
        float percentage = ((float) correctAnswers / totalQuestions) * 100;
        tvPercentage.setText(String.format("Percentage: %.2f%%", percentage));

        //int minutes = timeInMillis / 60000;
        //int seconds = (timeInMillis % 60000) / 1000;
        //tvTime.setText("Time Spent: " + minutes + " min " + seconds + " sec");

        tvTotalQuestions.setText("Total Questions: " + 20);

        btnRetry.setOnClickListener(v -> {
            Intent intent = new Intent(QuizResult.this, QuizApp.class);
            startActivity(intent);
        });

    }
}
