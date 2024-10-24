package Polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonManagement {
    List<Person> list;

    public PersonManagement() {
        list = new ArrayList<>();
    }

    public void create () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Input Director:");
        System.out.println("2. Input Manager:");
        System.out.println("3. Input Employee:");
        System.out.print("Enter your choose:");
        Person person = null;

        int choose;
        choose = scanner.nextInt();
        switch (choose) {
                case 1:
                    person = new Director();
                    break;
                case 2:
                    person = new Manager();
                    break;
                case 3:
                    person = new Emp();
                    break;
        }
        person.inputData();
        list.add(person);
    }

    public double totalSalaryOfPerson() {
        double total = 0;
        for (Person item : list) {
            total += item.getSalary();
        }
        return total;
    }
}
