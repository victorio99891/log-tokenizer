package pl.wiktor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LogFileParser {

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


    public static void analyzeFile(File file, List<String> logsArray) throws IOException {

        final String LOG_DELIMITER = "[LOG";

        List<String> logs = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        try {
            String line;
            StringBuilder builder = null;
            while ((line = br.readLine()) != null) {

                if (line.contains(LOG_DELIMITER)) {
                    if (builder != null) {
                        logsArray.add(builder.toString());
                        logs.add(builder.toString());
                    }
                    builder = new StringBuilder();
                    builder.append(line);
                }

                if (!line.contains(LOG_DELIMITER)) {
                    builder.append(line);
                }

            }

            if (builder != null && !builder.toString().trim().isEmpty()) {
                logsArray.add(builder.toString());
                logs.add(builder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }


        if (logs.size() != 0) {
            System.out.print(" (found error logs: " + logs.size() + ")\n");
        } else {
            System.out.print("\n");
        }

    }

}
