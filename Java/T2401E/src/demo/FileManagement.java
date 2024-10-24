package demo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManagement {

    public void Readfile(String pathFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(pathFile));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

}
