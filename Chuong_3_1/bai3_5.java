import javax.swing.*;
import java.awt.*;

public class bai3_5 {
    bai3_5() {
        JFrame f = new JFrame("JPanel Demo Program");
        f.setSize(350, 220);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        p.setBorder(BorderFactory.createTitledBorder("Login Panel"));

        JLabel l1 = new JLabel("Enter username:");
        JTextField tf1 = new JTextField(15);

        JLabel l2 = new JLabel("Enter password:");
        JTextField tf2 = new JTextField(15);

        JButton b = new JButton("Login");

        p.add(l1);
        p.add(tf1);
        p.add(l2);
        p.add(tf2);
        p.add(b);

        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new bai3_5();
    }
}
