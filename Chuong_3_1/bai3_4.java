import javax.swing.*;
import java.awt.*;
public class bai3_4 {
    bai3_4(){
        JFrame f = new JFrame("Border Layout");
        JButton b1 = new JButton("top");
        f.add(b1, BorderLayout.NORTH);
        JButton b2 = new JButton("left");
        f.add(b2, BorderLayout.WEST);
        JButton b3 = new JButton("center");
        f.add(b3, BorderLayout.CENTER);
        JButton b4 = new JButton("right");
        f.add(b4, BorderLayout.EAST);
        JButton b5 = new JButton("bottom");
        f.add(b5, BorderLayout.SOUTH);

        f.setSize(300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new bai3_4();
    }
}
