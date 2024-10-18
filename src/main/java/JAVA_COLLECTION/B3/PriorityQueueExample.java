
package JAVA_COLLECTION.B3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Khởi tạo PriorityQueue cho danh sách sinh viên
        Queue<String> danhSachSV = new PriorityQueue<>();

        // Thêm sinh viên vào PriorityQueue
        // Các phần tử sẽ được sắp xếp tự động theo thứ tự tự nhiên (alphabet)
        danhSachSV.offer("Do Thao");
        danhSachSV.offer("Nguyen Binh Minh");
        danhSachSV.offer("Mai Tuong Van");
        danhSachSV.offer("Do Thuy Hien");

        // Lấy sinh viên ra khỏi PriorityQueue theo thứ tự đã sắp xếp
        while (true) {
            String ten = danhSachSV.poll(); // Lấy ra và xóa phần tử đầu tiên trong PriorityQueue
            if (ten == null) {
                break; // Thoát vòng lặp nếu PriorityQueue rỗng
            }
            System.out.println(ten); // In tên sinh viên
        }
    }
}
