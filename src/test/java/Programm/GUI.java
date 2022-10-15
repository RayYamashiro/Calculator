package Programm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI extends JFrame  implements CalculatorPresenter, ActionListener {
    static String  a = "", b = "" , operation = "";
    static  JFrame frame;
    Calc calc = Calc.getInstance();
    public JPanel buttonsPanel = new JPanel();
    public ArrayList<JButton> buttons = new ArrayList<>();
    public static JTextField result;
    public void main()
    {
        GUI listener = new GUI();

        frame = new JFrame("Programm.Calculator");
        result = new JTextField(16);
        result.setEditable(false);
        result.setText("test");

        List<String> operations = Arrays.asList("+", "-", "/", "*",  "c", "=");


        for(int i = 0; i <10; i++)                      //создание кнопок калькулятора
        {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(listener);
            buttons.add(button);
        }


        buttons.forEach(buttonsPanel::add);             // помещаем все кнопки на панель

        operations.forEach(it -> {                      // помещаем кнопки операций тоже на панель
            JButton button = new JButton(it);
            button.addActionListener(listener);
            buttonsPanel.add(button);
                });


        GridLayout numAndOp = new GridLayout(4,4);   // стиль расположения кнопок через сетку 4*4
        buttonsPanel.setLayout(numAndOp);

        JPanel mainPanel = new JPanel();
        mainPanel.add(result);
        mainPanel.add(buttonsPanel);


        frame.add(mainPanel);

        frame.setSize(360, 180);
        frame.setVisible(true);
    }

    @Override
    public double onPlusClicked() {
         return calc.sum(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public double onMinusClicked() {
        return calc.divide(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public double onDivideClicked() {
        return calc.divide(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public double onMultiplyClicked() {
        return calc.multiply(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String s = e.getActionCommand();

        if(s.charAt(0) >= '0' && s.charAt(0) <= '9')
        {
            if(operation.equals(""))
                a = a + s;
            else
                b = b + s;

            result.setText(a + operation + b);
        } else if(s.charAt(0) == 'c') {
            a = operation = b = "";
            result.setText(a + operation + b);
        }else if(s.charAt(0) == '=')
        {
          double res =  switch (operation)
            {
                case "+" -> onPlusClicked();
                case "-" -> onMinusClicked();
                case "/" -> onDivideClicked();
                case "*" -> onMultiplyClicked();
                default -> 0;
            };
          a = String.valueOf(res);
          result.setText(a);
          operation = b = "";
        }else {
            if(operation.equals(""))
                operation = s;
            result.setText(a + operation + b);
        }

    }
}

