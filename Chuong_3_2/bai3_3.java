import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class bai3_3 {
    bai3_3(){
        JFrame f = new JFrame("Color");
        String combo[] = {"White","Green","Blue","Yellow","Red"};
        JComboBox<String> cb = new JComboBox<>(combo);
        cb.setBounds(50,50,90,20);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String color = (String) cb.getSelectedItem();
                if(color.equals("White"))
                    f.getContentPane().setBackground(Color.WHITE);
                else if(color.equals("Green"))
                    f.getContentPane().setBackground(Color.GREEN);
                else if(color.equals("Blue"))
                    f.getContentPane().setBackground(Color.BLUE);
                else if(color.equals("Yellow"))
                    f.getContentPane().setBackground(Color.YELLOW);
                else if(color.equals("Red"))
                    f.getContentPane().setBackground(Color.RED);
            }
        });
        f.add(cb);
        f.setSize(300,300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new bai3_3();
    }
}
