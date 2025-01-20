package baitap;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.SanPham;
import quanlysanpham.QuanLySanPham;

public class sudunggiaodien implements ActionListener {
    JFrame f;
    JTable t = new JTable();
    JButton addbtn, editbtn, deletebtn, findbtn, confirmbtn, cancelbtn;
    DefaultTableModel model = new DefaultTableModel();
    Vector<SanPham> dssp = new Vector<SanPham>();
    public sudunggiaodien(){
        f = new JFrame("Quản Lý Sản Phẩm");
        f.setSize(500,800);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        JLabel lb = new JLabel("Sản phẩm");
        lb.setFont(new Font("Arial", Font.BOLD, 24));
        lb.setHorizontalAlignment(SwingConstants.CENTER);
        f.add(lb);
        
        t.setModel(model);
        model.addColumn("MaSP");
        model.addColumn("TenSP");
        model.addColumn("Gia");
        model.addColumn("TenMaLoaiSP");
        
        JScrollPane scroll = new JScrollPane(t); // Bọc bảng trong JScrollPane
        f.add(scroll, BorderLayout.CENTER);
        
        
        layDuLieu();
        hienthidanhsach();
        
        addbtn = new JButton("Thêm");
        addbtn.addActionListener(this);
        f.add(addbtn);
        
        editbtn = new JButton("Sửa");
        editbtn.addActionListener(this);
        f.add(editbtn);
        
        deletebtn = new JButton("Xóa");
        deletebtn.addActionListener(this);
        f.add(deletebtn);
        
        findbtn = new JButton("Tìm mã loại");
        findbtn.addActionListener(this);
        f.add(findbtn);
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        JDialog dl = new JDialog(f,"Thêm",true);
//        dl.setSize(300,300);
//        dl.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//        
//        JLabel lb1 = new JLabel("Thông tin sản phẩm");
//        lb1.setFont(new Font("Arial", Font.BOLD, 24));
//        lb.setHorizontalAlignment(SwingConstants.CENTER);
//        dl.add(lb1);
//        
//        JLabel name = new JLabel("Tên:");
//        name.add(lb1);
        
        
    }
    
    private void layDuLieu(){
        dssp = QuanLySanPham.getInstance().selectAll();
    }
    
    private void hienthidanhsach(){
        model.setRowCount(0);
        for(int i=0; i<dssp.size();i++){
            SanPham sp = dssp.get(i);
            model.addRow(new Object[]{sp.getMa(),sp.getTen(),sp.getGia(),sp.getTenmaloai()});
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addbtn) {
        try {
            String name = JOptionPane.showInputDialog("Nhập tên sản phẩm:");
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String priceInput = JOptionPane.showInputDialog("Nhập giá sản phẩm:");
            if (priceInput == null || priceInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float price = Float.parseFloat(priceInput);

            String typeIDInput = JOptionPane.showInputDialog("Nhập mã loại sản phẩm:");
            if (typeIDInput == null || typeIDInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã loại sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int typeID = Integer.parseInt(typeIDInput);

            QuanLySanPham.getInstance().them(new SanPham(name, price, typeID));
            
            layDuLieu();
            hienthidanhsach();

            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số cho giá và mã loại!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    else if(e.getSource() == editbtn){
        try{
            int selectedRow = t.getSelectedRow();
            if(selectedRow == -1){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                String name = JOptionPane.showInputDialog("Nhập tên sản phẩm:");
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String priceInput = JOptionPane.showInputDialog("Nhập giá sản phẩm:");
            if (priceInput == null || priceInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Giá sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float price = Float.parseFloat(priceInput);

            String typeIDInput = JOptionPane.showInputDialog("Nhập mã loại sản phẩm:");
            if (typeIDInput == null || typeIDInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mã loại sản phẩm không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int typeID = Integer.parseInt(typeIDInput);

            QuanLySanPham.getInstance().sua(new SanPham(name, price, typeID),dssp.get(selectedRow).getMa());
            
            layDuLieu();
            hienthidanhsach();

            JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số cho giá và mã loại!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    else if(e.getSource()==)
}
    
    public static void main(String args[]){
        new sudunggiaodien();
    }

 
}
