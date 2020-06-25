
/**
 * Write a test program that creates two MyDate objects (using new MyDate() and
 * new MyDate(34355555133101L)) and displays their year, month, and day.
 *
 * Output:
 * 6/25/2020
 * 9/7/3058
 *
 * @author martinfall
 */
public class TestMyDate {

    public static void main(String[] args) {
        // Create two MyDate objects
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        // Display date1's year, month, and day
        System.out.println((date1.getMonth() + 1) + "/" + date1.getDay() + "/" + date1.getYear());

        // Display date2's year, month, and day
        System.out.println((date2.getMonth() + 1) + "/" + date2.getDay() + "/" + date2.getYear());
    }
}
