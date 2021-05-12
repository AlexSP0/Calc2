package com.example.calc2;

import java.io.Serializable;

public class Calculator implements Serializable {
    private StringBuffer currentString;
    private StringBuffer nextString;
    char currentOperation;

    public Calculator() {
        currentString = new StringBuffer("0");
        nextString = new StringBuffer();
    }
    public void appendOperation(char op) {
        switch (op){
            case '+':
            case '-':
            case '*':
            case '/':
                nextString.setLength(0);
                nextString.append(currentString.toString());
                currentString.setLength(0);
                currentOperation = op;
                break;
            case 'c':
                double result;
                switch (currentOperation) {
                    case '+':
                        result = Double.parseDouble(nextString.toString()) + Double.parseDouble(currentString.toString());
                        currentString.setLength(0);
                        nextString.setLength(0);
                        currentString.append(result);
                        break;
                    case '-':
                        result = Double.parseDouble(nextString.toString()) - Double.parseDouble(currentString.toString());
                        currentString.setLength(0);
                        nextString.setLength(0);
                        currentString.append(result);
                        break;
                    case '*':
                        result = Double.parseDouble(nextString.toString()) * Double.parseDouble(currentString.toString());
                        currentString.setLength(0);
                        nextString.setLength(0);
                        currentString.append(result);
                        break;
                    case '/':
                        result = Double.parseDouble(nextString.toString()) / Double.parseDouble(currentString.toString());
                        currentString.setLength(0);
                        nextString.setLength(0);
                        currentString.append(result);
                        break;
                }
                break;
            case 'd':
                currentString.setLength(0);
                nextString.setLength(0);
                break;
        }
    }
    public void appendNumber(char num) {
        switch (num) {
            case '0':
                currentString.append('0');
                break;
            case '1':
                currentString.append('1');
                break;
            case '2':
                currentString.append('2');
                break;
            case '3':
                currentString.append('3');
                break;
            case '4':
                currentString.append('4');
                break;
            case '5':
                currentString.append('5');
                break;
            case '6':
                currentString.append('6');
                break;
            case '7':
                currentString.append('7');
                break;
            case '8':
                currentString.append('8');
                break;
            case '9':
                currentString.append('9');
                break;
            case '.':
                currentString.append('.');
                break;
        }
    }
    public String getCurrentString() {
        return currentString.toString();
    }

    public String getNextString() {
        return nextString.toString();
    }
}
