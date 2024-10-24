package assignment1;

import java.util.Scanner;

public class Main {
    /**
     * @param args default parameter
     */
    public static void main(String[] args) {
        System.out.println("===== Analysis Path Program =====");
        try (Scanner scanIn = new Scanner(System.in)) {
            System.out.println("Please input Path:");
            FileName analysitPath = new FileName(scanIn.nextLine(),
                    ':', '\\', '.');
            System.out.println("----- Result Analysis -----");
            System.out.printf("Disk:%s\n", analysitPath.getDisk());
            System.out.printf("Extension:%s\n", analysitPath.getExtension());
            System.out.printf("File Name:%s\n", analysitPath.getFilename());
            System.out.printf("Path:%s\n", analysitPath.getPath());
            System.out.print("Folders:");
            for (String item : analysitPath.getFolders()) {
                System.out.printf("[%s]", item);
            }
        }
    }
}
