package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BUS.UserBUS;
import DAO.UserDAO;
import DTO.UserDTO;

public class LoginGUI extends JFrame implements ActionListener {
    UserBUS userBUS = new UserBUS();
    UserDAO userDAO = new UserDAO();
    JLabel title, lu, lp;
    JTextField tfu, tfp;
    JButton confirmBtn, registerBtn;
    
    public LoginGUI(){
        this.initComponents();
    }
    
    public void initComponents(){
    setTitle("Login");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    
    title = new JLabel("Login", JLabel.CENTER);
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
    confirmBtn = new JButton("Confirm");
    registerBtn = new JButton("Register");

    buttonPanel.add(confirmBtn);
    buttonPanel.add(registerBtn);
    
    add(title, BorderLayout.NORTH);
    add(formPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    confirmBtn.addActionListener(this);
    registerBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== confirmBtn){
            if(tfu.getText().isEmpty() || tfp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                return;
            }
            UserDTO userLogin = new UserDTO(tfu.getText(),tfp.getText());
            if(!userBUS.login(userLogin)){
                JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tên đăng nhập không tồn tại");
                return;
            }
            else{
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                dispose();
                new HomeGUI(userDAO.getUserByUsername(userLogin.getUsername()));
            }
        }
        else if(e.getSource() == registerBtn){
            dispose();
            new RegisterGUI();
        }
    }
    
    public static void main(String args[]){
        LoginGUI l = new LoginGUI();
        l.setVisible(true);
    }
}
