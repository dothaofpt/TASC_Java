
package JAVA_COLLECTION.B2;

import java.util.ArrayList;

public class ShoppingList {
    // ArrayList là một mảng có thể thay đổi kích thước
    public static void main(String[] args) {
        // Khởi tạo mảng thông thường
        String[] gioHangArray = {"Oi", "Dao"};

        // Khởi tạo ArrayList
        ArrayList<String> gioHang = new ArrayList<>();
        gioHang.add("Oi");
        gioHang.add("Dao");
        gioHang.add("Mit");

        // Thay đổi phần tử trong ArrayList
        gioHang.set(2, "Le");
        gioHang.remove(1);

        // Kiểm tra xem ArrayList có chứa phần tử "khoai tay" không
        System.out.println("Có khoai tây không? " + gioHang.contains("khoai tay"));

        // In ra các phần tử trong ArrayList
        System.out.println("Danh sách giỏ hàng:");
        for (String item : gioHang) {
            System.out.println(item);
        }
    }
}
