package JAVA_COLLECTION.B2;

import java.util.ArrayList;
import java.util.List;

// List interface
public class TaskManager {
    private List<String> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Thêm công việc
    public void addTask(String task) {
        tasks.add(task);
    }

    // Hiển thị các công việc
    public void displayTasks() {
        System.out.println("Danh sách công việc:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Xóa công việc theo chỉ số
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Chỉ số không hợp lệ.");
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Thêm công việc
        manager.addTask("Hoàn thành bài tập");
        manager.addTask("Đi chợ");
        manager.addTask("Tập thể dục");

        // Hiển thị công việc
        manager.displayTasks();

        // Xóa công việc
        manager.removeTask(1);

        // Hiển thị lại danh sách công việc
        manager.displayTasks();
    }
}

