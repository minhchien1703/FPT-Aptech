package demo;

import java.util.Scanner;

public class Person {
    Scanner in = new Scanner(System.in);

    public String name;
    public String email;
    public int numberPhone;

    public Wallet wallet = new Wallet();

    public Person (String name, String email, int numberPhone) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public void display() {
        System.out.println("\nName: " + this.name + "\nEmail: " + this.email + "\nPhone: " + this.numberPhone);
    }

    public int calcTotal() {
        System.out.println("Input number of bill:");
        int size = in.nextInt();
        int[] bills = new int[size];
        int moneyAmount = 0;
        for (int i = 0; i < bills.length; i++) {
            System.out.println("Input value of bill " + (i + 1) + ":");
            bills[i] = in.nextInt();
            moneyAmount += bills[i];
        }
        return moneyAmount;
    }

    public boolean payMoney(int total) {
        if (total != 0) {
            wallet.amount = wallet.amount - total;
            return true;
        }
        return false;
    }

    public class Wallet {
        private int amount;

        public boolean setMoneyAmount(int amount) {
            System.out.println("Input value of wallet:");
            this.amount = in.nextInt();
            if (this.amount != 0) {
                return true;
            }
            return false;
        }

        public boolean acceptMoney(int amount) {
            if (this.amount >= amount) {
                return true;
            }
            return false;
        }

    }

}
