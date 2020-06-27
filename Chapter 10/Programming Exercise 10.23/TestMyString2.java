
import java.util.Arrays;

/**
 * (Implement the String class) The String class is provided in the Java
 * library.
 * Provide your own implementation for the following methods (name the new
 * class MyString2):
 *
 * public MyString2(String s);
 * public int compare(String s);
 * public MyString2 substring(int begin);
 * public MyString2 toUpperCase();
 * public char[] toChars();
 * public static MyString2 valueOf(boolean b);
 *
 * Output:
 * Testing the constructor
 *
 * Testing compare(String s)
 * 0
 * 6
 *
 * Testing the substring(int begin) method
 * abc123ABC456
 * ABC456
 *
 * Testing the toUpperCase() method
 * ABC123ABC456
 *
 * Testing the toChars() method
 * abc123ABC456
 * [a, b, c, 1, 2, 3, A, B, C, 4, 5, 6]
 *
 * Testing the valueof(boolean b)
 * TRUE
 * FALSE
 *
 * @author martinfall
 */
public class TestMyString2 {

    public static void main(String[] args) {
        // Testing the constructor
        System.out.println("Testing the constructor");
        MyString2 string = new MyString2("abc123ABC456");
        System.out.println();

        // Testing compare(String s)
        System.out.println("Testing compare(String s)");
        System.out.println(string.compare("abc123ABC456"));
        System.out.println(string.compare("abc123ABC450"));
        System.out.println();

        // Testing the substring(int begin) method
        System.out.println("Testing the substring(int begin) method");
        System.out.println(string.substring(0).toString());
        System.out.println(string.substring(6));
        System.out.println();

        // Testing the toUpperCase() method
        System.out.println("Testing the toUpperCase() method");
        System.out.println(string.toUpperCase().toString());
        System.out.println();

        // Testing the toChars() method
        System.out.println("Testing the toChars() method");
        char[] chars = string.toChars();
        System.out.println(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println();

        // Testing the valueOf(boolean b) method
        System.out.println("Testing the valueof(boolean b)");
        System.out.println(MyString2.valueOf(true));
        System.out.println(MyString2.valueOf(false));
    }
}
