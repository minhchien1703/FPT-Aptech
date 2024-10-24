package Polymorphism;

public abstract class Person {
    public String name;
    public String email;
    public String numberPhone;
    public double salary;

    public Person(){}

    public Person(String name, String email, String numberPhone, double salary) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
        this.salary = salary;
    }

    public abstract double getSalary();

    public abstract void inputData();

}
