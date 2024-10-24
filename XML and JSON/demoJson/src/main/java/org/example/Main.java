package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Person;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Thanh", 23, "male", "018321031");
        Person person2 = new Person("Hoa", 45, "female", "018321031");
        Person person3 = new Person("Thang", 22, "male", "018321031");
        Person person4 = new Person("Hoang", 24, "male", "018321031");
        Person person5 = new Person("Minh", 26, "male", "018321031");

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        objectToJson(list);
        jsonToObject();


    }

    private static void objectToJson(List<Person> personList) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(personList);
            objectMapper.writeValue(new File("person.json"), personList);
            System.out.println("List person as to json success. ");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void jsonToObject() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> personList = objectMapper.readValue(new File("person.json"), new TypeReference<List<Person>>(){});
            for (Person person : personList) {
                System.out.println(person.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}