package com.quiz.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserHistoryActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "QuizAppPrefs";
    private ArrayList<String> historyTitles = new ArrayList<>();
    private JSONArray examHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);

        ListView historyListView = findViewById(R.id.historyListView);

        // Retrieve Exam History from SharedPreferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String examHistoryString = prefs.getString("ExamHistory", "[]");

        try {
            examHistory = new JSONArray(examHistoryString);

            // Populate titles for each exam
            for (int i = 0; i < examHistory.length(); i++) {
                JSONObject exam = examHistory.getJSONObject(i);
                int score = exam.getInt("score");
                int totalQuestions = exam.getInt("totalQuestions");
                historyTitles.add("Exam " + (i + 1) + " - Score: " + score + "/" + totalQuestions);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Set up the ListView with an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historyTitles);
        historyListView.setAdapter(adapter);

        // Set an item click listener to open the selected exam's details
        historyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    // Get the selected exam details
                    JSONObject selectedExam = examHistory.getJSONObject(position);

                    // Pass the details to PreviewActivity
                    Intent intent = new Intent(UserHistoryActivity.this, PreviewActivity.class);
                    intent.putExtra("examDetails", selectedExam.toString());
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(UserHistoryActivity.this, "Error loading history", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
