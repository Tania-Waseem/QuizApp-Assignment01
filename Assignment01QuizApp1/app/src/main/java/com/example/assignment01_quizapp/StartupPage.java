package com.example.assignment01_quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartupPage extends AppCompatActivity {

    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_page);
        TextView welcome = findViewById(R.id.QuizApp);
        btnStart = (Button)findViewById(R.id.StartButton);


        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(StartupPage.this, QuizApp.class);
            startActivity(intent);
        });

    }
}