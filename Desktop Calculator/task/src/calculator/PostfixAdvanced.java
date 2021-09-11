package calculator;

import java.util.Stack;

public class PostfixAdvanced {

    /**
     * Found this resources helpful:
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

            } else if (character.matches("[)(+÷×√^-]")) {

                switch (character) {

                    case ")":

                        while (!stack.isEmpty()) {

                            if (stack.peek().equals("(")) {
                                stack.pop();
                                break;
                            }

                            String pop = stack.pop();

                            if (!pop.equals("(") && !pop.equals(")")) result.append(pop).append(" ");

                        }

                        break;

                    case "(":

                        stack.push(character);

                        break;

                    case "+":
                    case "-":

                        if (stack.isEmpty()) {
                            stack.push(character);
                        } else if (stack.peek().equals("(")) {
                            stack.push(character);
                        } else {

                            while (!stack.empty()) {

                                if (stack.peek().equals("(")) {
                                    stack.push(character);
                                    break;
                                }

                                String pop = stack.pop();
                                if (!pop.equals("(") && !pop.equals(")")) result.append(pop).append(" ");

                            }

                            if (stack.empty()) stack.push(character);
                        }

                        break;

                    case "÷":
                    case "×":

                        if (stack.isEmpty()) {
                            stack.push(character);
                        } else if (stack.peek().equals("(")) {
                            stack.push(character);
                        } else if (stack.peek().equals("+") || stack.peek().equals("-")) {
                            stack.push(character);
                        } else {

                            while (!stack.empty()) {

                                if (stack.peek().equals("(")
                                        || stack.peek().equals("+")
                                        || stack.peek().equals("-")) {

                                    stack.push(character);
                                    break;

                                }

                                String pop = stack.pop();
                                if (!pop.equals("(") && !pop.equals(")")) result.append(pop).append(" ");

                            }

                            if (stack.empty()) stack.push(character);
                        }

                        break;


                    case "√":
                    case "^":

                        if (stack.isEmpty()) {
                            stack.push(character);
                        } else if (stack.peek().equals("(")) {
                            stack.push(character);
                        } else if (stack.peek().equals("+") || stack.peek().equals("-")
                                || stack.peek().equals("÷") || stack.peek().equals("×")) {
                            stack.push(character);
                        } else {

                            while (!stack.empty()) {

                                if (stack.peek().equals("(")
                                        || stack.peek().equals("+")
                                        || stack.peek().equals("-")
                                        || stack.peek().equals("÷")
                                        || stack.peek().equals("×")) {

                                    stack.push(character);
                                    break;

                                }

                                String pop = stack.pop();
                                if (!pop.equals("(") && !pop.equals(")")) result.append(pop).append(" ");

                            }

                            if (stack.empty()) stack.push(character);

                        }


                        break;

                }

            }
        }

        while (!stack.isEmpty()) {

            String pop = stack.pop();

            if (!pop.equals("(") && !pop.equals(")")) result.append(pop).append(" ");
        }

        return result.toString();
    }

    public String evaluatePostfix(String expression) {

        Stack<String> stack = new Stack<>();

        for (String element : expression.split(" ")) {

            switch (element) {

                case "√":
                    double sqrt = Math.sqrt(Double.parseDouble(stack.pop()));
                    stack.push(String.valueOf(sqrt));
                    break;

                case "^":
                    double pow = Double.parseDouble(stack.pop());
                    double num = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(Math.pow(num, pow)));
                    break;

                case "+":
                    double n2;
                    double n1;

                    if (!stack.isEmpty()) {
                        n2 = Double.parseDouble(stack.pop());
                    } else {
                        n2 = 0;
                    }

                    if (!stack.isEmpty()) {
                        n1 = Double.parseDouble(stack.pop());
                    } else {
                        n1 = 0;
                    }

                    stack.push(String.valueOf(n1 + n2));
                    break;
                case "-":
                    double n4;
                    double n3;

                    if (!stack.isEmpty()) {
                        n4 = Double.parseDouble(stack.pop());
                    } else {
                        n4 = 0;
                    }

                    if (!stack.isEmpty()) {
                        n3 = Double.parseDouble(stack.pop());
                    } else {
                        n3 = 0;
                    }

                    stack.push(String.valueOf(n3 - n4));
                    break;
                case "×":
                    double n6;
                    double n5;

                    if (!stack.isEmpty()) {
                        n6 = Double.parseDouble(stack.pop());
                    } else {
                        n6 = 0;
                    }

                    if (!stack.isEmpty()) {
                        n5 = Double.parseDouble(stack.pop());
                    } else {
                        n5 = 0;
                    }
                    stack.push(String.valueOf(n5 * n6));
                    break;
                case "÷":
                    double n8;
                    double n7;

                    if (!stack.isEmpty()) {
                        n8 = Double.parseDouble(stack.pop());
                    } else {
                        n8 = 0;
                    }

                    if (!stack.isEmpty()) {
                        n7 = Double.parseDouble(stack.pop());
                    } else {
                        n7 = 0;
                    }
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
