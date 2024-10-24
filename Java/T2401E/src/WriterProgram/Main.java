package WriterProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\doc\\new.txt.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
