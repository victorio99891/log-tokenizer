package pl.wiktor.explorer;

import pl.wiktor.parser.LogFileParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryExplorer {

    public static List<String> explore(String dirPathToScan) throws IOException {

        List<String> logsArray = new ArrayList<>();

        File[] fileArray = new File(dirPathToScan).listFiles();

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
        System.out.println("Founded " + logsArray.size() + " error logs.");

        return logsArray;
    }

    private static void readDirectory(File[] files, int level, List<String> logArray) throws IOException {
        level++;
        for (File file : files) {
            if (file.isDirectory()) {
                printTabsByLevel(level);
                System.out.println("Sub: " + file.getName());
                readDirectory(file.listFiles(), level, logArray);
            } else {
                printTabsByLevel(level);
                System.out.print("File: " + file.getName());
                if (file.getName().contains("Err")) {
                    LogFileParser.analyzeFile(file, logArray);
                } else {
                    System.out.print("\n");
                }
            }
        }
    }

    private static void printTabsByLevel(int level) {
        for (int i = 0; i <= level; ++i) {
            System.out.print("    ");
        }
    }
}
