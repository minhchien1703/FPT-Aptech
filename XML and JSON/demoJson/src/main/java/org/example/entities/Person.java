package org.example.entities;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name = "name")
    private String name;

    @XmlTransient
    private int age;

    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "phone")
    private String phone;

    public Person() {}

    public Person(String name, int age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "\nname: " + name + "\n" +
                "age: " + age + "\n" +
                "gender: " + gender + "\n" +
                "phone: " + phone + "\n";
    }

}
