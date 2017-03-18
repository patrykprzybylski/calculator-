package calculator;

import java.util.Stack;
import java.util.StringTokenizer;


public class Calculator {

    private String expression;

    public Calculator(String expression) {
        setExpression(expression);
    }



    public double calculateValue() {

        Stack<Double> stack = new Stack<Double>();
        StringTokenizer st = new StringTokenizer(expression, " ");


        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/")) {

                double wartosc = Double.parseDouble(s);

                stack.push(wartosc);
            } else {

                double value1 = stack.pop();
                double value2 = stack.pop();

                switch (s.charAt(0)) {
                    case '*': {
                        stack.push(value2 * value1);
                        break;
                    }
                    case '+': {
                        stack.push(value2 + value1);
                        break;
                    }
                    case '-': {
                        stack.push(value2 - value1);
                        break;
                    }
                    case '/': {
                        stack.push(value2 / value1);
                        break;
                    }
                }
            }
        }
       return stack.pop();
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
