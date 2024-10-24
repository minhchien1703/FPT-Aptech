package Polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonManagement personManagement = new PersonManagement();
        personManagement.create();
        System.out.println(personManagement.totalSalaryOfPerson());
    }
}
