package search_by_content;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileManagement file = null;
        while (true) {
            System.out.println("=====WORD PROGRAM=====");
            System.out.println("1. Count word in file.");
            System.out.println("2. Find file by word.");
            System.out.println("3. Exit.");
            System.out.print("Enter choose: ");
            int choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    try {
                        System.out.println("=====COUNT WORD=====");
                        System.out.print("Enter path: ");
                        String path = scanner.nextLine();
                        System.out.print("Enter word: ");
                        String word = scanner.nextLine();
                        System.out.println("Bout: " + file.countWordInFile(path, word));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("=====FIND FILE BY WORD=====");
                        System.out.print("Enter source: ");
                        String source = scanner.nextLine();
                        System.out.print("Enter word: ");
                        String word = scanner.nextLine();
                        List<String> list = file.getFileNameContiansWordInDiractory(source, word);

                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    return;
            }



        }

    }
}
