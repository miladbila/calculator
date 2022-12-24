package com.example.calculatorproject;

import java.util.Stack;

public class Calculate {
    public static String equation = "";

    public static double calculate() {
        String postFix = infixToPostfix(equation);
        Stack<String> stack = new Stack<>();
        double x, y;
        String result = "";
        String choice;
        double value;
        String p = "";
        String[] split = postFix.split(" ");
        for (String temp : split) {
            if (!temp.equals("+") && !temp.equals("-")
                    && !temp.equals("*") && !temp.equals("/") && !temp.equals("^")) {
                stack.push(temp);
                continue;
            } else {
                choice = temp;
            }
            switch (choice) {
                case "+" -> {
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                }
                case "-" -> {
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                }
                case "*" -> {
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                }
                case "/" -> {
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                }
                case "^" -> {
                    x = Double.parseDouble(stack.pop());
                    y = Double.parseDouble(stack.pop());
                    value = Math.pow(y, x);
                    result = p + value;
                    stack.push(result);
                }
            }
        }
        return Double.parseDouble(result);
    }

    static int Prec(String ch) {
        return switch (ch) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

    static String infixToPostfix(String equation) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] split = equation.split(" ");
        for (String c : split)
            if (!(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^") || c.equals("(") || c.equals(")"))) {
                result.append(" ");
                result.append(c);
            } else if (c.equals("("))
                stack.push(c);
            else if (c.equals(")")) {
                while (!stack.isEmpty()
                        && !stack.peek().equals("(")) {
                    result.append(" ");
                    result.append(stack.peek());
                    stack.pop();
                }

                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {
                    result.append(" ");
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        while (!stack.isEmpty()) {
            result.append(" ");
            result.append(stack.peek());
            stack.pop();
        }
        return result.toString();
    }
}
