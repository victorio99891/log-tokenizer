package pl.wiktor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        final String LOG_DELIMITER = "[LOG";

        List<String> logs = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("log_example.txt")));
        StringTokenizer tokenizer;
        StringBuilder builder = new StringBuilder();

        String line;
        boolean firstLog = true;

        try {
            while ((line = br.readLine()) != null) {
                if (line.contains(LOG_DELIMITER) && firstLog) {
                    builder.append(line);
                    firstLog = false;

                } else if (line.contains(LOG_DELIMITER) && !firstLog) {
                    logs.add(builder.toString());
                    builder = new StringBuilder();
                    builder.append(line);
                    firstLog = true;

                } else {
                    builder.append(line);
                }
            }
            logs.add(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }


        System.out.println(logs);
        System.out.println(logs.size());

    }
}
