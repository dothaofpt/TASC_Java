package JAVA_CORE_BASIC.B6;

public class Throw {
//    được sử dụng để tạo ra 1 ngoại lệ cụ thể và đẩy nó ra khỏi phương thức hiện tại
public static void main(String[] args) {
    String personName = null;
    doDaiString(personName);

}
public static  void doDaiString(String chuoi) {
    if(chuoi == null){
        throw new NullPointerException("Chuoi khong duoc phep null");

    }
    System.out.println("do dai cua chuoi la:" + chuoi.length());

}

}
