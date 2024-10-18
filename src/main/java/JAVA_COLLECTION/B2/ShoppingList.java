package JAVA_COLLECTION.B2;

import java.util.ArrayList;

public class Array_List {
// Arraylist là một mảng có thể thay đổi kích thước

    public static void main(String[] args) {
        String[] gioHangArray = new String[2];
        gioHangArray[0] = "Oi";
        gioHangArray[1] = "Dao";

        ArrayList<String> gioHangArrayList = new ArrayList<>();
        gioHangArrayList.add("Oi");
        gioHangArrayList.add("Dao");
        gioHangArrayList.add("Mit");

        gioHangArrayList.set(2, "Le");
        gioHangArrayList.remove(1);
        System.out.println(gioHangArrayList.contains("khoai tay"));
        for(int i =0; i <gioHangArrayList.size(); i++){
            System.out.println(gioHangArrayList.get(i));

        }

    }



}
