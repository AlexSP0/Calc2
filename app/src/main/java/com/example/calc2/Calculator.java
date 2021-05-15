package com.example.calc2;

import java.io.Serializable;

public class Calculator implements Serializable {
    private StringBuffer currentString;
    private StringBuffer nextString;
    char currentOperation;

    public Calculator() {
        currentString = new StringBuffer("0");
        nextString = new StringBuffer(" ");
    }

    public void appendOperation(char op) {

        if(op == 'c') {
            calculate(Double.parseDouble(nextString.toString()),Double.parseDouble(currentString.toString()), currentOperation);
        }
        if(op == 'd')  clearNum(); else {
            currentOperation = op;
            nextString.setLength(0);
            nextString.append(currentString.toString());
            currentString.setLength(0);
        }
    }

    public void appendNumber(char num) {
        currentString.append(num);
    }

    public String getCurrentString() {
        return currentString.toString();
    }

    public String getNextString() {
        return nextString.toString();
    }

    private int findChar(char c, String str) {
        return str.indexOf(c);
    }

    private double calculate(double a, double b, char currentOperation) {
        switch (currentOperation) {
            case '/':
                if(b!=0) update(a/b);
                break;
            case '+':
                update(a+b);
                break;
            case '-':
                update(a-b);
                break;
            case '*':
                update(a*b);
                break;
        }
        return 0;
    }

    private void update(double result) {
        currentString.setLength(0);
        nextString.setLength(0);
        currentString.append(result);
    }

    private void clearNum() {
        currentString.setLength(0);
        nextString.setLength(0);
    }
}
