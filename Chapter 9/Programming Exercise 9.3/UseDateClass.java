
import java.util.Date;

/**
 * (Use the Date class) Write a program that creates a Date object, sets its
 * elapsed
 * time to 10000, 100000, 1000000, 10000000, 100000000, 1000000000,
 * 10000000000, and 100000000000, and displays the date and time using the
 * toString() method, respectively.
 *
 * Output:
 * Thu Jan 01 00:00:10 GMT 1970
 * Thu Jan 01 00:01:40 GMT 1970
 * Thu Jan 01 00:16:40 GMT 1970
 * Thu Jan 01 02:46:40 GMT 1970
 * Fri Jan 02 03:46:40 GMT 1970
 * Mon Jan 12 13:46:40 GMT 1970
 * Sun Apr 26 17:46:40 GMT 1970
 * Sat Mar 03 09:46:40 GMT 1973
 *
 * @author martinfall
 */
public class UseDateClass {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Date object
        Date date = new Date();

        // Set elapsed time to 10000 and displays the date and time using the
        // toString() method
        date.setTime(10000L);
        System.out.println(date.toString());

        // Set elapsed time to 100000 and displays the date and time using the
        // toString() method
        date.setTime(100000L);
        System.out.println(date.toString());

        // Set elapsed time to 1000000 and displays the date and time using the
        // toString() method
        date.setTime(1000000L);
        System.out.println(date.toString());

        // Set elapsed time to 10000000 and displays the date and time using the
        // toString() method
        date.setTime(10000000L);
        System.out.println(date.toString());

        // Set elapsed time to 100000000 and displays the date and time using the
        // toString() method
        date.setTime(100000000L);
        System.out.println(date.toString());

        // Set elapsed time to 1000000000 and displays the date and time using the
        // toString() method
        date.setTime(1000000000L);
        System.out.println(date.toString());

        // Set elapsed time to 10000000000 and displays the date and time using the
        // toString() method
        date.setTime(10000000000L);
        System.out.println(date.toString());

        // Set elapsed time to 100000000000 and displays the date and time using the
        // toString() method
        date.setTime(100000000000L);
        System.out.println(date.toString());
    }
}
