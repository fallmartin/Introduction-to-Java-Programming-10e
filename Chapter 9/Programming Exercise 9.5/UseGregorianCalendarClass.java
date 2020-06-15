
import java.util.GregorianCalendar;

/**
 * (Use the GregorianCalendar class) Java API has the GregorianCalendar class
 * in the java.util package, which you can use to obtain the year, month, and
 * day of a date. The no-arg constructor constructs an instance for the current
 * date, and the methods get(GregorianCalendar.YEAR),
 * get(GregorianCalendar.MONTH), and get(GregorianCalendar.DAY_OF_MONTH) return
 * the year, month, and day.
 * Write a program to perform two tasks:
 * ■ Display the current year, month, and day.
 * ■ The GregorianCalendar class has the setTimeInMillis(long), which
 * can be used to set a specified elapsed time since January 1, 1970. Set the
 * value to 1234567898765L and display the year, month, and day.
 *
 * Output:
 * Year: 2020
 * Month: 5
 * Day of the Month: 15
 *
 * Year: 2009
 * Month: 1
 * Day of the Month: 13
 *
 * @author martinfall
 */
public class UseGregorianCalendarClass {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new GregorianCalendar object with no-arg constructor
        GregorianCalendar gc = new GregorianCalendar();

        // Display the current year, month, and day.
        System.out.println("Year: " + gc.get(GregorianCalendar.YEAR));
        System.out.println("Month: " + gc.get(GregorianCalendar.MONTH));
        System.out.println("Day of the Month: " + gc.get(GregorianCalendar.DAY_OF_MONTH));

        // Set the value to 1234567898765L and display the year, month, and day.
        gc.setTimeInMillis(1234567898765L);
        System.out.println();

        // Display the current year, month, and day.
        System.out.println("Year: " + gc.get(GregorianCalendar.YEAR));
        System.out.println("Month: " + gc.get(GregorianCalendar.MONTH));
        System.out.println("Day of the Month: " + gc.get(GregorianCalendar.DAY_OF_MONTH));

    }
}
