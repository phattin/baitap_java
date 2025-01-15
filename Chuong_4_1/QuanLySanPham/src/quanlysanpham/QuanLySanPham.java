package quanlysanpham;

import java.sql.*;
import java.util.Vector;
import jdbc.JDBCUtil;
import model.SanPham;

public class QuanLySanPham {
    public static QuanLySanPham getInstance(){
        return new QuanLySanPham();
    }
    
    public void them(SanPham sp){
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO dbo.SanPham(TenSP, Gia, MaLoaiSP)"
                    + " VALUES ('"+sp.getTen()+"',"+sp.getGia()+","+sp.getMaloai()+")";
            int kq = st.executeUpdate(sql);
            System.out.println("Da them "+kq+" dong");
            JDBCUtil.closeConnection(con);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void sua(SanPham sp, int ID){
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "UPDATE SanPham"
                    + " SET"
                    + " TenSP='"+sp.getTen()+"'"
                    + ", Gia= "+sp.getGia()
                    + ", MaLoaiSP= "+sp.getMaloai()
                    + " WHERE MaSP= "+ID;
            int kq = st.executeUpdate(sql);
            System.out.println("Co "+kq+" dong bi thay doi");
            JDBCUtil.closeConnection(con);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void xoa(int ID){
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE SanPham"
                    + " WHERE MaSP= "+ID;
            int kq = st.executeUpdate(sql);
            System.out.println("Co "+kq+" dong bi thay doi");
            JDBCUtil.closeConnection(con);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public Vector<SanPham> selectAll(){
        Vector<SanPham> kq = new Vector<SanPham>();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham "
                    + " JOIN LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int ma = rs.getInt("MaSP");
                String ten = rs.getString("TenSP");
                float gia = rs.getFloat("Gia");
                int maloai = rs.getInt("MaLoaiSP");
                String tenmaloai = rs.getString("TenLoaiSP");
                SanPham sp = new SanPham(ten,gia,maloai);
                sp.setTenmaloai(tenmaloai);
                sp.setMa(ma);
                kq.add(sp);
            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException e){
            System.out.println(e);
        }
        return kq;
    }
    
    public Vector<SanPham> timMaLoai(int id){
        Vector<SanPham> kq = new Vector<SanPham>();
        try{
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM SanPham "
                    + " JOIN LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(id == rs.getInt("MaLoaiSP")){
                    int ma = rs.getInt("MaSP");
                    String ten = rs.getString("TenSP");
                    float gia = rs.getFloat("Gia");
                    int maloai = rs.getInt("MaLoaiSP");
                    String tenmaloai = rs.getString("TenLoaiSP");
                    SanPham sp = new SanPham(ten,gia,maloai);
                    sp.setTenmaloai(tenmaloai);
                    sp.setMa(ma);
                    kq.add(sp);
                }
            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException e){
            System.out.println(e);
        }
        return kq;
    }
   
}
