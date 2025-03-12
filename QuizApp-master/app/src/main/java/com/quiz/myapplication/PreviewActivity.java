package com.quiz.myapplication;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        LinearLayout container = findViewById(R.id.previewContainer);

        // Get the examDetails JSON string from the Intent
        String examDetailsJson = getIntent().getStringExtra("examDetails");

        try {
            JSONObject examDetails = new JSONObject(examDetailsJson);
            JSONArray answeredQuestions = examDetails.getJSONArray("answeredQuestions");

            for (int i = 0; i < answeredQuestions.length(); i++) {
                JSONObject question = answeredQuestions.getJSONObject(i);

                CardView cardView = new CardView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(10, 10, 10, 10);
                cardView.setLayoutParams(layoutParams);
                cardView.setRadius(16);
                cardView.setCardElevation(10);
                cardView.setCardBackgroundColor(getResources().getColor(R.color.cardBackground));

                LinearLayout contentLayout = new LinearLayout(this);
                contentLayout.setOrientation(LinearLayout.VERTICAL);
                contentLayout.setPadding(16, 16, 16, 16);

                TextView questionText = new TextView(this);
                questionText.setText("Q" + (i + 1) + ": " + question.getString("question"));
                questionText.setTextColor(getResources().getColor(R.color.primaryText));
                questionText.setTextSize(18);
                contentLayout.addView(questionText);

                JSONArray options = question.getJSONArray("options");
                String correctAnswer = question.getString("correctAnswer");
                String yourAnswer = question.getString("yourAnswer");

                for (int j = 0; j < options.length(); j++) {
                    TextView optionView = new TextView(this);
                    String optionText = options.getString(j);
                    optionView.setText((j + 1) + ". " + optionText);
                    optionView.setTextSize(16);
                    optionView.setPadding(0, 10, 0, 10);

                    // Set the color based on correct or selected answer
                    if (optionText.equals(correctAnswer)) {
                        optionView.setTextColor(getResources().getColor(R.color.correctAnswer));
                    } else if (optionText.equals(yourAnswer)) {
                        optionView.setTextColor(getResources().getColor(R.color.selectedAnswer));
                    } else {
                        optionView.setTextColor(getResources().getColor(R.color.defaultAnswer));
                    }
                    contentLayout.addView(optionView);
                }

                cardView.addView(contentLayout);
                container.addView(cardView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
