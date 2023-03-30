package graphic_user_interface;

import business_logic.InputException;
import business_logic.Operations;
import business_logic.ValidString;
import data_logic.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graphic implements ActionListener {

    JFrame frame;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;

    JButton[] functionButtons = new JButton[10];
    JButton addButton, substractButton, divideButton, multiplyButton, integrateButton, derivateButton, clearButton;
    JPanel panel;

    Font font = new Font("Arial", Font.BOLD, 15);

    String firstpoly, secondpoly, result, rest;

    public Graphic() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 650);
        frame.setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(150, 20, 300, 50);
        textField1.setFont(font);
        textField1.setEditable(true);

        textField2 = new JTextField();
        textField2.setBounds(150, 120, 300, 50);
        textField2.setFont(font);
        textField2.setEditable(true);

        textField3 = new JTextField();
        textField3.setBounds(150, 220, 300, 50);
        textField3.setFont(font);
        textField3.setEditable(true);

        label1 = new JLabel();
        label1.setBounds(20, 20, 150, 50);
        label1.setFont(font);
        label1.setText("First Polynom");

        label2 = new JLabel();
        label2.setBounds(20, 120, 150, 50);
        label2.setFont(font);
        label2.setText("Second Polynom");

        label3 = new JLabel();
        label3.setBounds(20, 220, 150, 50);
        label3.setFont(font);
        label3.setText("Result");

        addButton = new JButton("Add");
        substractButton = new JButton("Substract");
        divideButton = new JButton("Divide");
        multiplyButton = new JButton("Multiply");
        integrateButton = new JButton("Integrate");
        derivateButton = new JButton("Derivate");
        clearButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = substractButton;
        functionButtons[2] = divideButton;
        functionButtons[3] = multiplyButton;
        functionButtons[4] = integrateButton;
        functionButtons[5] = derivateButton;
        functionButtons[6] = clearButton;

        for (int i = 0; i < 7; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);

        }

        addButton.setBounds(40, 320, 110, 50);
        substractButton.setBounds(190, 320, 110, 50);
        clearButton.setBounds(340, 320, 110, 50);
        multiplyButton.setBounds(40, 420, 110, 50);
        divideButton.setBounds(190, 420, 110, 50);
        integrateButton.setBounds(40, 520, 110, 50);
        derivateButton.setBounds(190, 520, 110, 50);


        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(addButton);
        frame.add(substractButton);
        frame.add(divideButton);
        frame.add(multiplyButton);
        frame.add(integrateButton);
        frame.add(derivateButton);
        frame.add(clearButton);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

/*
        try {
            ValidString.isStringValid(textField1.getText());
            ValidString.isStringValid(textField2.getText());

        } catch (InputException exception) {
            System.out.println("Bad");
        }
*/
        if (e.getSource() == addButton) {

            Polynomial polynomialone = new Polynomial(textField1.getText());
            Polynomial polynomialtwo = new Polynomial(textField2.getText());

            Operations operations = new Operations();
            Polynomial r = new Polynomial();
            operations.setP1(polynomialone);
            r = operations.compute(polynomialtwo, "add");
            result = r.finalPolynomial(r);

            textField3.setText(result);
        }

        if (e.getSource() == substractButton) {
            Polynomial polynomialone = new Polynomial(textField1.getText());
            Polynomial polynomialtwo = new Polynomial(textField2.getText());

            Operations operations = new Operations();
            Polynomial r = new Polynomial();
            operations.setP1(polynomialone);
            r = operations.compute(polynomialtwo, "sub");
            result = r.finalPolynomial(r);

            textField3.setText(result);
        }
        if (e.getSource() == clearButton) {
            textField1.setText(" ");
            textField2.setText(" ");
            textField3.setText(" ");
        }

        if (e.getSource() == multiplyButton) {
            Polynomial polynomialone = new Polynomial(textField1.getText());
            Polynomial polynomialtwo = new Polynomial(textField2.getText());

            Operations operations = new Operations();
            Polynomial r = new Polynomial();
            operations.setP1(polynomialone);
            r = operations.compute(polynomialtwo, "mul");
            result = r.finalPolynomial(r);

            textField3.setText(result);
        }

        if (e.getSource() == divideButton) {
            Polynomial polynomialone = new Polynomial(textField1.getText());
            Polynomial polynomialtwo = new Polynomial(textField2.getText());

            Operations operations = new Operations();
            Polynomial r = new Polynomial();
            operations.setP1(polynomialone);
            r = operations.compute(polynomialtwo, "divide");
            result = r.finalPolynomial(r);

            textField3.setText(result);
        }

        if (e.getSource() == integrateButton) {
            Polynomial polynomialone = new Polynomial(textField1.getText());

            Operations operations = new Operations();
            Polynomial r = new Polynomial();
            operations.setP1(polynomialone);
            r = operations.compute(polynomialone, "integration");
            result = r.finalPolynomial(r);

            textField3.setText(result);
        }

        if (e.getSource() == derivateButton) {
            Polynomial polynomialone = new Polynomial(textField1.getText());

            Operations operations = new Operations();
            Polynomial r = new Polynomial();
            operations.setP1(polynomialone);
            r = operations.compute(polynomialone, "derivation");
            result = r.finalPolynomial(r);

            textField3.setText(result);
        }

    }

}


