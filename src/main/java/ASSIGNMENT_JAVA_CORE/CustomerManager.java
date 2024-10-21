
package ASSIGNMENT_JAVA_CORE;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    // Tao 1 danh sach khach hang
            private List<Customer> customers = new ArrayList<>();
    private final String filePath = "customers.txt";

    // Constructor de tai du lieu tu file khi khoi tao
    public CustomerManager() {
        loadCustomersFromFile();  // Tai danh sach khach hang tu file
    }

    // Hien thi danh sach khach hang
    public void DisplayListCustomer() {
        if (customers.isEmpty()) {
                    System.out.println("Danh sach khach hang trong.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Them khach hang moi
    public void AddCustomer(String phoneNumber) {
        if (isPhoneNumberExists(phoneNumber)) {
            System.out.println("So dien thoai da ton tai.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten khach hang: ");
        String name = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        String address = scanner.nextLine();

        if (name.isEmpty() || address.isEmpty() || !isValidEmail(email)) {
                     System.out.println("Thong tin khong hop le.");
            return;
        }

        Customer newCustomer = new Customer(name, email, phoneNumber, address);
        customers.add(newCustomer);
        System.out.println("Khach hang da duoc them thanh cong!");
        saveCustomersToFile();
    }

    // Tim kiem khach hang
    public void SearchCustomer(String phoneNumber) {
        for (Customer customer : customers) {
            //search theo so dien thoai
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Khach hang da tim thay: " + customer);
                       return;
            }
        }
        System.out.println("Khong tim thay khach hang voi so dien thoai: " + phoneNumber);
    }

    // Cap nhat khach hang
    public void UpdateCustomer(String phoneNumber) {
        // loc vong for de in ra thong tin hien  tai cua khách hàng
        for (Customer customer : customers) {
            // tim khach hàng theo sdt
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Thong tin hien tai cua khach hang: " + customer);

                // update lại thông tin khách hàng
                System.out.print("Nhap ten moi : ");
                String newName = scanner.nextLine();
                    if (!newName.isEmpty()) customer.setName(newName);

                System.out.print("Nhap email moi  : ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty() && isValidEmail(newEmail)) customer.setEmail(newEmail);

                System.out.print("Nhap dia chi moi : ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isEmpty()) customer.setAddress(newAddress);

                System.out.println("Thong tin khach hang da duoc cap nhat thanh cong!");
                saveCustomersToFile();
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi so dien thoai: " + phoneNumber);
    }

    // Xoa khac h hang
    public void deleteCustomer(String phoneNumber) {
        Customer customerToRemove = null;
        // loc customers
        for (Customer customer : customers) {
            // lấy sdt làm dk xóa khách hàng
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                        customerToRemove = customer;
                break;
            }
        }

        if (customerToRemove != null) {
            customers.remove(customerToRemove);
            saveCustomersToFile();
            System.out.println("Xoa khach hang thanh cong.");
        }          else {
            System.out.println("Khong tim thay khach hang.");
        }
    }

    // Luu danh sach khach hang vao file
    private void saveCustomersToFile() {
        // luu file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber() + "," + customer.getAddress());
                writer.newLine();
            }
            System.out.println("Du lieu da duoc luu vao file thanh cong!");
        }            catch (IOException e) {
            System.out.println("Da xay ra loi khi luu du lieu: " + e.getMessage());
        }
    }

    // Tai danh sach khach hang tu file
    private void loadCustomersFromFile() {
        // doc file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                       String[] data = line.split(",");
                if (data.length == 4) {
                          customers.add(new Customer(data[0], data[1], data[2], data[3]));
                }
            }
            System.out.println("Du lieu da duoc tai tu file thanh cong!");
        }          catch (IOException e) {
            System.out.println("Da xay ra loi khi tai du lieu: " + e.getMessage());
        }
    }

    // Kiem tra so dien thoai da ton tai chua
    private boolean isPhoneNumberExists(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // Kiem tra email hop le
    private boolean isValidEmail(String email) {
             return email.contains("@") && email.contains(".");
    }
}
