package baitap;

import java.util.Scanner;
import java.util.Vector;
import model.SanPham;
import quanlysanpham.QuanLySanPham;
public class sudungConsole {
//    public static void main(String args[]){
//        Scanner r = new Scanner(System.in);
//        boolean out = false;
//        
//        do{
//            System.out.println("Danh sach lua chon:");
//            System.out.println("1. Them san pham");
//            System.out.println("2. Sua san pham");
//            System.out.println("3. Xoa san pham");
//            System.out.println("4. Xem danh sach san pham");
//            System.out.println("5. Tim san pham theo loai");
//            System.out.println("0. Thoat");
//            System.out.print("Nhap lua chon cua ban: ");
//            int lc = r.nextInt();
//            
//            switch(lc){
//            case 1:
//                SanPham sp1 = new SanPham();
//                sp1.nhap();
//                QuanLySanPham.getInstance().them(sp1);
//                break;
//            case 2:
//                System.out.print("Nhap ma san pham can sua: ");
//                int id = r.nextInt();
//                SanPham sp2 = new SanPham();
//                sp2.nhap();
//                QuanLySanPham.getInstance().sua(sp2,id);
//                break;
//            case 3:
//                System.out.print("Nhap ma san pham can sua: ");
//                int idxoa = r.nextInt();
//                QuanLySanPham.getInstance().xoa(idxoa);
//                break;
//            case 4:
//                System.out.println("Danh sach san pham: ");
//                Vector<SanPham> spList = QuanLySanPham.getInstance().selectAll();
//                for(SanPham s: spList)
//                    System.out.println(s.toString());
//                break;
//            case 5:
//                System.out.print("Nhap ma loai san pham can tim: ");
//                int maloai = r.nextInt();
//                Vector<SanPham> sptk = QuanLySanPham.getInstance().timMaLoai(maloai);
//                for(SanPham s: sptk)
//                    System.out.println(s.toString());
//                break;
//            case 0:
//                out = true;
//                break;
//            default:
//                System.out.println("Khong tim thay lua chon!");
//                break;
//        }
//        }while(out==false);
//        System.out.println("Ban da thoat!");
//        
//    }
}
