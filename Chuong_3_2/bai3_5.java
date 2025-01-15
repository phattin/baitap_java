import javax.swing.*;
import java.awt.event.*;

public class bai3_5 {
    bai3_5(){
        JFrame f = new JFrame("Food Ordering");
        JLabel menu = new JLabel("Menu");
        menu.setBounds(30,50,50,30);
        f.add(menu);
        JCheckBox c1 = new JCheckBox("Pizza ($25)");
        c1.setBounds(100,100,150,30);
        f.add(c1);
        JCheckBox c2 = new JCheckBox("Burger ($20)");
        c2.setBounds(100,130,150,30);
        f.add(c2);
        JCheckBox c3 = new JCheckBox("Tea ($5)");
        c3.setBounds(100,160,150,30);
        f.add(c3);
        JCheckBox c4 = new JCheckBox("Coffee ($10)");
        c4.setBounds(100,190,150,30);
        f.add(c4);
        JButton b = new JButton("Order");
        b.setBounds(100,250,70,30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String bill = "";
                int s = 0;
                if(c1.isSelected()){
                    bill += "Pizza: $25\n";
                    s += 25;
                }
                if(c2.isSelected()){
                    bill += "Burger: $20\n";
                    s += 20;
                }
                if(c3.isSelected()){
                    bill += "Tea: $5\n";
                    s += 5;
                }
                if(c4.isSelected()){
                    bill += "Coffee: $10\n";
                    s += 10;
                }
                bill += "----------------\n";
                bill += "Total: $" + s;
                JOptionPane.showMessageDialog(null,bill);
            }
        });
        
        f.setSize(300,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new bai3_5();
    }
}
