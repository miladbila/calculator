package com.example.calculatorproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelloController {
    private final StringBuilder number = new StringBuilder();
    private final StringBuilder equation = new StringBuilder();
    private int parenthesis = 0;
    @FXML
    private Text mainText;

    @FXML
    void closedParenthesisButtonClick(ActionEvent event) {
        if (equation.length() != 0)
            if (!(equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                    equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' || equation.charAt(equation.length() - 1) == '(') &&
                    parenthesis > 0) {
                equation.append(")");
                Calculate.equation.append(number);
                Calculate.equation.append(" ");
                Calculate.equation.append(")");
                Calculate.equation.append(" ");
                number.delete(0, number.length());
                parenthesis--;
                updateMainText(String.valueOf(equation));
            }
    }

    @FXML
    void deleteButtonClick(ActionEvent event) {
        equation.delete(0, equation.length());
        number.delete(0, number.length());
        Calculate.equation.delete(0, Calculate.equation.length());
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void divisionButtonClick(ActionEvent event) {
        if (!(equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' || equation.charAt(equation.length() - 1) == '(')) {
            equation.append("/");
            Calculate.equation.append(number);
            Calculate.equation.append(" ");
            number.delete(0, number.length());
            Calculate.equation.append("/");
            Calculate.equation.append(" ");
            updateMainText(String.valueOf(equation));
        }
    }

    @FXML
    void eightButtonClick(ActionEvent event) {
        equation.append("8");
        number.append("8");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void equalButtonClick(ActionEvent event) {
        Calculate.equation.append(number);
        Calculate.equation.append(" ");
        number.delete(0, number.length());
        equation.delete(0, equation.length());
        while (parenthesis > 0) {
            parenthesis--;
            Calculate.equation.append(")");
            Calculate.equation.append(" ");
        }
        double result = Calculate.calculate();
        updateMainText(String.valueOf(result));
        Calculate.equation.delete(0, Calculate.equation.length());
    }

    @FXML
    void fiveButtonClick(ActionEvent event) {
        equation.append("5");
        number.append("5");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void fourButtonClick(ActionEvent event) {
        equation.append("4");
        number.append("4");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void minusButtonClick(ActionEvent event) {
        if (!(equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' || equation.charAt(equation.length() - 1) == '(')) {
            equation.append("-");
            Calculate.equation.append(number);
            Calculate.equation.append(" ");
            number.delete(0, number.length());
            Calculate.equation.append("-");
            Calculate.equation.append(" ");
            updateMainText(String.valueOf(equation));
        }
    }

    @FXML
    void multiplicationButtonClick(ActionEvent event) {
        if (!(equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' || equation.charAt(equation.length() - 1) == '(')) {
            equation.append("*");
            Calculate.equation.append(number);
            Calculate.equation.append(" ");
            number.delete(0, number.length());
            Calculate.equation.append("*");
            Calculate.equation.append(" ");
            updateMainText(String.valueOf(equation));
        }
    }

    @FXML
    void nineButtonClick(ActionEvent event) {
        equation.append("9");
        number.append("9");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void oneButtonClick(ActionEvent event) {
        equation.append("1");
        number.append("1");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void openParenthesisButtonClick(ActionEvent event) {
        if (equation.length() != 0) {
            if (equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                    equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' && equation.charAt(equation.length() - 1) != ')') {
                equation.append("(");
                Calculate.equation.append("(");
                Calculate.equation.append(" ");
                number.delete(0, number.length());
                parenthesis++;
                updateMainText(String.valueOf(equation));
            }
        } else {
            equation.append("(");
            Calculate.equation.append("(");
            Calculate.equation.append(" ");
            parenthesis++;
            updateMainText(String.valueOf(equation));
        }

    }

    @FXML
    void plusButtonClick(ActionEvent event) {
        if (!(equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' || equation.charAt(equation.length() - 1) == '(')) {
            equation.append("+");
            Calculate.equation.append(number);
            Calculate.equation.append(" ");
            number.delete(0, number.length());
            Calculate.equation.append("+");
            Calculate.equation.append(" ");
            updateMainText(String.valueOf(equation));
        }
    }

    @FXML
    void powerButtonClick(ActionEvent event) {
        if (!(equation.charAt(equation.length() - 1) == '+' || equation.charAt(equation.length() - 1) == '-' || equation.charAt(equation.length() - 1) == '*' ||
                equation.charAt(equation.length() - 1) == '/' || equation.charAt(equation.length() - 1) == '^' || equation.charAt(equation.length() - 1) == '(')) {
            equation.append("^");
            Calculate.equation.append(number);
            Calculate.equation.append(" ");
            number.delete(0, number.length());
            Calculate.equation.append("^");
            Calculate.equation.append(" ");
            updateMainText(String.valueOf(equation));
        }

    }

    @FXML
    void sevenButtonClick(ActionEvent event) {
        equation.append("7");
        number.append("7");
        updateMainText(String.valueOf(equation));


    }

    @FXML
    void sixButtonClick(ActionEvent event) {
        equation.append("6");
        number.append("6");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void threeButtonClick(ActionEvent event) {
        equation.append("3");
        number.append("3");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void twoButtonClick(ActionEvent event) {
        equation.append("2");
        number.append("2");
        updateMainText(String.valueOf(equation));

    }

    @FXML
    void zeroButtonClick(ActionEvent event) {
        equation.append("0");
        number.append("0");
        updateMainText(String.valueOf(equation));
    }

    void updateMainText(String text) {
        mainText.setText(text);
    }

}
