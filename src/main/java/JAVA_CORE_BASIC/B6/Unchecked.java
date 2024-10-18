package JAVA_CORE_BASIC.B6;

public class Unchecked {
    public static void main(String[] args) {
        String name = null;
        printLength(name);
    }
    private static void printLength (String myString){
        try {
            System.out.println(myString.length());
        }
        catch (NullPointerException e) {
            System.out.println("String khong duoc null");
        }
    }
}
