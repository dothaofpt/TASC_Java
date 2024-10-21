package DESIGNPATTERN.FACTORY_METHOD;

public class PetFactory {


    // xac dinh loai thu cung can tao( dog and cat)
    public Pet create(String type) throws IllegalAccessException {
        if (type.equalsIgnoreCase("Dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("Cat")) {
            return new Cat();

        }else{
            throw new IllegalAccessException("Unknown pet type");
        }
    }
    // tao ra hai doi tuong dog va cat
    public static void main(String[] args) throws IllegalAccessException {
//        tạo object factory
        PetFactory factory =new PetFactory();
        // su dung phuong thuc ben tren de tao doi tuong object  cua dog and cat
        Pet pet1 = factory.create("Dog");
        System.out.println("Pet1 : " +pet1.makeSound());
        Pet pet2 = factory.create("Cat");
        System.out.println("Pet2 : "+pet2.makeSound());
    }
}
