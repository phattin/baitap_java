import javax.swing.*;
import java.awt.event.*;
public class bai3_1 {
    public  bai3_1(){
        JFrame f = new JFrame("Counter");
        JButton b = new JButton("Click me!");
        JLabel label = new JLabel();
        final int count[] = {0};
        label.setText("Click count: "+ count[0]);
        b.setBounds(50, 0, 100, 30);
        label.setBounds(200, 0, 200, 30);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                label.setText("Click count: "+ ++count[0]);
            }
        });
        f.add(b);
        f.add(label);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new bai3_1();
    }
}
