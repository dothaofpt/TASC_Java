package JAVA_COLLECTION;

import java.util.Arrays;
import java.util.Scanner;

public class OneDimensionalArray {
    public static void main(String[] args) {
//        vi du mang
//        viet phuong trinh tao ra 1 mang 1 chieu gom cac phan tu la so co n phan tu, do nguoi dung nhap tu ban phim
        Scanner sc =new Scanner(System.in);
        System.out.println("Moi nhap vao so pt toi da cua mang: ");

        int n =sc.nextInt();
//        tao mang co n phan tu (cap phat bo nho cho mang)
        int[] M = new int[n];
        System.out.println("So pt cua mang: +M.length");
//        nhap du lieu cho tung phan tu
        for(int i = 0;i<n; i++){
            System.out.println("M["+i+"]= "); // M[0] =
               M[i] = sc.nextInt();

        }
// xuat mang de xem
        System.out.println("Mang M duoc tao ra la: ");
        System.out.println(Arrays.toString(M));
    }

}
