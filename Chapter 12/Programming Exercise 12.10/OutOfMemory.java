
/**
 * (OutOfMemoryError) Write a program that causes the JVM to throw an
 * OutOfMemoryError and catches and handles this error.
 *
 * Output:
 * Requested array size exceeds VM limit
 * java.lang.OutOfMemoryError: Java heap space
 *
 * @author martinfall
 */
public class OutOfMemory {

    public static void main(String[] args) {
        // Several ways to cause an OutOfMemoryError
        // https://www.geeksforgeeks.org/understanding-outofmemoryerror-exception-java/
        // Error 5 – Requested array size exceeds VM limit 

        try {
            Integer[] array = new Integer[100000 * 100000];
        } catch (OutOfMemoryError error) {
            System.out.println("Requested array size exceeds VM limit");
            System.out.println(error.toString());
        }

    }
}
