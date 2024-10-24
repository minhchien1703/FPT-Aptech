package Polymorphism;

import java.util.Scanner;

public class Emp extends Person {
    public String skill;

    public Emp() {}

    public Emp (String name, String email, String numberPhone, double salary, String skill) {
        super(name, email, numberPhone, salary);
        this.skill = skill;
    }

    public double getSalary() {
        return 2 * this.salary;
    }

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
        System.out.print("Enter skill:");
        this.skill = scanner.nextLine();
    }
}
