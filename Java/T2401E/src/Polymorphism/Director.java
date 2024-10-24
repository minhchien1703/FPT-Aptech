package Polymorphism;

import java.util.Scanner;

public class Director extends Person {
      public String position;

    public Director() {}

    public  Director(String name, String email, String numberPhone, double salary, String position) {
        super(name, email, numberPhone, salary);
        this.position = position;
    }

    public double getSalary() {
        return 5 * this.salary;
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
        System.out.print("Enter position:");
        this.position = scanner.nextLine();
    }

}
