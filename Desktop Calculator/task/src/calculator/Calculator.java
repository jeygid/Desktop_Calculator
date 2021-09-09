package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame {

    public Calculator() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Calculator");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 350, 500);
        panel.setLayout(null);
        add(panel);

        JLabel resultLabel = new JLabel("0", SwingConstants.RIGHT);
        resultLabel.setName("ResultLabel");
        resultLabel.setBounds(20, 10, 300, 50);
        resultLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        add(resultLabel);
        panel.add(resultLabel);

        JLabel equationLabel = new JLabel("", SwingConstants.RIGHT);
        equationLabel.setName("EquationLabel");
        equationLabel.setBounds(20, 60, 300, 50);
        equationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        equationLabel.setForeground(Color.BLUE);
        add(equationLabel);
        panel.add(equationLabel);

        JButton buttonClear = new JButton("C");
        buttonClear.setName("Clear");
        buttonClear.setBounds(180, 140, 50, 50);
        add(buttonClear);
        panel.add(buttonClear);

        buttonClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                equationLabel.setText("");
                resultLabel.setText("0");
            }
        });

        JButton buttonDelete = new JButton("<");
        buttonDelete.setName("Delete");
        buttonDelete.setBounds(250, 140, 50, 50);
        add(buttonDelete);
        panel.add(buttonDelete);

        buttonDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();
                if (text.isEmpty()) return;
                equationLabel.setText(text.substring(0, text.length() - 1));
            }
        });


        JButton buttonSeven = new JButton("7");
        buttonSeven.setName("Seven");
        buttonSeven.setBounds(40, 200, 50, 50);
        add(buttonSeven);
        panel.add(buttonSeven);

        buttonSeven.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.7");

                } else {

                    equationLabel.setText(equationLabel.getText() + "7");

                }
            }
        });

        JButton buttonEight = new JButton("8");
        buttonEight.setName("Eight");
        buttonEight.setBounds(110, 200, 50, 50);
        add(buttonEight);
        panel.add(buttonEight);

        buttonEight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.8");

                } else {

                    equationLabel.setText(equationLabel.getText() + "8");

                }
            }
        });

        JButton buttonNine = new JButton("9");
        buttonNine.setName("Nine");
        buttonNine.setBounds(180, 200, 50, 50);
        add(buttonNine);
        panel.add(buttonNine);

        buttonNine.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.9");

                } else {

                    equationLabel.setText(equationLabel.getText() + "9");

                }
            }
        });

        JButton buttonDivide = new JButton("÷");
        buttonDivide.setName("Divide");
        buttonDivide.setBounds(250, 200, 50, 50);
        add(buttonDivide);
        panel.add(buttonDivide);

        buttonDivide.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();

                if (!text.isEmpty()) {

                    if (text.matches("((\\S?)+[-÷×+])")) {
                        equationLabel.setText(text.substring(0, text.length() - 1) + "÷");
                    } else if (text.endsWith(".")) {
                        equationLabel.setText(text + "0÷");
                    } else {
                        equationLabel.setText(text + "÷");
                    }
                }
            }
        });

        JButton buttonFour = new JButton("4");
        buttonFour.setName("Four");
        buttonFour.setBounds(40, 260, 50, 50);

        add(buttonFour);
        panel.add(buttonFour);

        buttonFour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.4");

                } else {

                    equationLabel.setText(equationLabel.getText() + "4");

                }
            }
        });

        JButton buttonFive = new JButton("5");
        buttonFive.setName("Five");
        buttonFive.setBounds(110, 260, 50, 50);

        add(buttonFive);
        panel.add(buttonFive);

        buttonFive.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.5");

                } else {

                    equationLabel.setText(equationLabel.getText() + "5");

                }
            }
        });

        JButton buttonSix = new JButton("6");
        buttonSix.setName("Six");
        buttonSix.setBounds(180, 260, 50, 50);

        add(buttonSix);
        panel.add(buttonSix);

        buttonSix.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.6");

                } else {

                    equationLabel.setText(equationLabel.getText() + "6");

                }
            }
        });

        JButton buttonMultiply = new JButton("×");
        buttonMultiply.setName("Multiply");
        buttonMultiply.setBounds(250, 260, 50, 50);

        add(buttonMultiply);
        panel.add(buttonMultiply);

        buttonMultiply.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();

                if (!text.isEmpty()) {

                    if (text.matches("((\\S?)+[-÷×+])")) {
                        equationLabel.setText(text.substring(0, text.length() - 1) + "×");
                    } else if (text.endsWith(".")) {
                        equationLabel.setText(text + "0×");
                    } else {
                        equationLabel.setText(text + "×");
                    }
                }

            }
        });


        JButton buttonOne = new JButton("1");
        buttonOne.setName("One");
        buttonOne.setBounds(40, 320, 50, 50);

        add(buttonOne);
        panel.add(buttonOne);

        buttonOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.1");

                } else {

                    equationLabel.setText(equationLabel.getText() + "1");

                }
            }
        });

        JButton buttonTwo = new JButton("2");
        buttonTwo.setName("Two");
        buttonTwo.setBounds(110, 320, 50, 50);

        add(buttonTwo);
        panel.add(buttonTwo);

        buttonTwo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.2");

                } else {

                    equationLabel.setText(equationLabel.getText() + "2");

                }
            }
        });

        JButton buttonThree = new JButton("3");
        buttonThree.setName("Three");
        buttonThree.setBounds(180, 320, 50, 50);

        add(buttonThree);
        panel.add(buttonThree);

        buttonThree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                if (equationLabel.getText().equals(".")) {

                    equationLabel.setText("0.3");

                } else {

                    equationLabel.setText(equationLabel.getText() + "3");

                }
            }
        });

        JButton buttonAdd = new JButton("+");
        buttonAdd.setName("Add");
        buttonAdd.setBounds(250, 320, 50, 50);

        add(buttonAdd);
        panel.add(buttonAdd);

        buttonAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();

                if (!text.isEmpty()) {

                    if (text.matches("((\\S?)+[-÷×+])")) {
                        equationLabel.setText(text.substring(0, text.length() - 1) + "+");
                    } else if (text.endsWith(".")) {
                        equationLabel.setText(text + "0+");
                    } else {
                        equationLabel.setText(text + "+");
                    }
                }
            }
        });

        JButton buttonDot = new JButton(".");
        buttonDot.setName("Dot");
        buttonDot.setBounds(40, 380, 50, 50);

        add(buttonDot);
        panel.add(buttonDot);

        buttonDot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();

                if (text.isEmpty()) equationLabel.setText(".");

                if (!text.isEmpty() && !text.matches("((\\S?)+[-÷×+.])")) {
                    equationLabel.setText(equationLabel.getText() + ".");
                }

            }
        });

        JButton buttonZero = new JButton("0");
        buttonZero.setName("Zero");
        buttonZero.setBounds(110, 380, 50, 50);

        add(buttonZero);
        panel.add(buttonZero);

        buttonZero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                equationLabel.setText(equationLabel.getText() + "0");
            }
        });

        JButton buttonEquals = new JButton("=");
        buttonEquals.setName("Equals");
        buttonEquals.setBounds(180, 380, 50, 50);

        add(buttonEquals);
        panel.add(buttonEquals);

        buttonEquals.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();

                if (text.isEmpty()) return;

                if (text.matches("((\\S?)+[-÷×+.])")) {
                    equationLabel.setForeground(Color.RED.darker());
                    return;
                }

                Pattern divisionByZeroPattern = Pattern.compile("((\\S?)+[÷][0]+[.]?([0]+)?$)");
                Matcher divisionByZeroMatcher = divisionByZeroPattern.matcher(text);

                if (divisionByZeroMatcher.matches()) {
                    equationLabel.setForeground(Color.RED.darker());
                    return;
                }

                Postfix postfix = new Postfix();

                String postfixExpression = postfix.getPostfix(text);
                String result = postfix.evaluatePostfix(postfixExpression);

                double resultNumber = Double.parseDouble(result);

                if ((int) resultNumber == resultNumber) {
                    resultLabel.setText("" + (int) resultNumber);
                } else {
                    resultLabel.setText(result);
                }


            }
        });

        JButton buttonSubtract = new JButton("-");
        buttonSubtract.setName("Subtract");
        buttonSubtract.setBounds(250, 380, 50, 50);

        add(buttonSubtract);
        panel.add(buttonSubtract);

        buttonSubtract.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                equationLabel.setForeground(Color.BLUE);

                String text = equationLabel.getText();

                if (!text.isEmpty()) {

                    if (text.matches("((\\S?)+[-÷×+])")) {
                        equationLabel.setText(text.substring(0, text.length() - 1) + "-");
                    } else if (text.endsWith(".")) {
                        equationLabel.setText(text + "0-");

                    } else {
                        equationLabel.setText(text + "-");
                    }
                }

            }
        });

        panel.setVisible(true);

        setVisible(true);

    }

}
