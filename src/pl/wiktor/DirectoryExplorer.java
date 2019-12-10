package pl.wiktor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryExplorer {

    public static void main(String[] args) throws IOException {

        final String EXAMPLE_ABSOLUTE_PATH = "TEST";

        List<String> logsArray = new ArrayList<>();

        File[] fileArray = new File(EXAMPLE_ABSOLUTE_PATH).listFiles();

        int level = 0;

        for (File file : fileArray) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                readDirectory(file.listFiles(), level, logsArray);
                level = 0;
            } else if (file.isFile()) {
                System.out.print("File: " + file.getName());
                if (file.getName().contains("Err")) {
                    LogFileParser.analyzeFile(file, logsArray);
                } else {
                    System.out.print("\n");
                }
            }
        }

        System.out.println("\n ------------------ SUMMARRY -------------------");
        System.out.println("All (count: " + logsArray.size() + ") error logs:");
        System.out.println(logsArray);

    }

    public static void readDirectory(File[] files, int level, List<String> logArray) throws IOException {
        level++;
        for (File file : files) {
            if (file.isDirectory()) {
                printTabsByLevel(level);
                System.out.println("Sub: " + file.getName());
                readDirectory(file.listFiles(), level, logArray);
            } else {
                printTabsByLevel(level);
                System.out.print("File: " + file.getName());
                LogFileParser.analyzeFile(file, logArray);
            }
        }
    }

    public static void printTabsByLevel(int level) {
        for (int i = 0; i <= level; ++i) {
            System.out.print("    ");
        }
    }
}
