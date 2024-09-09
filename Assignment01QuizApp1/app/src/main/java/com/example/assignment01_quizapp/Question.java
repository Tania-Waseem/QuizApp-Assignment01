package com.example.assignment01_quizapp;

public class Question {
    int Question;
    boolean correctAnswer;

    public Question(int q, boolean ans){
        this.Question = q;
        this.correctAnswer = ans;
    }

    public void setQuestion(int question) {
        Question = question;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getQuestion() {
        return Question;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }
}
