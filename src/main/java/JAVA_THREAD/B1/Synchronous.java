package JAVA_THREAD.B1;

import java.io.*;

public class Synchronous {

    public static void main(String[] args) {
        //   Duong dan den file doc
        String filePath = "C:/Users/PC/Videos/TASC_Java/src/main/java/JAVA_THREAD/B1/file.txt";
//    Tao doi tuong  FileReader va ButferdReader
        try(FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
//        Doc tung dong cho den khi ket thuc file
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }


        try(FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter)){
//     Su dung BufferedWriter de ghi du lieu
            bufferedWriter.write("Mot ngay xui xeo");
            bufferedWriter.newLine(); // de ghi 1 dong moi
            bufferedWriter.write("Chi mong binh yen");
            bufferedWriter.newLine();
            bufferedWriter.write("cuoc doi thanh than");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
