package JAVA_COLLECTION.B2;

import java.util.Iterator;
import java.util.LinkedList;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class StudentList {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();

        // Thêm sinh viên vào danh sách
        studentList.add(new Student(1, "Alice"));
        studentList.add(new Student(2, "Bob"));
        studentList.add(new Student(3, "Charlie"));

        // Hiển thị danh sách sinh viên
        printStudentList(studentList);

        // Xóa sinh viên khỏi danh sách
        studentList.remove(1); // Xóa sinh viên có chỉ số 1 (Bob)

        // Hiển thị lại danh sách sinh viên sau khi xóa
        printStudentList(studentList);
    }

    private static void printStudentList(LinkedList<Student> studentList) {
        System.out.println("Danh sách sinh viên:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
