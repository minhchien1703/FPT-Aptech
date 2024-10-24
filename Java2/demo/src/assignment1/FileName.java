package assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileName {
    /**
     * Variable contain value of path
     */
    private String fullPath;
    /**
     * Variable contain value of extension separator
     */
    private char extensionSeparator;
    /**
     * Variable contain value of disk separator
     */
    private char diskSparator;
    /**
     * Variable contain value of path separator
     */
    private char pathSeparator;

    /**
     * Contructor
     *
     * @param fullPath
     *            value of path
     * @param diskSparator
     *            value of disk separator
     * @param pathSeparator
     *            value of path separator
     * @param extensionSeparator
     *            value of extension separator
     */
    public FileName(String fullPath, char diskSparator, char pathSeparator,
                    char extensionSeparator) {
        this.fullPath = fullPath;
        this.diskSparator = diskSparator;
        this.pathSeparator = pathSeparator;
        this.extensionSeparator = extensionSeparator;
    }

    /**
     * @return Extension
     */
    public String getExtension() {
        String extension = fullPath.substring(fullPath.lastIndexOf(extensionSeparator) + 1);
        return extension;
    }

    /**
     * @return file name without extension
     */
    public String getFilename() {
        StringTokenizer st = new StringTokenizer(fullPath, "\\\\");
        StringBuilder sb = new StringBuilder();
        String fileName, newPath = null;
        while (st.hasMoreElements()) {
            newPath = st.nextToken();
        }
        sb.append(".");
        sb.append(newPath);
        st = new StringTokenizer(sb.toString(), ".");
        fileName = st.nextToken();
        return fileName;
    }

    /**
     * @return path without filename
     */
    public String getPath() {
        StringTokenizer st;
        StringBuilder sb;
        String path, path1, path2;
        st = new StringTokenizer(fullPath, "\\\\");
        path1 = st.nextToken();
        st = new StringTokenizer(fullPath.substring(fullPath.indexOf("\\") + 1), "\\\\");
        path2 = st.nextToken();
        sb = new StringBuilder();
        sb.append(path1);
        sb.append("\\");
        sb.append(path2);
        path = sb.toString();
        return path;
    }

    /**
     * @return Disk name
     */
    public String getDisk() {
        StringTokenizer st = new StringTokenizer(fullPath, "\\\\");
        String path = st.nextToken();
        return path;
    }

    /**
     * @return all folder in path
     */
    public String[] getFolders() {
        ArrayList<String> folders = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fullPath));
            String line;
            while ((line = br.readLine()) != null) {
                folders.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return folders.toArray(new String[0]);
    }
}
