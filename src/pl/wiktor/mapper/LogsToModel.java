package pl.wiktor.mapper;

import org.joda.time.DateTime;
import pl.wiktor.model.ErrorType;
import pl.wiktor.model.LogModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LogsToModel {

    private static final String DATE_TIME_PATTERN = "yyyy MMMM dd, HH:mm:ss (SSS)";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_PATTERN);

    public static List<LogModel> mapTextLogsToModel(List<String> logsStrings) throws ParseException {


        for (String log : logsStrings) {

            StringTokenizer tokenizer = new StringTokenizer(log, "|");

            List<String> tokenList = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                tokenList.add(tokenizer.nextToken());
            }

            ErrorType errorType = resolveErrorType(tokenList.get(1));
            DateTime dateTime = new DateTime(simpleDateFormat.parse(tokenList.get(2)));

            LogModel model = new LogModel(null, errorType, dateTime, tokenList.get(3), tokenList.get(4), tokenList.get(5), tokenList.get(6));
            System.out.println(model.toString());
//            for (String item : tokenList) {
//                System.out.println(item);
//            }
//
//            System.out.println("\n\n");


        }


        return null;
    }

    private static ErrorType resolveErrorType(String error) {
        for (ErrorType type : ErrorType.values()) {
            if (type.name().equalsIgnoreCase(error)) {
                return type;
            }
        }
        return null;
    }


}
