package threads;

import java.util.StringTokenizer;

public class ConnectDBMain {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
//        sb.append("SELECT *");
//        sb.append("FROM table");
//        sb.append("WHERE id = 1");

        String fullPath = "E:\\asdas\\asdasd\\asdas.txt";

//        System.out.println(path.substring(path.indexOf("\\") + 1));
//        int indexof = path.indexOf("\\");
//        System.out.println(indexof);
//        int indexLast = path.lastIndexOf("\\");
//        System.out.println(indexLast);
//
//        System.out.println(path.substring(indexLast + 1));
//
        StringTokenizer st = new StringTokenizer(fullPath, "\\\\");
        String pathh = null;
        while (st.hasMoreTokens()) {
            pathh = st.nextToken();
        }
        System.out.println(pathh.substring(pathh.indexOf(".")));

    }
}
