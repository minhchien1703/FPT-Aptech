package connect_db;

import connect_db.controller.PersonController;
import connect_db.dao.PersonDAO;
import connect_db.model.Person;
import connect_db.model.PersonDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pId;
        String lName;
        String fName;
        int age;

        Scanner scann = new Scanner(System.in);
        PersonController personController = new PersonController();
        List<Person> list = new ArrayList<>();
        PersonDAO personDAO = new PersonDAO();



        while(true) {
            System.out.println("\n=====DATABASE PERSON MANAGEMENT=====");
            System.out.println("1. Create new Person.");
            System.out.println("2. List all Person.");
            System.out.println("3. Find Person by ID.");
            System.out.println("4. Find Person by Name.");
            System.out.println("5. Update Person.");
            System.out.println("6. Remove Person.");
            System.out.println("7. Get orders detail(join 2 table).");
            System.out.println("8. Get orders detail into format.");
            System.out.println("9. Exist.");
            System.out.print("Enter choose: ");
            int choose = scann.nextInt();
            scann.nextLine();

            switch (choose) {
                case 1:
                    System.out.print("Enter Last Name: ");
                    lName = scann.nextLine();
                    System.out.print("Enter First Name: ");
                    fName = scann.nextLine();
                    System.out.print("Enter Age: ");
                    age = scann.nextInt();
                    scann.nextLine();
                    if (personController.createNewPerson(new Person(lName, fName, age))) {
                        System.out.println("Insert success.");
                    } else {
                        System.out.println("Insert fails.");
                    }
                    break;

                case 2:
                    List<Person> personAllList = personController.listAllPerson();
                    System.out.println("\n=====List Person info=====");
                    for (Person item : personAllList) {
                        item.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter ID Person: ");
                    Person person = personController.findPersonById(scann.nextInt());
                    System.out.println("\n=====Person info=====");
                    person.display();
                    break;

                case 4:
                    System.out.print("Enter Name Person: ");
                    List<Person> findNamePersonList = personController.findPersonByName(scann.nextLine());
                    System.out.println("\n=====Person info=====");
                    for (Person item : findNamePersonList) {
                        item.display();
                    }
                    break;

                case 5:
                    System.out.print("Enter ID Person update:");
                    pId = scann.nextInt();
                    scann.nextLine();
                    System.out.print("Enter Last Name: ");
                    lName = scann.nextLine();
                    System.out.print("Enter First Name: ");
                    fName = scann.nextLine();
                    System.out.print("Enter Age: ");
                    age = scann.nextInt();
                    scann.nextLine();
                    if (personController.updatePersonById(pId, lName, fName, age)) {
                        System.out.println("Update success.");
                    } else {
                        System.out.println("Update fails !");
                    }
                    break;

                case 6:
                    System.out.print("Enter Person delete: ");
                    if (personController.deletePerson(scann.nextInt())) {
                        System.out.println("Delete success.");
                    } else {
                        System.out.println("Fails !");
                    }
                    scann.nextLine();
                    break;

                case 7:
                    List<PersonDTO> listDTO = new ArrayList<>();
                    listDTO = personDAO.getTableInnerJoin();
                    System.out.println("\n=====Order info=====");
                    for (PersonDTO item : listDTO) {
                        item.display();
                    }
                    break;

                case 8:
                    System.out.println("\n=====Json format=====");
                    String jsonFormat = personController.getJsonFormat();
                    System.out.println(jsonFormat);
                    break;

                case 9:
                    System.out.println("Goodbye.");
                    return;

                default:
                    System.out.println("Choose 1 to 9 !");

            }
        }



    }
}
