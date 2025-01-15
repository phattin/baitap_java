import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class bai3_2 implements ActionListener {
    JFrame f;
    JLabel l;
    JMenuBar mb;
    JMenu word,background;
    JMenuItem wx,wv,wd,bx,bv,bd;
    bai3_2(){
        f = new JFrame();
        f.setSize(300,200);
        f.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        l = new JLabel("Hello Java!");

        mb = new JMenuBar();
        word = new JMenu("Màu chữ");
        background = new JMenu("Màu nền");
        wx = new JMenuItem("Xanh");
        wv = new JMenuItem("Vàng");
        wd = new JMenuItem("Đỏ");
        bx = new JMenuItem("Xanh");
        bv = new JMenuItem("Vàng");
        bd = new JMenuItem("Đỏ");

        wx.addActionListener(this);
        wv.addActionListener(this);
        wd.addActionListener(this);
        bx.addActionListener(this);
        bv.addActionListener(this);
        bd.addActionListener(this);

        word.add(wx); word.add(wv); word.add(wd);
        background.add(bx); background.add(bv); background.add(bd);
        mb.add(word);mb.add(background);
        f.add(l);
        f.setJMenuBar(mb);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == wx)
            l.setForeground(Color.BLUE);
        else if(e.getSource() == wv)
            l.setForeground(Color.YELLOW);
        else if(e.getSource() == wd)
            l.setForeground(Color.RED);

        if(e.getSource() == bx)
            f.getContentPane().setBackground(Color.BLUE);
        else if(e.getSource() == bv)
            f.getContentPane().setBackground(Color.YELLOW);
        else if(e.getSource() == bd)
            f.getContentPane().setBackground(Color.RED);
    }
    public static void main(String[] args) {
        new bai3_2();
    }
}
