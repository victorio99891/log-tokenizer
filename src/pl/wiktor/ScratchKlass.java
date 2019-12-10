package pl.wiktor;

import org.joda.time.DateTime;
import pl.wiktor.model.LogModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScratchKlass {
    public static void main(String[] args) throws ParseException {

        // 2019 December 10, 13:00:52 (207)

        String pattern = "yyyy MMMM dd, HH:mm:ss (SSS)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String example = "2019 December 10, 13:00:52 (207)";

        Date date = simpleDateFormat.parse(example);

        DateTime dateTime = new DateTime(date);

        System.out.println(dateTime.toString());

    }
}
