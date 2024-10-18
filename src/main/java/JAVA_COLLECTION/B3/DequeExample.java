
package JAVA_COLLECTION.B3;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        // Khởi tạo Deque sử dụng ArrayDeque
        Deque<String> danhSachSV = new ArrayDeque<>();

        // Thêm sinh viên vào cuối Deque
        danhSachSV.offer("Do Thao");
        danhSachSV.offer("Nguyen Van A");
        danhSachSV.offer("Tran Thi Lan");
        danhSachSV.offer("Duong Quynh Chau");

        // Thêm sinh viên vào đầu và cuối Deque
        danhSachSV.offerFirst("Hong Hai Nhi");
        danhSachSV.offerLast("Duong Tang");

        // Lấy và xóa sinh viên từ Deque
        while(true) {
            String ten = danhSachSV.poll(); // Lấy ra và xóa phần tử đầu tiên
            if(ten == null) {
                break; // Thoát vòng lặp nếu Deque rỗng
            }
            System.out.println(ten); // In tên sinh viên
        }
    }
}
