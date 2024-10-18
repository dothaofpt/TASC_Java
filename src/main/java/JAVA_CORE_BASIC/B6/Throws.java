package JAVA_CORE_BASIC.B6;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Throws {
//    throws: được sử dụng khi khai báo một phương thức để nói rằng phương thức cso thể gây ra một hoặc nhiều loại ngoại lệ
public static void main(String[] args) throws FileNotFoundException {
//    nếu phương thức không được tìm thấy thì ngọai lệ sẽ được ném ra
    docFile("ggdoc.txt");
}
public static void docFile(String tenFile) throws FileNotFoundException {
    FileReader reader =new FileReader(tenFile);
}
}
