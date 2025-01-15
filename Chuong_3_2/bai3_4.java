import javax.swing.*;

import java.awt.Image;
import java.awt.event.*;

public class bai3_4 implements ActionListener {
    JFrame f;
    JLabel img;
    JRadioButton rb1, rb2, rb3, rb4, rb5;
    bai3_4(){
        f = new JFrame("RadioButtonDemo");
        img = new JLabel();
        img.setBounds(100,30,150,150);
        ButtonGroup bg = new ButtonGroup();
        rb1 = new JRadioButton("Fish");
        rb1.setBounds(20,30,70,30);
        bg.add(rb1);
        rb1.addActionListener(this);
        rb2 = new JRadioButton("Cat");
        rb2.setBounds(20,60,70,30);
        bg.add(rb2);
        rb2.addActionListener(this);
        rb3 = new JRadioButton("Dog");
        rb3.setBounds(20,90,70,30);
        bg.add(rb3);
        rb3.addActionListener(this);
        rb4 = new JRadioButton("Rabbit");
        rb4.setBounds(20,120,70,30);
        bg.add(rb4);
        rb4.addActionListener(this);
        rb5 = new JRadioButton("Pig");
        rb5.setBounds(20,150,70,30);
        bg.add(rb5);
        rb5.addActionListener(this);

        f.setSize(300,300);
        f.add(rb1);
        f.add(rb2);
        f.add(rb3);
        f.add(rb4);
        f.add(rb5);
        f.add(img);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        String imagePath="";
        if(rb1.isSelected())
            imagePath = "./img3_4/fish.jpg";
        if(rb2.isSelected())
            imagePath = "./img3_4/cat.jpg";
        if(rb3.isSelected())
            imagePath = "./img3_4/rabbit.jpg";
        if(rb4.isSelected())
            imagePath = "./img3_4/dog.jpg";
        if(rb5.isSelected())
            imagePath = "./img3_4/pig.png";
        ImageIcon originalIcon = new ImageIcon(imagePath);

        // Thay đổi kích thước hình ảnh
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        img.setIcon(scaledIcon);

    }
    public static void main(String[] args) {
        new bai3_4();
    }
}
