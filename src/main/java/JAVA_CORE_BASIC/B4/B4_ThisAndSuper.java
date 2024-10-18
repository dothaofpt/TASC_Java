
package B4;

public class B4_ThisAndSuper {
    // Ví dụ về this và super
    public static class Dog {
        String name;
        int price;
        int age;

        public Dog(String name, int price, int age) {
            this.name = name;
            this.price = price;
            this.age = age;
        }

        public void isTalk() {
            System.out.println(this.name + " is talking: Goul Goul");
        }
    }

    // Lớp con kế thừa từ lớp Dog
    public static class Poodle extends Dog {
        String color;

        // Constructor của lớp con sử dụng super để gọi constructor của lớp cha
        public Poodle(String name, int price, int age, String color) {
            super(name, price, age);
            this.color = color;
        }

        // Phương thức của lớp con sử dụng super để gọi phương thức của lớp cha
        @Override
        public void isTalk() {
            super.isTalk();
            System.out.println(this.name + " is saying: Woof Woof!");
        }

        public void displayColor() {
            System.out.println(this.name + " is " + this.color);
        }
    }

    public static void main(String[] args) {
        Dog chiba = new Dog("Chiba", 100, 2);
        chiba.isTalk();

        Poodle bella = new Poodle("Bella", 150, 3, "white");
        bella.isTalk();
        bella.displayColor();
    }
}
