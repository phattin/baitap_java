import javax.swing.*;
import java.awt.event.*;

public class bai3_2 {
    bai3_2(){
        JFrame f = new JFrame("SimpleCalculator");
        JLabel l1 = new JLabel("Num1: ");
        JTextField tf1 = new JTextField();
        l1.setBounds(10,0,200,30);
        tf1.setBounds(150,0,200,30);
        JLabel l2 = new JLabel("Num2: ");
        JTextField tf2 = new JTextField();
        l2.setBounds(10,30,200,30);
        tf2.setBounds(150,30,200,30);
        JLabel l3 = new JLabel("Result: ");
        JTextField tf3 = new JTextField();
        l3.setBounds(10,60,200,30);
        tf3.setBounds(150,60,200,30);
        tf3.setEditable(false);
        JButton b1 = new JButton("+");
        JButton b2 = new JButton("-");
        JButton b3 = new JButton("*");
        JButton b4 = new JButton("/");
        b1.setBounds(50,100,40,40);
        b2.setBounds(100,100,40,40);
        b3.setBounds(150,100,40,40);
        b4.setBounds(200,100,40,40);
        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(l3);
        f.add(tf3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.setSize(370,300);
        f.setLayout(null);
        f.setVisible(true);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(tf1.getText().trim());
                    double num2 = Double.parseDouble(tf2.getText().trim());
                    double result = 0;
                    if(e.getSource() == b1)
                        result = num1 + num2;
                    if(e.getSource() == b2)
                        result = num1 - num2;
                    if(e.getSource() == b3)
                        result = num1 * num2;
                    if(e.getSource() == b4)
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(null, "Không thể chia cho 0");
                            return;
                        }
                        else
                            result = num1 / num2;
                    tf3.setText(String.valueOf(result));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Số không hợp lệ");
                }
            }
        };
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new bai3_2();
    }
}
