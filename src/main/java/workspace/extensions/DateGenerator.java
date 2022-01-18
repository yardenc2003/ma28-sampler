package workspace.extensions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGenerator {
    private final static SimpleDateFormat dotDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final static SimpleDateFormat slashDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private static Date generateDate(SimpleDateFormat dateFormat, String date) throws ParseException {
        return dateFormat.parse(date);
    }

    public static Date generateDotDate(String date) throws ParseException {
        return generateDate(dotDateFormat, date);
    }

    public static Date generateSlashDate(String date) throws ParseException {
        return generateDate(slashDateFormat, date);
    }
}
