import javax.swing.*;
import java.awt.*;

public class bai3_3 {
    bai3_3(){
        JFrame f = new JFrame("GridLayout Test");
        f.setSize(300,200);
        f.setLayout(new GridLayout(3,3,10,10));
        JButton b1 = new JButton("Press 1");
        f.add(b1);
        JButton b2 = new JButton("Press 2");
        f.add(b2);
        JButton b3 = new JButton("Press 3");
        f.add(b3);
        JButton b4 = new JButton("Press 4");
        f.add(b4);
        JButton b5 = new JButton("Press 5");
        f.add(b5);
        JButton b6 = new JButton("Press 6");
        f.add(b6);
        JButton b7 = new JButton("Press 7");
        f.add(b7);
        JButton b8 = new JButton("Press 8");
        f.add(b8);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new bai3_3();
    }
}
