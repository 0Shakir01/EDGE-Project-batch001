package com.quiz.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "QuizAppPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.tv_result);
        Button previewButton = findViewById(R.id.btn_preview);
        Button restartButton = findViewById(R.id.btn_restart);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String examHistoryJson = prefs.getString("ExamHistory", "[]");

        try {
            JSONArray examHistory = new JSONArray(examHistoryJson);
            if (examHistory.length() > 0) {
                // Get the last exam's details (latest exam result)
                JSONObject latestExam = examHistory.getJSONObject(examHistory.length() - 1);
                int score = latestExam.getInt("score");
                int totalQuestions = latestExam.getInt("totalQuestions");
                resultTextView.setText("Your Score: " + score + " / " + totalQuestions);
            } else {
                resultTextView.setText("No exam history available.");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Preview button action to show the current exam's preview
        previewButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, CurrentExamPreviewActivity.class);
            intent.putExtra("examHistory", examHistoryJson);  // Pass the exam history to preview
            startActivity(intent);
        });

        // Restart button action to restart the quiz
        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
