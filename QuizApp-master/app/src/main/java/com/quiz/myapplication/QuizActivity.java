package com.quiz.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.os.CountDownTimer;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "QuizAppPrefs";
    private ArrayList<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private TextView questionTextView;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private TextView timerTextView;  // Timer TextView
    private CountDownTimer countDownTimer; // CountDownTimer object

    private JSONArray answeredQuestions = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        try {
            questions = QuestionBank.getQuestions();
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error loading questions!");
        }

        questionTextView = findViewById(R.id.tv_question);
        optionsGroup = findViewById(R.id.options_group);
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);
        Button nextButton = findViewById(R.id.btn_next);
        timerTextView = findViewById(R.id.tv_timer);  // Timer TextView

        loadQuestion();

        // Start the countdown timer for 20 minutes (1200 seconds)
        startTimer();

        nextButton.setOnClickListener(v -> {
            try {
                int selectedOptionId = optionsGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedOptionId);
                    String selectedAnswer = selectedRadioButton.getText().toString();
                    Question currentQuestion = questions.get(currentQuestionIndex);

                    // Record the answer
                    JSONObject answeredQuestion = new JSONObject();
                    try {
                        answeredQuestion.put("question", currentQuestion.getQuestionText());
                        answeredQuestion.put("yourAnswer", selectedAnswer);
                        answeredQuestion.put("correctAnswer", currentQuestion.getOptions()[currentQuestion.getCorrectAnswerIndex()]);
                        answeredQuestion.put("options", new JSONArray(currentQuestion.getOptions()));
                        answeredQuestions.put(answeredQuestion);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        showError("Error saving answer!");
                    }

                    if (selectedAnswer.equals(currentQuestion.getOptions()[currentQuestion.getCorrectAnswerIndex()])) {
                        score++;
                    }

                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.size()) {
                        loadQuestion();
                    } else {
                        saveResults();
                        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                        intent.putExtra("score", score);
                        intent.putExtra("totalQuestions", questions.size());
                        startActivity(intent);
                        finish();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                showError("Error processing the answer!");
            }
        });
    }

    private void loadQuestion() {
        try {
            Question question = questions.get(currentQuestionIndex);
            questionTextView.setText(question.getQuestionText());
            option1.setText(question.getOptions()[0]);
            option2.setText(question.getOptions()[1]);
            option3.setText(question.getOptions()[2]);
            option4.setText(question.getOptions()[3]);
            optionsGroup.clearCheck();
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error loading question!");
        }
    }

    private void startTimer() {
        try {
            // 20 minutes = 1200 seconds
            countDownTimer = new CountDownTimer(1200000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Format the remaining time in minutes:seconds format
                    int minutes = (int) (millisUntilFinished / 60000);
                    int seconds = (int) (millisUntilFinished % 60000 / 1000);
                    timerTextView.setText(String.format("%02d:%02d", minutes, seconds));
                }

                @Override
                public void onFinish() {
                    // Timer is finished, save the result and navigate to the ResultActivity
                    saveResults();
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("totalQuestions", questions.size());
                    startActivity(intent);
                    finish();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error starting the timer!");
        }
    }

    private void saveResults() {
        try {
            SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            // Retrieve existing exam history from SharedPreferences
            String examHistoryString = prefs.getString("ExamHistory", "[]");
            JSONArray examHistory;
            try {
                examHistory = new JSONArray(examHistoryString);  // Parse existing history
            } catch (JSONException e) {
                e.printStackTrace();
                examHistory = new JSONArray();  // If no history, initialize empty JSONArray
            }

            // Create a new JSONObject for current exam details
            JSONObject examDetails = new JSONObject();
            try {
                examDetails.put("score", score);
                examDetails.put("totalQuestions", questions.size());
                examDetails.put("answeredQuestions", answeredQuestions);
            } catch (JSONException e) {
                e.printStackTrace();
                showError("Error saving exam details!");
            }

            // Add new exam details to exam history
            examHistory.put(examDetails);

            // Save the updated exam history to SharedPreferences
            editor.putString("ExamHistory", examHistory.toString());
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error saving results!");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the timer if the activity is destroyed
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void showError(String errorMessage) {
        // Handle error by showing a toast or dialog
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }
}
