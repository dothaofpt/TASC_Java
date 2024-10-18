
package JAVA_CORE_BASIC.B4;

public class Employee {
    public void calculateSalary() {
        // Method của lớp cha
    }

    public static class FulltimeEmployee extends Employee {
        String name;
        double oneHourSalary;
        int numberWorkingDay;

        // Ghi đè phương thức của lớp cha
        public FulltimeEmployee(String name, double oneHourSalary, int numberWorkingDay) {
            this.name = name;
            this.oneHourSalary = oneHourSalary;
            this.numberWorkingDay = numberWorkingDay;
        }

        @Override
        public void calculateSalary() {
            double salary = oneHourSalary * numberWorkingDay;
            System.out.println(name + "'s salary is: " + salary);
        }
    }

    public static void main(String[] args) {
        FulltimeEmployee employee1 = new FulltimeEmployee("thu", 7.5, 30);
        employee1.calculateSalary(); // Gọi phương thức instance
    }
}
