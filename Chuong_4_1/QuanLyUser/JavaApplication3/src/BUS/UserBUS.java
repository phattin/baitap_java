package BUS;

import java.util.Vector;
import DAO.UserDAO;
import DTO.UserDTO;

public class UserBUS {
    UserDAO userDAO = new UserDAO();
    
    public Vector<UserDTO> getAllUser(){
        return userDAO.getAllUser();
    }
    
    public boolean login(UserDTO user){
        UserDTO u = userDAO.getUserByUsername(user.getUsername());
        return u != null && user.getPassword().equals(u.getPassword());
    }
    
    public boolean register(UserDTO user){
        if(userDAO.hasUserName(user.getUsername()))
             throw new IllegalArgumentException("Username đã tồn tại");
        if (user.getUsername().contains(" ")) {
            throw new IllegalArgumentException("Username không được chứa khoảng trắng.");
        }
        if (user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password phải có ít nhất 6 ký tự.");
        }

        return userDAO.addUser(user);
    }
}
