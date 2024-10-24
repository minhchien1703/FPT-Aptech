package validate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number phone: ");
        String phone = sc.nextLine();
        Validation validation = new Validation();
        try {
            validation.valid(phone);
            System.out.println("Enter date: ");
            String date = sc.nextLine();
            validation.checkDate(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
