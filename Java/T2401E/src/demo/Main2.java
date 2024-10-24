package demo;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Person person = new Person("Jack", "jack@gmail.com", 12312313);
        Person.Wallet wallet = person.wallet;

        System.out.println("=====SHOPPING PROGRAM=====");
        int amountMoneyAllBill = person.calcTotal();
        if (wallet.setMoneyAmount(0) == true && wallet.acceptMoney(amountMoneyAllBill) == true) {
            System.out.println("It is total of bill:"+amountMoneyAllBill);
            System.out.println("You can by it! Choose Y to Pay.");
            String y = in.next();
            if (y.equals("y")) {
                if (person.payMoney(amountMoneyAllBill) == true) {
                    System.out.println("Pay successful!");
                }
            } else {
                System.err.println("Pay failed!");
            }

        } else {
            System.out.println("It is total of bill:"+amountMoneyAllBill);
            System.out.println("You don't have enough money");
        }



    }
}
