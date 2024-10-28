
package ASSIGNMENT_JAVA_CORE;

import java.util.Scanner;

public class Menu {
    private CustomerManager customerManager;
    private Scanner scanner;

    public Menu() {
        customerManager = new CustomerManager();
        scanner = new Scanner(System.in);
    }

    // Hiển thị menu và xử lý lựa chọn
    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Menu Quản Lý Khách Hàng ---");
            System.out.println("1. Xem danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng"); // Thêm lựa chọn tìm kiếm
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    customerManager.displayCustomers();
                    break;
                case 2:
                    customerManager.addCustomer();
                    break;
                case 3:
                    customerManager.editCustomer();
                    break;
                case 4:
                    customerManager.deleteCustomer();
                    break;
                case 5:
                    customerManager.searchCustomerByPhone(); // Gọi phương thức tìm kiếm
                    break;
                case 6:
                    System.out.println("Thoát khỏi chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    // Phương thức main để khởi động chương trình
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.customerManager.generateCustomerData(500000); // tao 5000 khach hang khi dc goi
        System.out.println("Đã tạo 5000 dữ liệu khách hàng và lưu vào file.");
        menu.displayMenu(); //hien thi menu
    }
}
