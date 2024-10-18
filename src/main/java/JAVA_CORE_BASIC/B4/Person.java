
package JAVA_CORE_BASIC.B4;

//Vi du ve lop abstract
public abstract class Person {
    String name;
    String eat;
    int age;

    public Person(String name, String eat, int age) {
        this.name = name;
        this.eat = eat;
        this.age = age;
    }

    public void isWrite(String name, String eat) {
        System.out.println("Person Write: " + this.name + " and " + this.eat);
    }

    // Phương thức abstract mô tả hành động làm việc
    public abstract void work();
}
