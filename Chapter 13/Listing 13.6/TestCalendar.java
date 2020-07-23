
import java.util.*;

/**
 * Output:
 * Current time is Thu Jul 23 01:08:31 EDT 2020
 * YEAR: 2020
 * MONTH: 6
 * DATE: 23
 * HOUR: 1
 * HOUR_OF_DAY: 1
 * MINUTE: 8
 * SECOND: 31
 * DAY_OF_WEEK: 5
 * DAY_OF_MONTH: 23
 * DAY_OF_YEAR: 205
 * WEEK_OF_MONTH: 4
 * WEEK_OF_YEAR: 30
 * AM_PM: 0
 * September 11, 2001 is a Tuesday
 *
 * @author martinfall
 */
public class TestCalendar {

    public static void main(String[] args) {
        // Construct a Gregorian calendar for the current date and time
        Calendar calendar = new GregorianCalendar();
        System.out.println("Current time is " + new Date());
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));

        // Construct a calendar for September 11, 2001
        Calendar calendar1 = new GregorianCalendar(2001, 8, 11);
        String[] dayNameOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
        System.out.println("September 11, 2001 is a "
                + dayNameOfWeek[calendar1.get(Calendar.DAY_OF_WEEK) - 1]);
    }
}
