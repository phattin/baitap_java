package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import DTO.UserDTO;

public class HomeGUI extends JFrame{
    UserDTO userLogin = new UserDTO();
    JLabel l = new JLabel();
    public HomeGUI(){
    }
    public HomeGUI(UserDTO user){
        userLogin = user;
        initComponent();
    }
    public void initComponent(){
        setSize(300,300);
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        
        l = new JLabel("Hello "+userLogin.getUsername(), JLabel.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 24));
        l.setForeground(Color.BLUE);
        
        add(l);
    }
}
