
package ASSIGNMENT_JAVA_CORE;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class CustomerManager {
    private Map<String, Customer> customerMap;
    private final String filePath = "customers.txt";
    private final ExecutorService executorService;
    private Scanner scanner;

    public CustomerManager() {
        customerMap = new ConcurrentHashMap<>(); // Sử dụng ConcurrentHashMap cho an toàn khi đa luồng
        executorService = Executors.newFixedThreadPool(1);
        scanner = new Scanner(System.in);
        loadFromFile();
    }

    // Xem danh sách khách hàng
    public void displayCustomers() {
        logExecutionTime("hiển thị khách hàng", () -> {
            if (customerMap.isEmpty()) {
                System.out.println("Danh sách khách hàng trống.");
            } else {
                System.out.printf("%-20s %-30s %-15s%n", "Tên", "Email", "Số điện thoại");
                System.out.println("---------------------------------------------------------------");
                customerMap.values().forEach(customer -> System.out.printf("%-20s %-30s %-15s%n",
                        customer.getName(), customer.getEmail(), customer.getPhoneNumber()));
            }
        });
    }

    // Thêm khách hàng mới
    public void addCustomer() {
        while (true) {
            System.out.print("Nhập tên khách hàng (hoặc nhập 'e' để thoát): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("e")) {
                break;
            }

            String email;
            while (true) {
                System.out.print("Nhập email khách hàng: ");
                email = scanner.nextLine();
                if (isValidEmail(email)) {
                    break; // Lặp đến khi nào nhập đúng
                } else {
                    System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
                }
            }

            String phoneNumber;
            while (true) {
                System.out.print("Nhập số điện thoại khách hàng: ");
                phoneNumber = scanner.nextLine();

                if (customerMap.containsKey(phoneNumber)) {
                    System.out.println("Số điện thoại đã tồn tại. Vui lòng nhập số điện thoại khác.");
                } else if (isValidPhoneNumber(phoneNumber)) {
                    break; // Lặp đến khi nào nhập đúng
                } else {
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                }
            }

            Customer customer = new Customer(name, email, phoneNumber);
            customerMap.put(phoneNumber, customer);
            executorService.submit(() -> saveToFilePartially(customer)); // Ghi dữ liệu mới trong đa luồng
            System.out.println("Khách hàng đã được thêm thành công.");
        }
        System.out.println("Đã thoát khỏi chế độ thêm khách hàng.");
    }

    // Sửa thông tin khách hàng
    public void editCustomer() {
        logExecutionTime("sửa thông tin khách hàng", () -> {
            String phoneNumber = "";
            boolean customerExists = false;

            while (!customerExists) {
                System.out.print("Nhập số điện thoại khách hàng cần sửa: ");
                phoneNumber = scanner.nextLine();

                if (!customerMap.containsKey(phoneNumber)) {
                    System.out.println("Khách hàng không tồn tại. Vui lòng nhập lại.");
                } else {
                    customerExists = true;
                }
            }

            System.out.print("Nhập tên khách hàng mới(không bắt buộc): ");
            String newName = scanner.nextLine();
            System.out.print("Nhập email khách hàng mới(không bắt buộc): ");
            String newEmail = scanner.nextLine();
            System.out.print("Nhập số điện thoại khách hàng mới (không bắt buộc): ");
            String newPhoneNumber = scanner.nextLine();

            Customer customer = customerMap.get(phoneNumber);

            if (!newName.isEmpty()) {
                customer.setName(newName);
            }
            if (!newEmail.isEmpty()) {
                if (!isValidEmail(newEmail)) {
                    System.out.println("Email không hợp lệ. Không được cập nhật.");
                } else {
                    customer.setEmail(newEmail);
                }
            }
            if (!newPhoneNumber.isEmpty()) {
                if (customerMap.containsKey(newPhoneNumber)) {
                    System.out.println("Số điện thoại mới đã tồn tại. Không được cập nhật.");
                } else {
                    customerMap.remove(phoneNumber);
                    customer.setPhoneNumber(newPhoneNumber);
                    customerMap.put(newPhoneNumber, customer);
                }
            }

            executorService.submit(this::saveToFile); // Ghi dữ liệu đã sửa trong đa luồng
            System.out.println("Thông tin khách hàng đã được cập nhật thành công.");
        });
    }

    // Lưu thông tin khách hàng mới vào file
    private void saveToFilePartially(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Bật chế độ ghi nối (append mode)
            writer.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }

    // Lưu toàn bộ thông tin khách hàng vào file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) { // Ghi đè lên file
            for (Customer customer : customerMap.values()) {
                writer.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                writer.newLine();
            }
            System.out.println("Tất cả dữ liệu đã được lưu vào file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu vào file: " + e.getMessage());
        }
    }

    // Tải dữ liệu khách hàng từ file
    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Tạo tệp nếu nó không tồn tại
                System.out.println("Tệp không tồn tại. Tệp mới đã được tạo.");
            } catch (IOException e) {
                System.out.println("Lỗi khi tạo tệp: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    Customer customer = new Customer(data[0], data[1], data[2]);
                    customerMap.put(customer.getPhoneNumber(), customer);
                }
            }
            System.out.println("Dữ liệu đã được tải từ file thành công.");
        } catch (IOException e) {
            System.out.println("Không thể tải dữ liệu từ file: " + e.getMessage());
        }
    }

    // Xóa khách hàng
    public void deleteCustomer() {
        System.out.print("Nhập số điện thoại khách hàng cần xóa: ");
        String phoneNumber = scanner.nextLine();

        if (!customerMap.containsKey(phoneNumber)) {
            System.out.println("Khách hàng không tồn tại.");
            return;
        }

        customerMap.remove(phoneNumber);
        executorService.submit(this::saveToFile); // Ghi dữ liệu đã xóa trong đa luồng
        System.out.println("Khách hàng đã được xóa thành công.");
    }

    // Tìm kiếm khách hàng theo số điện thoại
    public void searchCustomerByPhone() {
        while (true) {
            System.out.print("Nhập số điện thoại khách hàng cần tìm (hoặc 'e' để thoát): ");
            String phoneNumber = scanner.nextLine();

            if (phoneNumber.equalsIgnoreCase("e")) {
                System.out.println("Đã thoát tìm kiếm khách hàng.");
                break;
            }

            Customer customer = customerMap.get(phoneNumber);

            if (customer != null) {
                System.out.printf("Khách hàng tìm thấy:%nTên: %s, Email: %s, Số điện thoại: %s%n",
                        customer.getName(), customer.getEmail(), customer.getPhoneNumber());
                break; // Thoát khỏi vòng lặp khi tìm thấy khách hàng
            } else {
                System.out.println("Không tìm thấy khách hàng với số điện thoại đã nhập. Vui lòng thử lại.");
            }
        }
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\d{10}$");
    }

    public void generateCustomerData(int numberOfCustomers) {
        Random random = new Random();
        String[] names = {"Nguyen", "Tran", "Le", "Pham", "Hoang", "Ngoc", "Bui", "Vu", "Dang", "Ngo"};
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "fpt.edu.vn"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < numberOfCustomers; i++) {
                String name = names[random.nextInt(names.length)] + " " + (random.nextInt(100) + 1);
                String email = name.toLowerCase().replace(" ", "") + "@" + domains[random.nextInt(domains.length)];
                String phoneNumber = String.valueOf(1000000000 + random.nextInt(900000000)); // 10 chữ số

                Customer customer = new Customer(name, email, phoneNumber);
                customerMap.put(phoneNumber, customer);
                writer.write(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                writer.newLine();
            }
            System.out.println("Dữ liệu khách hàng đã được tạo thành công với " + numberOfCustomers + " khách hàng.");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo dữ liệu khách hàng: " + e.getMessage());
        }
    }

    // Đo thời gian thực hiện và ghi log
    private void logExecutionTime(String actionName, Runnable action) {
        long startTime = System.currentTimeMillis();
        action.run();
        long endTime = System.currentTimeMillis();
        System.out.printf("Thời gian thực hiện '%s': %d ms%n", actionName, endTime - startTime);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
