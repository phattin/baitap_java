
package DAO;

import DTO.UserDTO;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;

public class UserDAO {
    
    public Vector<UserDTO> getAllUser(){
        Connection con = ConnectDB.getConnection();
        Vector<UserDTO> userList = new Vector<UserDTO>();
        try{
            String sql = "Select * from users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                UserDTO user = new UserDTO();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                userList.add(user);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            ConnectDB.closeConnection(con);
        }
        return userList;
    }
    
    public UserDTO getUserByUsername(String userName){
        Connection con = ConnectDB.getConnection();
        try{
            String sql = "Select * from users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                UserDTO user = new UserDTO();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                if(user.getUsername().equals(userName)){
                    return user;
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            ConnectDB.closeConnection(con);
        }
        return null;
    }
    
    public boolean addUser(UserDTO user){
        boolean result = false;
        Connection con = ConnectDB.getConnection();
        try{
            String sql = "Insert into users value(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            if(pst.executeUpdate()>=1)
                result = true;
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            ConnectDB.closeConnection(con);
        }
        return result;
    }
    
    public boolean hasUserName(String username){
        boolean result = false;
        Connection con = ConnectDB.getConnection();
        try{
            String sql = "Select * from users"
                    + " Where Username="+username;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            result = rs.next();
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            ConnectDB.closeConnection(con);
        }
        return result;
    }
}
