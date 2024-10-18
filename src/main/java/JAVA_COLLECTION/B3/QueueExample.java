
package JAVA_COLLECTION.B3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Queue đại diện cho danh sách sinh viên đang xếp hàng
        Queue<String> danhSachSV = new LinkedList<>();

        // Thêm sinh viên vào hàng đợi (FIFO)
        danhSachSV.offer("Do Thao");
        danhSachSV.offer("Nguyen Binh Minh");
        danhSachSV.offer("Nguyen Binh Lien");
        danhSachSV.offer("Nguyen Binh Thanh");

        // Lấy sinh viên ra khỏi hàng đợi cho đến khi hết
        while (true) {
            String ten = danhSachSV.poll(); // Lấy ra và xóa phần tử đầu tiên
            if (ten == null) {
                break; // Thoát vòng lặp nếu hàng đợi rỗng
            }
            System.out.println(ten); // In tên sinh viên
        }
    }
}
