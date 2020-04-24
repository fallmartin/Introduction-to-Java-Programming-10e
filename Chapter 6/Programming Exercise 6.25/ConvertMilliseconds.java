
/**
 * Convert milliseconds to hours, minutes, and seconds) Write a method that
 * converts milliseconds to hours, minutes, and seconds using the following header:
 *
 * public static String convertMillis(long millis)
 *
 * The method returns a string as hours:minutes:seconds. For example,
 * convertMillis(5500)returns a string 0:0:5, convertMillis(100000)returns
 * a string 0:1:40, and convertMillis(555550000) returns a string 154:19:10.
 *
 * Output:
 * 0:0:5
 * 0:1:40
 * 154:19:10
 *
 * @author martinfall
 */
public class ConvertMilliseconds {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convertMillis(5500));
        System.out.println(convertMillis(100000));
        System.out.println(convertMillis(555550000));
    }

    /**
     * Convert milliseconds to hours, minutes, and seconds
     *
     * @param millis
     * @return
     */
    public static String convertMillis(long millis) {
        long totalSeconds = millis / 1000;
        long currentSecond = totalSeconds % 60;

        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;

        long totalHours = totalMinutes / 60;
        long currentHour = totalHours; // I left this here to be able to modify later

        String str = String.format("%d:%d:%d", currentHour, currentMinute, currentSecond);

        return str;
    }
}
