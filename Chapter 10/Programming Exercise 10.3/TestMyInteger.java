
/**
 * Output:
 * 4
 * isEven(), isOdd(), and isPrime()
 * isEven? true
 * isOdd? false
 * isPrime? false
 *
 * isEven(int), isOdd(int), and isPrime(int)
 * isEven? true
 * isOdd? false
 * isPrime? false
 *
 * isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger)
 * isEven? true
 * isOdd? false
 * isPrime? false
 *
 * equals(int) and equals(MyInteger)
 * obj1.equals(4) is true
 * obj1.equals(obj2) is false
 *
 * parseInt(char[])
 * 12345
 *
 * parseInt(String)
 * 54321
 *
 * @author martinfall
 */
public class TestMyInteger {

    public static void main(String[] args) {
        // A constructor that creates a MyInteger object for the specified int value.
        MyInteger obj1 = new MyInteger(4);

        // A getter method that returns the int value.
        System.out.println(obj1.getValue());

        // The methods isEven(), isOdd(), and isPrime() that return true if the
        // value in this object is even, odd, or prime, respectively.
        System.out.println("isEven(), isOdd(), and isPrime()");
        System.out.println("isEven? " + obj1.isEven());
        System.out.println("isOdd? " + obj1.isOdd());
        System.out.println("isPrime? " + obj1.isPrime());
        System.out.println();

        // The static methods isEven(int), isOdd(int), and isPrime(int) that
        // return true if the specified value is even, odd, or prime, respectively.
        System.out.println("isEven(int), isOdd(int), and isPrime(int)");
        System.out.println("isEven? " + MyInteger.isEven(obj1.getValue()));
        System.out.println("isOdd? " + MyInteger.isOdd(obj1.getValue()));
        System.out.println("isPrime? " + MyInteger.isPrime(obj1.getValue()));
        System.out.println();

        // The static methods isEven(MyInteger), isOdd(MyInteger), and
        // isPrime(MyInteger) that return true if the specified value is even, odd,
        // or prime, respectively.
        System.out.println("isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger)");
        System.out.println("isEven? " + MyInteger.isEven(obj1));
        System.out.println("isOdd? " + MyInteger.isOdd(obj1));
        System.out.println("isPrime? " + MyInteger.isPrime(obj1));
        System.out.println();

        // The methods equals(int) and equals(MyInteger) that return true if
        // the value in this object is equal to the specified value.
        System.out.println("equals(int) and equals(MyInteger)");
        System.out.println("obj1.equals(4) is " + obj1.equals(4));
        // Create a new MyInteger object with value 5
        MyInteger obj2 = new MyInteger(5);
        System.out.println("obj1.equals(obj2) is " + obj1.equals(obj2));
        System.out.println();

        // A static method parseInt(char[]) that converts an array of numeric
        // characters to an int value.
        // Create a new char array
        System.out.println("parseInt(char[])");
        char[] charArray = {'1', '2', '3', '4', '5'};
        int parsedArray = MyInteger.parseInt(charArray);
        System.out.println(parsedArray);
        System.out.println();

        // A static method parseInt(String) that converts a string into an int
        // value.
        System.out.println("parseInt(String)");
        String numString = "54321";
        int parsedString = MyInteger.parseInt(numString);
        System.out.println(parsedString);
        System.out.println();
    }
}
