import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class bai3_1 implements ActionListener{
    JFrame f;
    JTable t;
    DefaultTableModel model;
    JButton addBtn, deleteBtn;
    bai3_1(){
        f = new JFrame();
        f.setSize(400,500);
        f.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        JLabel l = new JLabel("Phonebook");
        l.setFont(new Font("Arial", Font.BOLD, 24));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        t = new JTable();
        model = new DefaultTableModel();
        t.setModel(model);
        model.addColumn("Name");
        model.addColumn("Phone no");
        JScrollPane scrollPane = new JScrollPane(t);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        addBtn = new JButton("Add Contact");
        deleteBtn = new JButton("Delete Contact");

        addBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        f.add(l); f.add(scrollPane);
        f.add(addBtn); f.add(deleteBtn);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addBtn){
            String name = JOptionPane.showInputDialog(f,"Nhap ten: ");
            String phone = JOptionPane.showInputDialog(f,"Nhap SDT: ");
            if (name != null && phone != null && !name.isEmpty() && !phone.isEmpty())
                model.addRow(new Object[]{name,phone});
        }
        else if(e.getSource() == deleteBtn){
            int selectedRow = t.getSelectedRow();
            if (selectedRow != -1)
                model.removeRow(selectedRow);
            else 
                JOptionPane.showMessageDialog(f, "No contact selected to delete.");
        }
    }
    public static void main(String[] args) {
        new bai3_1();
    }
}