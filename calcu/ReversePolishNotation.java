package calculator;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class ReversePolishNotation {

    private String infix;
    private String postfix;


    public ReversePolishNotation(String expression) {

        if (orCorrectBracket(expression)) {
            this.infix = expression;
            this.postfix = "";
        } else {

            Scanner in = new Scanner(System.in);
            System.out.println("Podałeś nieprawidłowe wyrażenie, podaj jeszcze raz: ");
            expression = in.nextLine();

            while (!orCorrectBracket(expression)) {
                this.infix = expression;
                this.postfix = "";
            }

        }
        infixToPostfix();
    }


    private void infixToPostfix() {
        Stack<String> stack = new Stack<String>();
        StringTokenizer st = new StringTokenizer(infix, "+-*/()", true);


        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")) {

                while (!stack.empty() && priority(stack.peek()) >= priority(s))
                    postfix += stack.pop() + " ";

                stack.push(s);
            } else if (s.equals("(")) stack.push(s);

            else if (s.equals(")")) {

                while (!stack.peek().equals("(")) postfix += stack.pop() + " ";

                stack.pop();
            } else postfix += s + " ";
        }

        while (!stack.empty()) postfix += stack.pop() + " ";
    }


    public static int priority(String operator) {

        if (operator.equals("+") || operator.equals("-")) return 1;

        else if (operator.equals("*") || operator.equals("/")) return 2;

        else return 0;
    }

    private boolean orCorrectBracket(String expression) {
        Stack<String> stack = new Stack<String>();
        StringTokenizer st = new StringTokenizer(expression, "()", true);

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.equals("(")) stack.push(s);

            if (s.equals(")")) {
                if (stack.isEmpty()) return false;
                if (!stack.pop().equals("(")) return false;
            }
        }

        return stack.isEmpty();
    }


    public String toString() {
        return postfix;
    }
}

