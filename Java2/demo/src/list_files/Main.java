package list_files;

import java.io.File;

public class Main {

    public static void listExtension(File path) {
        try {

            File listFileName[] = path.listFiles();

            for (File item : listFileName) {
                String filePath = item.getAbsoluteFile().getAbsolutePath();
                if (filePath.endsWith(".txt") && item.isFile()) {
                    System.out.println(filePath);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   public static void listAllFileInFolder(File path) {
       try {
           File listFileName[] = path.listFiles();

           for (File item : listFileName) {
               System.out.println(item.getAbsolutePath());

               if (item.isDirectory()) {
                   listAllFileInFolder(item);
               }
           }

       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }

    public static void main(String[] args) {

        File folder = new File("C:\\doc");
//        listExtension(folder);
        listAllFileInFolder(folder);


    }
}
