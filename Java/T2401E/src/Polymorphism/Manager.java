package Polymorphism;

import java.util.Scanner;

public class Manager extends Person {
    public String departments;

    public Manager() {}

    public Manager(String name, String email, String numberPhone, double salary, String departments) {
        super(name, email, numberPhone, salary);
        this.departments = departments;
    }

    public double getSalary() {
        return  3 * this.salary;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name:");
        this.name = scanner.nextLine();
        System.out.print("Enter email:");
        this.email = scanner.nextLine();
        System.out.print("Enter numberPhone:");
        this.numberPhone = scanner.nextLine();
        System.out.print("Enter salary:");
        this.salary = scanner.nextDouble();
        System.out.print("Enter departments:");
        this.departments = scanner.nextLine();
    }
}
