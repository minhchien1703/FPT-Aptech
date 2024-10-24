package demo;

import java.util.Scanner;

public class Main {
    public static void
    main(String[] args) {
//        System.out.println("hello world!");
        Scanner scanner = new Scanner(System.in);

        Student s = new Student();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.email);

        s.run();
        s.run("chay nhanh");
        s.run(15);

        Main.sayhi();
        Main m = new Main();
        m.sayHello();

        car c = new car();
        c.setColor("Yellow");
        c.setSpeed(300);
        c.display();
        c.inputData();
        c.display();

        car c2 = new car("Black", 100);
        c2.display();

        System.out.println("Enter n = ");
        int n = scanner.nextInt();
        Main.prime(n);
    }

    public static void sayhi() {
        System.out.println("Hi!");
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public static void prime(int n) {
        int flag = 0;
        if (n > 2) {
            for (int i = 2; i * i <= n; i++) {
                System.out.println(i);
                if (n % i == 0) {
                    System.out.println(i);
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0 && n >= 2) {
            System.out.println(n+" Is Prime.");
        } else {
            System.out.println(n+" Is Not Prime.");
        }
    }

}














