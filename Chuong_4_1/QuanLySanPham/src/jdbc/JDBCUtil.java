package jdbc;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection con = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLSanPham;encrypt=true;trustServerCertificate=true";
        String username="sa"; String password = "12345678";
        con = DriverManager.getConnection(dbUrl,username,password);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return con;
    }
    public static void closeConnection(Connection con){
        try{
            if(con!=null)
                con.close();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
}
