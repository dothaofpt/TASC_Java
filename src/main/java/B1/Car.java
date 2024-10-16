package B1;

class Car {

    String name;
    String color;
    int price;

    public Car(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
    public static void main(String[] args) {
        //        Cac kieu du lieu nguyen thuy thuong dung
        int a = 2;
        float b = 2.5f;
        double c = 2.5;
        boolean istrue =true;
        char kytu = 'W';
        System.out.println("Kieu du lieu nguyen thuy:");
        System.out.println("Int :"+a +"\nFloat: "+b + "\nDouble:"+c + "\nBoolean: " +istrue+"\nChar: "+kytu);
// Object do người dùng tạo ra
        Car mazda = new Car("mazdas3","white",503);
        System.out.println("kieu du lieu object: " +mazda);
    }

}