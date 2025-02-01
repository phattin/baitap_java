package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BUS.UserBUS;
import DAO.UserDAO;
import DTO.UserDTO;
import GUI.LoginGUI;

public class RegisterGUI extends JFrame implements ActionListener {
    UserBUS userBUS = new UserBUS();
    UserDAO userDAO = new UserDAO();
    JLabel title, lu, lp;
    JTextField tfu, tfp;
    JButton registerBtn;
    
    public RegisterGUI(){
        this.initComponents();
    }
    
    public void initComponents(){
    setTitle("Login");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    
    title = new JLabel("Register", JLabel.CENTER);
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(Color.BLUE);

    JPanel formPanel = new JPanel(new BorderLayout(10, 10));
    formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    lu = new JLabel("Username:");
    lp = new JLabel("Password:");
    tfu = new JTextField(20);  
    tfp = new JPasswordField(20); 

    usernamePanel.add(lu);
    usernamePanel.add(tfu);

    passwordPanel.add(lp);
    passwordPanel.add(tfp);

    formPanel.add(usernamePanel, BorderLayout.NORTH);
    formPanel.add(passwordPanel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    registerBtn = new JButton("Register");

    buttonPanel.add(registerBtn);
    
    add(title, BorderLayout.NORTH);
    add(formPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    registerBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerBtn){
            try{
                if(tfu.getText().isEmpty() || tfp.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                    return;
                }
                UserDTO userRegister = new UserDTO(tfu.getText(),tfp.getText());
                if(userBUS.register(userRegister)){
                    JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                    dispose();
                    LoginGUI lg = new LoginGUI();
                    lg.setVisible(true);
                }
            } catch(IllegalArgumentException ie){
                JOptionPane.showMessageDialog(null, ie);
            }
        }
    }
}

