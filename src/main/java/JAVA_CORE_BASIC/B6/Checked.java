package B6;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Checked {
    public static void main(String[] args) {

    }
    private  static void readFile (String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Hey that file doesn't exist!");

        }
    }
}
