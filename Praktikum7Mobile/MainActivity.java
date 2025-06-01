package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    String input = "", operator = "";
    double num1 = 0, num2 = 0;
    boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        int[] btnIDs = {
                R.id.gridButtons
        };

        GridLayout grid = findViewById(R.id.gridButtons);
        for (int i = 0; i < grid.getChildCount(); i++) {
            Button btn = (Button) grid.getChildAt(i);
            btn.setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View v) {
        Button btn = (Button) v;
        String text = btn.getText().toString();

        switch (text) {
            case "C":
                input = "";
                operator = "";
                num1 = num2 = 0;
                isOperatorPressed = false;
                tvResult.setText("0");
                break;
            case "=":
                if (!operator.isEmpty() && !input.isEmpty()) {
                    num2 = Double.parseDouble(input);
                    double result = 0;
                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "−": result = num1 - num2; break;
                        case "×": result = num1 * num2; break;
                        case "÷":
                            if (num2 == 0) {
                                tvResult.setText("Error");
                                return;
                            }
                            result = num1 / num2; break;
                    }
                    tvResult.setText(String.valueOf(result));
                    input = String.valueOf(result);
                    operator = "";
                    isOperatorPressed = false;
                }
                break;
            case "+": case "−": case "×": case "÷":
                if (!input.isEmpty()) {
                    num1 = Double.parseDouble(input);
                    operator = text;
                    input = "";
                    isOperatorPressed = true;
                }
                break;
            default:
                input += text;
                tvResult.setText(input);
                break;
        }
    }
}
