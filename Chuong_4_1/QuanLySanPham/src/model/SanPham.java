
package model;
import java.util.Scanner;

public class SanPham {
    private int ma;
    private String ten;
    private float gia;
    private int maloai;
    private String tenmaloai;
    Scanner r = new Scanner(System.in);

    public SanPham() {
        this.ten = "";
        this.gia = 0;
        this.maloai = 0;
    }

    public SanPham(String ten, float gia, int maloai) {
        this.ten = ten;
        this.gia = gia;
        this.maloai = maloai;
    }
    
    public void nhap(){
        System.out.print("Nhap ten san pham: ");
        ten = r.nextLine();
        System.out.print("Nhap gia san pham: ");
        gia = r.nextFloat();
        r.nextLine();
        System.out.print("Nhap ma loai san pham: ");
        maloai = r.nextInt();
    }
    
    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public float getGia() {
        return gia;
    }

    public int getMaloai() {
        return maloai;
    }

    public String getTenmaloai() {
        return tenmaloai;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public void setTenmaloai(String tenmaloai) {
        this.tenmaloai = tenmaloai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "ma=" + ma + ", ten=" + ten + ", gia=" + gia + ", maloai=" + maloai + ", tenmaloai=" + tenmaloai + '}';
    }

    
    
    
}
