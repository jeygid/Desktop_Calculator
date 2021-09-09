package calculator;

import java.util.Stack;

public class Postfix {

    /** Found this resources helpful:
     * https://habr.com/ru/post/489744/
     * https://www.free-online-calculator-use.com/infix-to-postfix-converter.html
     * https://www.free-online-calculator-use.com/postfix-evaluator.html
     */

    public String getPostfix(String expression) {

        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            String character = expression.substring(i, i + 1);

            // Checking numbers
            if (character.matches("[0-9.]")) {

                result.append(character);

                if (i == expression.length() - 1) {
                    result.append(" ");
                } else if (!expression.substring(i + 1, i + 2).matches("[0-9.]")) {
                    result.append(" ");
                }

            // Checking signs
            } else if (character.matches("[+÷×-]")) {

                switch (character) {

                    case "+":
                    case "-":

                        if (stack.isEmpty()) {

                            stack.push(character);

                        } else {

                            while (!stack.isEmpty()) {
                                result.append(stack.pop()).append(" ");
                            }

                            stack.push(character);
                        }

                        break;

                    case "÷":
                    case "×":

                        if (stack.isEmpty() || stack.peek().equals("+") || stack.peek().equals("-")) {

                            stack.push(character);

                        } else if (!stack.isEmpty() && (stack.peek().equals("÷") || stack.peek().equals("×"))) {

                            while (!stack.isEmpty() && (stack.peek().equals("÷") || stack.peek().equals("×"))) {

                                result.append(stack.pop()).append(" ");

                            }

                            stack.push(character);
                        }

                        break;

                }

            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString();
    }

    public String evaluatePostfix(String expression) {

        Stack<String> stack = new Stack<>();

        for (String element : expression.split(" ")) {

            switch (element) {
                case "+":
                    double n2 = Double.parseDouble(stack.pop());
                    double n1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(n1 + n2));
                    break;
                case "-":
                    double n4 = Double.parseDouble(stack.pop());
                    double n3 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(n3 - n4));
                    break;
                case "×":
                    double n6 = Double.parseDouble(stack.pop());
                    double n5 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(n5 * n6));
                    break;
                case "÷":
                    double n8 = Double.parseDouble(stack.pop());
                    double n7 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(n7 / n8));
                    break;
                default:
                    stack.push(element);
                    break;


            }


        }


        return stack.pop();
    }
}
