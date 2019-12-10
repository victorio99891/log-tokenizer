package pl.wiktor;

import pl.wiktor.explorer.DirectoryExplorer;
import pl.wiktor.mapper.LogsToModel;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String path = "TEST_REAL";
        List<String> logCollection = new ArrayList<>();

        try {
            logCollection = DirectoryExplorer.explore(path);
            LogsToModel.mapTextLogsToModel(logCollection);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }
}
