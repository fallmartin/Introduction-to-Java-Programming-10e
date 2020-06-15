
/**
 * (Stopwatch) Design a class named StopWatch. The class contains:
 *
 * ■ Private data fields startTime and endTime with getter methods.
 * ■ A no-arg constructor that initializes startTime with the current time.
 * ■ A method named start() that resets the startTime to the current time.
 * ■ A method named stop() that sets the endTime to the current time.
 * ■ A method named getElapsedTime() that returns the elapsed time for the
 * stopwatch in milliseconds.
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that measures the execution time of sorting 100,000 numbers using
 * selection sort.
 *
 * @author martinfall
 */
public class Stopwatch {

    // Private data fields startTime and endTime
    private long startTime;
    private long endTime;

    // A no-arg constructor that initializes startTime with the current time
    public Stopwatch() {
        this.startTime = System.currentTimeMillis();
    }

    // A method named start() that resets the startTime to the current time
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    // A method named stop() that sets the endTime to the current time
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    // A method named getElapsedTime() that returns the elapsed time for the
    // stopwatch in milliseconds
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    // Getter methods for private data fields startTime and endTime
    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

}
