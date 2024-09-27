package com.example.assignment01_quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizApp extends AppCompatActivity {
    Button btnPrev, btnShowAnswer, btnEndQuiz, btnNext;
    TextView tvQuestion, tvScore, tvTimer;
    RadioButton option1, option2, option3, option4;
    RadioGroup optionsGroup;

    String[] questions;
    String[][] options;
    int[] answers;

    int currentIndex = 0;
    int score = 0;
    int timeLeft = 180000;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);
        optionsGroup = findViewById(R.id.option_group);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnShowAnswer = findViewById(R.id.btn_show_answer);
        btnEndQuiz = findViewById(R.id.btn_end_quiz);
        tvScore = findViewById(R.id.scoreBoard);
        tvTimer = findViewById(R.id.timer);
        tvQuestion = (TextView)findViewById(R.id.question_textView);

        questions = getResources().getStringArray(R.array.questions);
        options = new String[][]{
                getResources().getStringArray(R.array.options1),
                getResources().getStringArray(R.array.options2),
                getResources().getStringArray(R.array.options3),
                getResources().getStringArray(R.array.options4),
                getResources().getStringArray(R.array.options5),
                getResources().getStringArray(R.array.options6),
                getResources().getStringArray(R.array.options7),
                getResources().getStringArray(R.array.options8),
                getResources().getStringArray(R.array.options9),
                getResources().getStringArray(R.array.options10),
                getResources().getStringArray(R.array.options11),
                getResources().getStringArray(R.array.options12),
                getResources().getStringArray(R.array.options13),
                getResources().getStringArray(R.array.options14),
                getResources().getStringArray(R.array.options15),
                getResources().getStringArray(R.array.options16),
                getResources().getStringArray(R.array.options17),
                getResources().getStringArray(R.array.options18),
                getResources().getStringArray(R.array.options19),
                getResources().getStringArray(R.array.options20)
        };
        answers = getResources().getIntArray(R.array.answers);

        startTimer();

        setNextQuestion();

        btnPrev.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                setNextQuestion();
            }
        });

        btnNext.setOnClickListener(view -> {
            int selectedId = optionsGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(QuizApp.this, "Please select an option", Toast.LENGTH_SHORT).show();
            } else {
                int selectedIndex = optionsGroup.indexOfChild(findViewById(selectedId));

                if (selectedIndex == answers[currentIndex]) {
                    score += 5;
                    Toast.makeText(QuizApp.this, "Correct! +5 points", Toast.LENGTH_SHORT).show();
                } else {
                    score -= 1;
                    Toast.makeText(QuizApp.this, "Wrong! -1 point", Toast.LENGTH_SHORT).show();
                }

                tvScore.setText("Score: " + score);

                currentIndex++;
                if (currentIndex >= questions.length) {
                    endExam();
                } else {
                    setNextQuestion();
                }
            }
        });

        btnShowAnswer.setOnClickListener(v -> {
            Toast.makeText(QuizApp.this, "Correct Answer: " + options[currentIndex][answers[currentIndex]], Toast.LENGTH_SHORT).show();
            score -= 1;
            tvScore.setText("Score: " + score);
        });

        btnEndQuiz.setOnClickListener(v -> endExam());
    }

    private void setNextQuestion() {
        if (currentIndex < questions.length) {
            tvQuestion.setText(questions[currentIndex]);
            option1.setText(options[currentIndex][0]);
            option2.setText(options[currentIndex][1]);
            option3.setText(options[currentIndex][2]);
            option4.setText(options[currentIndex][3]);


            // Clear previous selection
            optionsGroup.clearCheck();
        } else {
            endExam();
        }


    }


    private void startTimer() {
        timer = new CountDownTimer(timeLeft, 1000) {
            public void onTick(long millisUntilFinished) {
                timeLeft = (int) millisUntilFinished; // Update timeLeft in every tick
                tvTimer.setText("Time Left: " + (millisUntilFinished / 60000) + " min " + (millisUntilFinished % 60000) / 1000 + " sec");
            }

            public void onFinish() {
                endExam();
            }
        }.start();
    }


    private void endExam() {
        timer.cancel();
        // Calculate the time elapsed
        //int totalTime = 120000; // 2 minutes in milliseconds
        //int timeSpent = (totalTime - timeLeft)/1000;

        // Create an intent to start ResultActivity
        Intent intent = new Intent(QuizApp.this, QuizResult.class);

        // Pass the score to the new activity
        intent.putExtra("finalScore", score);
        //intent.putExtra("timeElapsed", timeSpent);

        // Start the ResultActivity
        startActivity(intent);

        finish();
    }

}