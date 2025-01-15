import javax.swing.*;

public class bai3_1{
    bai3_1(){
        JFrame f = new JFrame("HelloWorld");
        f.setBounds(300,200,250,200);
        JButton b = new JButton("Click");
        b.setBounds(50,50,100,100);
        f.add(b);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new bai3_1();
    }
}