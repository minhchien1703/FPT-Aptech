package managerPersonProgram;

import java.util.Scanner;

public class Main {
    static Person[] person;
    static int lenght = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagementPerson manager = new ManagementPerson();
        String name, address, salary;
        System.out.println("=====Manager Person Program=====");
        try {
            person = new Person[lenght];
            for (int i = 0; i < lenght; i++) {
                System.out.println("Input information of Person:" + (i + 1));
                System.out.println("Input Name:");
                name = scanner.nextLine();
                System.out.println("Input Address:");
                address = scanner.nextLine();
                System.out.println("Input Salary:");
                salary = scanner.nextLine();
                person[i] = manager.inputPersonInfo(name, address, salary);
                if (person[i] == null) {
                    throw new Exception ("Cannot add Person to array. Invalid information.");
                }
            }
            manager.sortBySalary(person);
            for (Person p : person) {
                manager.displayPersonInfo(p);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
