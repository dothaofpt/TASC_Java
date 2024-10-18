package JAVA_COLLECTION.B1;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
int[] mang9 ={8,9,12,48,1,2,3};
for (int i=0, j= mang9.length-1; i<j; i++,j--){
    int temp = mang9[i];
    mang9[i] = mang9[j];
    mang9[j] = temp;
}
// xuat mang
        System.out.println("mang sau dao nguoc la: ");
        System.out.println(Arrays.toString(mang9));
    }
}
