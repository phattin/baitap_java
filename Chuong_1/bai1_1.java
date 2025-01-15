import java.util.Scanner;
public class bai1_1{
    public static void main(String[] args) {
        int n,s=0;
        Scanner r = new Scanner(System.in);
        System.out.print("Nhap n:");
        n = r.nextInt();
        while(n!=0){
            s += n%10;
            n /= 10;
        }
        System.out.println("Tong cac chu so la "+s);
    }
}