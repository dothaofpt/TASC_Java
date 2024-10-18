package JAVA_CORE_BASIC.B4;
// method Overloading
public class Rectangle {
   int length;

    public Rectangle(int length) {
        this.length = length;
    }


//    Dung tham so cua method
    public  int area(int length){
        return length*length;
    }
    public double area(double length){
 return length*length;
    }

    public static void main(String[] args) {
        Rectangle hinhchunhat = new Rectangle(4);
        System.out.println(hinhchunhat.area(4.5));
        System.out.println(hinhchunhat.area(4));
    }
}
