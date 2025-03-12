package com.quiz.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrentExamPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_exam_preview);

        LinearLayout container = findViewById(R.id.currentExamPreviewContainer);

        // Get the examHistory JSON string from the Intent
        String examHistoryJson = getIntent().getStringExtra("examHistory");

        try {
            JSONArray examHistory = new JSONArray(examHistoryJson);

            // Iterate through all questions in the latest exam
            JSONObject latestExam = examHistory.getJSONObject(examHistory.length() - 1);
            JSONArray answeredQuestions = latestExam.getJSONArray("answeredQuestions");

            for (int i = 0; i < answeredQuestions.length(); i++) {
                JSONObject question = answeredQuestions.getJSONObject(i);

                // Create a CardView for each question
                CardView cardView = new CardView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(16, 16, 16, 16);
                cardView.setLayoutParams(layoutParams);
                cardView.setRadius(16);
                cardView.setCardElevation(10);
                cardView.setCardBackgroundColor(getResources().getColor(R.color.cardBackground));

                // Create a LinearLayout inside the CardView
                LinearLayout contentLayout = new LinearLayout(this);
                contentLayout.setOrientation(LinearLayout.VERTICAL);
                contentLayout.setPadding(16, 16, 16, 16);

                // Add question text
                TextView questionText = new TextView(this);
                questionText.setText("Q" + (i + 1) + ": " + question.getString("question"));
                questionText.setTextColor(getResources().getColor(R.color.primaryText));
                questionText.setTextSize(18);
                contentLayout.addView(questionText);

                // Add options with styling
                JSONArray options = question.getJSONArray("options");
                String correctAnswer = question.getString("correctAnswer");
                String yourAnswer = question.getString("yourAnswer");

                for (int j = 0; j < options.length(); j++) {
                    TextView optionView = new TextView(this);
                    String optionText = options.getString(j);
                    optionView.setText((j + 1) + ". " + optionText);
                    optionView.setTextSize(16);
                    optionView.setPadding(0, 10, 0, 10);

                    // Set color for correct, selected, and default options
                    if (optionText.equals(correctAnswer)) {
                        optionView.setTextColor(getResources().getColor(R.color.correctAnswer));
                    } else if (optionText.equals(yourAnswer)) {
                        optionView.setTextColor(getResources().getColor(R.color.selectedAnswer));
                    } else {
                        optionView.setTextColor(getResources().getColor(R.color.defaultAnswer));
                    }
                    contentLayout.addView(optionView);
                }

                // Add content to the CardView
                cardView.addView(contentLayout);
                container.addView(cardView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
