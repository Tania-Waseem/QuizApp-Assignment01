package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//the filename and the classname do no need to be same
    Button btnTrue, btnFalse, btnNext;
    TextView tvQuestion;

    Question [] question_bank = new Question []{
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, true),
            new Question(R.string.question4, false)
    };

    int currentIndex = 0;

    public void setNextQuestion(){
        int q = question_bank[currentIndex].getQuestion();
        tvQuestion.setText(q);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTrue = (Button)findViewById(R.id.btnTrue);
        btnFalse = (Button)findViewById(R.id.btnFalse);
        btnNext = (Button)findViewById(R.id.btnNext);
        tvQuestion = (TextView)findViewById(R.id.question_textView);


        setNextQuestion();
        //or we can make a function above before the @Override

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                Toast.makeText(MainActivity.this, "Button is clicked", Toast.LENGTH_LONG).show();

            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                Toast.makeText(MainActivity.this, "Button is clicked", Toast.LENGTH_LONG).show();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button is clicked", Toast.LENGTH_LONG).show();
                moveToNextQuestion();

            }
        });
        //takes an object of OnClick listener. An abstract class/interface
    }

    // Method to check if the selected answer is correct
    private void checkAnswer(boolean userSelectedAnswer) {
        boolean correctAnswer = question_bank[currentIndex].isCorrectAnswer();

        if (userSelectedAnswer == correctAnswer) {
            Toast.makeText(MainActivity.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            moveToNextQuestion();  // Automatically move to the next question if correct
        } else {
            Toast.makeText(MainActivity.this, "Wrong Answer! Try Again.", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to move to the next question
    private void moveToNextQuestion() {
        currentIndex++;
        if (currentIndex >= question_bank.length) {
            currentIndex = 0;  // Reset to the first question if the end is reached
        }
        setNextQuestion();  // Update the displayed question
    }
}