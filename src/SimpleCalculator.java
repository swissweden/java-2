import javax.swing.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField resultField;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(50, 30, 50, 30);
        add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(120, 30, 50, 30);
        add(textField2);

        resultField = new JTextField();
        resultField.setBounds(190, 30, 100, 30);
        resultField.setEditable(false);
        add(resultField);

        addButton = new JButton("+");
        addButton.setBounds(50, 80, 50, 30);
        add(addButton);

        subButton = new JButton("-");
        subButton.setBounds(120, 80, 50, 30);
        add(subButton);

        mulButton = new JButton("*");
        mulButton.setBounds(190, 80, 50, 30);
        add(mulButton);

        divButton = new JButton("/");
        divButton.setBounds(260, 80, 50, 30);
        add(divButton);

        // 각 버튼에 ActionListener 추가
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 + num2;
                resultField.setText(Integer.toString(result));
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 - num2;
                resultField.setText(Integer.toString(result));
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                int result = num1 * num2;
                resultField.setText(Integer.toString(result));
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(textField1.getText());
                int num2 = Integer.parseInt(textField2.getText());
                if (num2 != 0) {
                    int result = num1 / num2;
                    resultField.setText(Integer.toString(result));
                } else {
                    resultField.setText("Error");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setVisible(true);
    }
}
