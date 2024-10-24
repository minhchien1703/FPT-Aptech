package demo;

public class Student {
    public String name;
    public int age;
    public String email;
    private int numberPhone;

    public void run() {
        System.out.println("Runing 5km/h...");
    }

    public void run(String msg) {
        System.out.println("Runing 10km/h...");
    }
    public void run(int n) {
        System.out.println("Runing 15km/h...");
    }
}
