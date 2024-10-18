
// Class and Instance
package JAVA_CORE_BASIC.B4;
public  class Fruits {
    String name;
    int price;
    String color;

    public Fruits(String name, int price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public static void main(String[] args) {
//        đây là instance của class fruit
        Fruits apple = new Fruits("quatao",8,"Red");
    }
}
