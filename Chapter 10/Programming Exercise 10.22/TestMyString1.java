
/**
 * (Implement the String class) The String class is provided in the Java library.
 * Provide your own implementation for the following methods (name the new
 * class MyString1):
 *
 * public MyString1(char[] chars);
 * public char charAt(int index);
 * public int length();
 * public MyString1 substring(int begin, int end);
 * public MyString1 toLowerCase();
 * public boolean equals(MyString1 s);
 * public static MyString1 valueOf(int i);
 *
 * Output:
 * Testing the constructor
 * Testing the length() method and the charAt(int i) method
 * ABCDE
 * Testing the substring(int begin, int end) method
 * ABC
 * DE
 * Testing the toLowerCase() method
 * abcde
 * Testing the equals(MyString1 s) method
 * true
 * false
 * Testing the valueOf(int i) method
 * 12345
 *
 * @author martinfall
 */
public class TestMyString1 {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Testing the constructor
        System.out.println("Testing the constructor");
        MyString1 string = new MyString1(new char[]{'A', 'B', 'C', 'D', 'E'});

        // Testing the length() method and the charAt(int i) method
        System.out.println("Testing the length() method and the charAt(int i) method");
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
        }

        // Print a new line
        System.out.println();

        // Testing the substring(int begin, int end) method
        System.out.println("Testing the substring(int begin, int end) method");
        System.out.println(string.substring(0, 2).toString());
        System.out.println(string.substring(3, 4).toString());

        // Testing the toLowerCase() method
        System.out.println("Testing the toLowerCase() method");
        System.out.println(string.toLowerCase().toString());

        // Testing the equals(MyString1 s) method
        System.out.println("Testing the equals(MyString1 s) method");
        System.out.println(string.equals(new MyString1(new char[]{'A', 'B', 'C', 'D', 'E'})));
        System.out.println(string.equals(new MyString1(new char[]{'A', 'B', 'C', 'D', 'F'})));

        // Testing the valueOf(int i) method
        System.out.println("Testing the valueOf(int i) method");
        System.out.println(MyString1.valueOf(12345).toString());
    }
}
