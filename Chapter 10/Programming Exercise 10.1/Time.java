
/**
 * (The Time class) Design a class named Time. The class contains:
 *
 * ■ The data fields hour, minute, and second that represent a time.
 * ■ A no-arg constructor that creates a Time object for the current time. (The
 * values of the data fields will represent the current time.)
 * ■ A constructor that constructs a Time object with a specified elapsed time
 * since midnight, January 1, 1970, in milliseconds. (The values of the data
 * fields will represent this time.)
 * ■ A constructor that constructs a Time object with the specified hour, minute,
 * and second.
 * ■ Three getter methods for the data fields hour, minute, and second,
 * respectively.
 * ■ A method named setTime(long elapseTime) that sets a new time
 * for the object using the elapsed time. For example, if the elapsed time is
 * 555550000 milliseconds, the hour is 10, the minute is 19, and the second is
 * 10.
 * Draw the UML diagram for the class and then implement the class. Write
 * a test program that creates two Time objects (using new Time() and new
 * Time(555550000)) and displays their hour, minute, and second in the format
 * hour:minute:second.
 * (Hint: The first two constructors will extract the hour, minute, and second
 * from the elapsed time. For the no-arg constructor, the current time can be
 * obtained using System.currentTimeMillis(), as shown in Listing 2.7,
 * ShowCurrentTime.java.)
 *
 * @author martinfall
 */
public class Time {

    // The data fields hour, minute, and second that represent a time.
    private int hour, minute, second;

    /**
     * A no-arg constructor that creates a Time object for the current time.
     * (The values of the data fields will represent the current time.)
     */
    public Time() {
        this(System.currentTimeMillis());
    }

    /**
     * A constructor that constructs a Time object with a specified elapsed time
     * since midnight, January 1, 1970, in milliseconds. (The values of the data
     * fields will represent this time.)
     *
     * @param elapseTime
     */
    public Time(long elapseTime) {
        this((int) (elapseTime / 3600000) % 24, // Hours
                (int) (elapseTime / 60000) % 60, // Minutes
                (int) (elapseTime / 1000) % 60); // Seconds
    }

    /**
     * A constructor that constructs a Time object with the specified hour,
     * minute, and second.
     *
     * @param hour
     * @param minute
     * @param second
     */
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Three getter methods for the data fields hour, minute, and second, respectively.
    /**
     * Returns the hours.
     *
     * @return
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the minutes.
     *
     * @return
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Returns the seconds.
     *
     * @return
     */
    public int getSecond() {
        return second;
    }

    /**
     * A method named setTime(long elapseTime) that sets a new time for the
     * object using the elapsed time. For example, if the elapsed time is
     * 555550000 milliseconds , the hour is 10, the minute is 19, and the second
     * is 10.
     *
     * @param elapseTime
     */
    public void setTime(long elapseTime) {
        this.hour = (int) (elapseTime / 3600000) % 24;
        this.minute = (int) (elapseTime / 60000) % 60;
        this.second = (int) (elapseTime / 1000) % 60;
    }

    @Override
    public String toString() {
        String format = String.format("%02d:%02d:%02d", hour, minute, second);
        return format;
    }
}
