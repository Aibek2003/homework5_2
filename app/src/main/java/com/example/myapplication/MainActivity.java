package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Integer firstNumber;
    Integer secondNumber;
    boolean isOperation;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                result.setText("");
            }
            result.append(text);
            isOperation = false;
        }
    }

    public void operationClick(View view) {
        int id = view.getId();
        if (id == R.id.clearBtn) {
            result.setText("");
            firstNumber = null;
            secondNumber = null;
            operation = null;
            isOperation = false;
        } else if (id == R.id.plusBtn || id == R.id.minusBtn || id == R.id.divideBtn || id == R.id.multiplyBtn) {
            firstNumber = Integer.valueOf(result.getText().toString());
            isOperation = true;
            operation = ((MaterialButton) view).getText().toString();
        } else if (id == R.id.equalBtn) {
            if (firstNumber != null && operation != null) {
                secondNumber = Integer.valueOf(result.getText().toString());
                Integer resultOfValues = 0;
                switch (operation) {
                    case "+":
                        resultOfValues = firstNumber + secondNumber;
                        break;
                    case "-":
                        resultOfValues = firstNumber - secondNumber;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            result.setText("Error");
                            return;
                        } else {
                            resultOfValues = firstNumber / secondNumber;
                        }
                        break;
                    case "*":
                        resultOfValues = firstNumber * secondNumber;
                        break;
                }
                result.setText(String.valueOf(resultOfValues));
                firstNumber = resultOfValues;
                isOperation = false;
            }
        }
    }
}
