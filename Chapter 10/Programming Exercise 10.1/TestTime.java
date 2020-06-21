
/**
 * Write a test program that creates two Time objects (using new Time() and new
 * Time(555550000)) and displays their hour, minute, and second in the format
 * hour:minute:second.
 *
 * Output:
 * 09:10:26
 * 10:19:10
 *
 * @author martinfall
 */
public class TestTime {

    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        System.out.println(time1);
        System.out.println(time2);
    }
}
