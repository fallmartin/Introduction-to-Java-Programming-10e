
import java.util.*;

/**
 * (Display calendars) Rewrite the PrintCalendar class in Listing 6.12 to
 * display a calendar for a specified month using the Calendar and
 * GregorianCalendar classes. Your program receives the month and year from the
 * command line. For example:
 *
 * java Exercise13_04 5 2016
 *
 * You also can run the program without the year. In this case, the year is the
 * current year. If you run the program without specifying a month and a year,
 * the month is the current month.
 *
 * @author martinfall
 */
public class DisplayCalendars {

    // Construct a static default GregorianCalendar using the current time in the 
    // default time zone with the default FORMAT locale.
    static GregorianCalendar calendar = new GregorianCalendar();

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Set month and year to the current values in static calendar object
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        // Check command line parameter usage
        switch (args.length) {
            case 1: // Only month is entered
                month = Integer.parseInt(args[0].trim()) - 1;
                break;
            case 2: // Month and year are entered
                month = Integer.parseInt(args[0].trim()) - 1;
                year = Integer.parseInt(args[1].trim());
                break;
            default: // Incorrect command line parameter usage
                System.out.println("Usage: java DisplayCalendars 5 2016");
                System.exit(0);
                break;
        }
        
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        // Print calendar for the month of the year
        printMonth(calendar);
    }

    /**
     * Print the calendar for a month in a year.
     *
     * @param calendar
     */
    public static void printMonth(GregorianCalendar calendar) {
        // Print the headings of the calendar
        printMonthTitle(calendar);
        // Print the body of the calendar
        printMonthBody(calendar);
    }

    /**
     * Print the month title, e.g., May, 1999.
     *
     * @param calendar
     */
    public static void printMonthTitle(GregorianCalendar calendar) {
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        String year = calendar.get(GregorianCalendar.YEAR) + "";
        System.out.println("         " + month + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Print month body.
     *
     * @param calendar
     */
    public static void printMonthBody(GregorianCalendar calendar) {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(calendar) + 1;

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(calendar);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay && startDay % 7 != 0; i++) {
            System.out.print("    ");
        }
        
        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);
            
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        
        System.out.println();
    }

    /**
     * Get the start day of month/1/year.
     *
     * @param calendar
     * @return
     */
    public static int getStartDay(GregorianCalendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Get the number of days in a month.
     *
     * @param calendar
     * @return
     */
    public static int getNumberOfDaysInMonth(GregorianCalendar calendar) {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
