import javax.swing.*;
import java.awt.*;

public class bai3_2 {
    bai3_2(){
        JFrame f = new JFrame("Flowlayout Example");
        JLabel l1 = new JLabel("Enter your name");
        JTextField tf1 = new JTextField(15);
        f.add(l1);
        f.add(tf1);
        JLabel l2 = new JLabel("Enter your city");
        JTextField tf2 = new JTextField(15);
        f.add(l2);
        f.add(tf2);
        JButton b1 = new JButton("Clear");
        f.add(b1);
        JButton b2 = new JButton("Submit");
        f.add(b2);
        JButton b3 = new JButton("Exit");
        f.add(b3);

        f.setSize(300,300);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new bai3_2();
    }
}
