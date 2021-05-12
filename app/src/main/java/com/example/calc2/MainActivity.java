package com.example.calc2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String CALCULATOR_STATE = "state";
    private TextView currentTextView;
    private TextView nextTextView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiple;
    private Button buttonDivide;
    private Button buttonDot;
    private Button buttonCalc;
    private  Button buttonClear;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initResources();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CALCULATOR_STATE, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            calculator = (Calculator) savedInstanceState.getSerializable(CALCULATOR_STATE);
            updateNumbers();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                calculator.appendNumber('0');
                updateNumbers();
                break;
            case R.id.button1:
                calculator.appendNumber('1');
                updateNumbers();
                break;
            case R.id.button2:
                calculator.appendNumber('2');
                updateNumbers();
                break;
            case R.id.button3:
                calculator.appendNumber('3');
                updateNumbers();
                break;
            case R.id.button4:
                calculator.appendNumber('4');
                updateNumbers();
                break;
            case R.id.button5:
                calculator.appendNumber('5');
                updateNumbers();
                break;
            case R.id.button6:
                calculator.appendNumber('6');
                updateNumbers();
                break;
            case R.id.button7:
                calculator.appendNumber('7');
                updateNumbers();
                break;
            case R.id.button8:
                calculator.appendNumber('8');
                updateNumbers();
                break;
            case R.id.button9:
                calculator.appendNumber('9');
                updateNumbers();
                break;
            case R.id.buttonPlus:
                calculator.appendOperation('+');
                updateNumbers();
                break;
            case R.id.buttonMinus:
                calculator.appendOperation('-');
                updateNumbers();
                break;
            case R.id.buttonMultiple:
                calculator.appendOperation('*');
                updateNumbers();
                break;
            case R.id.buttonDivide:
                calculator.appendOperation('/');
                updateNumbers();
                break;
            case R.id.buttonDot:
                calculator.appendNumber('.');
                updateNumbers();
                break;
            case R.id.buttonCalc:
                calculator.appendOperation('c');
                updateNumbers();
                break;
            case R.id.buttonClear:
                calculator.appendOperation('d');
                updateNumbers();
                break;
        }
    }
    private void updateNumbers() {
        currentTextView.setText(calculator.getCurrentString());
        nextTextView.setText(calculator.getNextString());
    }
    private void initResources() {
        currentTextView = findViewById(R.id.textViewCurrent);
        nextTextView = findViewById(R.id.textViewNext);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiple = findViewById(R.id.buttonMultiple);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDot = findViewById(R.id.buttonDot);
        buttonCalc = findViewById(R.id.buttonCalc);
        buttonClear = findViewById(R.id.buttonClear);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiple.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonCalc.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        calculator = new Calculator();
    }
}