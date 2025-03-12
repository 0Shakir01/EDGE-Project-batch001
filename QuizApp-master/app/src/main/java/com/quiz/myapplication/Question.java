package com.quiz.myapplication;

public class Question {
    private String subject;
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String subject, String questionText, String[] options, int correctAnswerIndex) {
        this.subject = subject;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getSubject() {
        return subject;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
