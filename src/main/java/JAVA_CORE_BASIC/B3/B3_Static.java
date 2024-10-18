package JAVA_CORE_BASIC.B3;

public class B3_Static {
//    Giờ thì hãy tạo ra 1 lớp với biến static và static method
//    Ví dụ : có 1 cái bảng đen, tất cả học sinh có thể viết vào bảng đó (static and method static)
//    Non-static: các học sinh đều có quyển sách để ghi chép , những kiến thức riêng của mình

    static String blackBoard;
    static  void WriteBlackBoard(String student, String content){
        blackBoard = student +" Write " + content+"\n";
    }

public static class Student{
     String name;
     int age;
     String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
// vì phương thức WriteBlackBoard static nên ta có thể gọi trong class Student(su dung luon duoc class de goi method thay vi tao object)
    public  void writeOnBlackBoard(String content) {
        B3_Static.WriteBlackBoard(this.name,content);
    }
}

    public static void main(String[] args) {
        Student student = new Student("Thao",19,"T2307M");
// Student writing on the blackboard
        student.writeOnBlackBoard("Hello, everyone!");
        System.out.println("Blackboard: \n"+B3_Static.blackBoard);
    }



}
