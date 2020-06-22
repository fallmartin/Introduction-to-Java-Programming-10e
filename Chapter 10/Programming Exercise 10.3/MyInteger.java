
import java.util.Arrays;

/**
 * (The MyInteger class) Design a class named MyInteger. The class contains:
 *
 * ■ An int data field named value that stores the int value represented by this
 * object.
 * ■ A constructor that creates a MyInteger object for the specified int value.
 * ■ A getter method that returns the int value.
 * ■ The methods isEven(), isOdd(), and isPrime() that return true if the
 * value in this object is even, odd, or prime, respectively.
 * ■ The static methods isEven(int), isOdd(int), and isPrime(int) that
 * return true if the specified value is even, odd, or prime, respectively.
 * ■ The static methods isEven(MyInteger), isOdd(MyInteger), and
 * isPrime(MyInteger) that return true if the specified value is even, odd,
 * or prime, respectively.
 * ■ The methods equals(int) and equals(MyInteger) that return true if
 * the value in this object is equal to the specified value.
 * ■ A static method parseInt(char[]) that converts an array of numeric
 * characters to an int value.
 * ■ A static method parseInt(String) that converts a string into an int
 * value.
 *
 * Draw the UML diagram for the class and then implement the class. Write a
 * client
 * program that tests all methods in the class.
 *
 * @author martinfall
 */
public class MyInteger {

    // An int data field named value that stores the int value represented by this object.
    private int value;

    /**
     * A constructor that creates a MyInteger object for the specified int
     * value.
     *
     * @param value
     */
    public MyInteger(int value) {
        this.value = value;
    }

    /**
     * A getter method that returns the int value.
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    // The methods isEven(), isOdd(), and isPrime() that return true if the
    // value in this object is even, odd, or prime, respectively.
    /**
     * Returns true if the value in this object is even.
     *
     * @return
     */
    public boolean isEven() {
        return value % 2 == 0;
    }

    /**
     * Returns true if the value in this object is odd.
     *
     * @return
     */
    public boolean isOdd() {
        return value % 2 == 1;
    }

    /**
     * Returns true if the value in this object is prime.
     *
     * @return
     */
    public boolean isPrime() {
        for (int divisor = 2; divisor <= value / 2; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    // The static methods isEven(int), isOdd(int), and isPrime(int) that return 
    // true if the specified value is even, odd, or prime, respectively.
    /**
     * The static method isEven(int) returns true if the specified value is
     * even.
     *
     * @param value
     * @return
     */
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    /**
     * The static method isOdd(int) returns true if the specified value is
     * odd.
     *
     * @param value
     * @return
     */
    public static boolean isOdd(int value) {
        return value % 2 == 1;
    }

    /**
     * The static method isPrime(int) returns true if the specified value is
     * prime.
     *
     * @param value
     * @return
     */
    public static boolean isPrime(int value) {
        for (int divisor = 2; divisor <= value / 2; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    // The static methods isEven(MyInteger), isOdd(MyInteger), and
    // isPrime(MyInteger) that return true if the specified value is even, odd,
    // or prime, respectively.
    /**
     * The static methods isEven(MyInteger) returns true if the specified value
     * is even.
     *
     * @param value
     * @return
     */
    public static boolean isEven(MyInteger value) {
        return value.getValue() % 2 == 0;
    }

    /**
     * The static methods isOdd(MyInteger) returns true if the specified value
     * is odd.
     *
     * @param value
     * @return
     */
    public static boolean isOdd(MyInteger value) {
        return value.getValue() % 2 == 1;
    }

    /**
     * The static methods isPrime(MyInteger) returns true if the specified value
     * is prime.
     *
     * @param value
     * @return
     */
    public static boolean isPrime(MyInteger value) {
        for (int divisor = 2; divisor <= value.getValue() / 2; divisor++) {
            if (value.getValue() % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    // The methods equals(int) and equals(MyInteger) that return true if
    // the value in this object is equal to the specified value.
    /**
     * Returns true if the value in this object is equal to the specified value.
     *
     * @param value
     * @return
     */
    public boolean equals(int value) {
        return this.getValue() == value;
    }

    /**
     * Returns true if the value in this object is equal to the specified value.
     *
     * @param value
     * @return
     */
    public boolean equals(MyInteger value) {
        return this.getValue() == value.getValue();
    }

    // A static method parseInt(char[]) that converts an array of numeric
    // characters to an int value.
    /**
     * A static method that converts an array of numeric characters to an int
     * value.
     *
     * @param charArray
     * @return
     */
    public static int parseInt(char[] charArray) {
        return parseInt(new String(charArray));
    }

    /**
     * A static method that converts a string into an int value.
     *
     * @param value
     * @return
     */
    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }
}
