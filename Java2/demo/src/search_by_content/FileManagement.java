package search_by_content;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManagement {
    String fileName = "";

    public int countWordInFile(String fileSource, String word) throws Exception {
        if (fileSource == null)
            throw new Exception("Path null !");
        if (word == null)
            throw new Exception("Word null !");

        BufferedReader br = new BufferedReader(new FileReader(fileSource));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        Pattern patFile = Pattern.compile(word);
        Matcher matFile = patFile.matcher(sb);
        int count = 0;
        while (matFile.find()) {
            count++;
        }
        return count;
    }

    public List<String> getFileNameContiansWordInDiractory(String source, String word) throws Exception {
        if (source == null)
            throw new Exception("Source null !");
        if (word == null)
            throw new Exception("Word null !");

        List<String> list = new ArrayList<>();
        try {
            File folder = new File(source);
            File fileName[] = folder.listFiles();

            for (File item : fileName) {
                String filePath = item.getAbsoluteFile().getAbsolutePath();
                if (this.checkWordInFile(filePath, word)) {
                    list.add(filePath);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean checkWordInFile(String fileName, String word) {
        String content = "";
        try {
            content = this.readFile(fileName);

            Pattern pat = Pattern.compile(word);
            Matcher mat = pat.matcher(content);

            if (mat.find()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
