package com.calculator.simplecaculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String currentInput = "";
    private String lastOperator = "";
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);

        // Number Buttons
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonDot = findViewById(R.id.button_dot);

        // Operator Buttons
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMultiply = findViewById(R.id.button_multiply);
        Button buttonDivide = findViewById(R.id.button_divide);
        Button buttonRoot = findViewById(R.id.button_root);
        Button buttonRemainder = findViewById(R.id.button_remainder); // Add remainder button

        // Action Buttons
        Button buttonClear = findViewById(R.id.button_clear);
        Button buttonDelete = findViewById(R.id.button_delete);
        Button buttonEquals = findViewById(R.id.button_equals);

        // Set Click Listeners for Numbers
        button0.setOnClickListener(v -> appendToDisplay("0"));
        button1.setOnClickListener(v -> appendToDisplay("1"));
        button2.setOnClickListener(v -> appendToDisplay("2"));
        button3.setOnClickListener(v -> appendToDisplay("3"));
        button4.setOnClickListener(v -> appendToDisplay("4"));
        button5.setOnClickListener(v -> appendToDisplay("5"));
        button6.setOnClickListener(v -> appendToDisplay("6"));
        button7.setOnClickListener(v -> appendToDisplay("7"));
        button8.setOnClickListener(v -> appendToDisplay("8"));
        button9.setOnClickListener(v -> appendToDisplay("9"));
        buttonDot.setOnClickListener(v -> appendToDisplay("."));

        // Set Click Listeners for Operators
        buttonPlus.setOnClickListener(v -> setOperator("+"));
        buttonMinus.setOnClickListener(v -> setOperator("-"));
        buttonMultiply.setOnClickListener(v -> setOperator("×"));
        buttonDivide.setOnClickListener(v -> setOperator("÷"));
        buttonRoot.setOnClickListener(v -> calculateRoot());
        buttonRemainder.setOnClickListener(v -> setOperator("%")); // Set remainder operator

        // Clear Button
        buttonClear.setOnClickListener(v -> clearDisplay());

        // Delete Button
        buttonDelete.setOnClickListener(v -> deleteLastCharacter());

        // Equals Button
        buttonEquals.setOnClickListener(v -> calculateResult());
    }

    // Append number to display
    private void appendToDisplay(String value) {
        currentInput += value;
        display.setText(currentInput);
    }

    // Set operator
    private void setOperator(String operator) {
        if (!currentInput.isEmpty()) {
            if (!lastOperator.isEmpty()) {
                calculateResult();
            }
            result = Double.parseDouble(currentInput);
            lastOperator = operator;
            currentInput = "";
        }
    }

    // Clear the display
    private void clearDisplay() {
        currentInput = "";
        result = 0;
        lastOperator = "";
        display.setText("");
    }

    // Delete the last character
    private void deleteLastCharacter() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            display.setText(currentInput);
        }
    }

    // Calculate result for Root (√)
    private void calculateRoot() {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput);
            display.setText(String.valueOf(Math.sqrt(value)));
        }
    }


    // Calculate result
    private void calculateResult() {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput);
            switch (lastOperator) {
                case "+":
                    result += value;
                    break;
                case "-":
                    result -= value;
                    break;
                case "×":
                    result *= value;
                    break;
                case "÷":
                    if (value != 0) {
                        result /= value;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
                case "%":  // Remainder calculation
                    result = result % value;
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            lastOperator = "";
        }
    }
}
