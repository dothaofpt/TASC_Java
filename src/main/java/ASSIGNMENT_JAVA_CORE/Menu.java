package ASSIGNMENT_JAVA_CORE;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("--- Customer Manager Menu -------");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Tìm kiếm khách hàng");
            System.out.println("3. Cập nhật khách hàng");
            System.out.println("4. Hiển thị danh sách khách hàng");
            System.out.println("5. Xóa danh sách khách hàng");
            System.out.println("6. Thoát");
            System.out.print(" Chọn một tùy chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số điện thoại của khách hàng mới: ");
                    String newPhoneNumber = scanner.nextLine();
                    customerManager.AddCustomer(newPhoneNumber);
                    break;
                case 2:
                    System.out.print("Nhập số điện thoại của khách hàng cần tìm: ");
                    String searchPhoneNumber = scanner.nextLine();
                    customerManager.SearchCustomer(searchPhoneNumber);
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại của khách hàng cần cập nhật: ");
                    String updatePhoneNumber = scanner.nextLine();
                    customerManager.UpdateCustomer(updatePhoneNumber);
                    break;
                case 4:
                    customerManager.DisplayListCustomer();
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại của khách hàng cần xóa: ");
                    String  deletePhoneNumber = scanner.nextLine();
                    customerManager.deleteCustomer((deletePhoneNumber));
                    break;
                case 6:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
            System.out.println();
        } while (choice != 6);
    }
}

