package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection(){
        Connection con = null;
        String dbName = "qluser";
        String userName = "Meepsalot";
        String password = "Meepsalot2004";
        String connectionURL = "jdbc:mysql://localhost:3306/" + dbName + "?autoReconnect=true&useSSL=false";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectionURL,userName,password);
        } catch(SQLException e){
            System.out.println(e);
        }catch (ClassNotFoundException ce) {
            System.out.println(ce);
        }
        return con;
    }
    public static void closeConnection(Connection con){
        try{
            if(con!=null)
                con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
