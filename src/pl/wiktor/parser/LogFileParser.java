package pl.wiktor.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFileParser {

    public static void analyzeFile(File file, List<String> logsArray) throws IOException {

        final String LOG_DELIMITER = "[LOG";
        final String END_DELIMITER = "[END]";

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
                    builder.append(" | ");
                }

                if (!line.contains(LOG_DELIMITER)) {
                    builder.append(line);
                    if (line.contains(END_DELIMITER)) {
                        builder.append(" | ");
                    }
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
