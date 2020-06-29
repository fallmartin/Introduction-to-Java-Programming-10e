
/**
 * (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following
 * methods
 * (name the new class MyStringBuilder2):
 *
 * public MyStringBuilder2();
 * public MyStringBuilder2(char[] chars);
 * public MyStringBuilder2(String s);
 * public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);
 * public MyStringBuilder2 reverse();
 * public MyStringBuilder2 substring(int begin);
 * public MyStringBuilder2 toUpperCase();
 *
 * Output:
 * Testing the 3 constructors
 * No-args constructor
 * Java
 * HTML
 *
 * Inserting HTML at index 2:
 * JaHTMLva
 *
 * Testing the reverse method
 * rotcurtsnoc sgra-oN
 * avaJ
 * LMTH
 *
 * Testing the substring method
 * constructor
 * va
 * ML
 *
 * Testing the toUpperCase method
 * NO-ARGS CONSTRUCTOR
 * JAVA
 * HTML
 *
 * @author martinfall
 */
public class TestMyStringBuilder2 {

    public static void main(String[] args) {
        // Testing the 3 constructors
        System.out.println("Testing the 3 constructors");
        // No-args constructor
        MyStringBuilder2 m1 = new MyStringBuilder2();
        // Constructor with char array
        MyStringBuilder2 m2 = new MyStringBuilder2(new char[]{'J', 'a', 'v', 'a'});
        // Constructor with String
        MyStringBuilder2 m3 = new MyStringBuilder2("HTML");
        // Print the 3 objects we created using toString override in MyStringBuilder2 class
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(m3.toString());
        System.out.println();

        // Testing the insert method
        System.out.println("Inserting " + m3.toString() + " at index 2:");
        MyStringBuilder2 newString = m2.insert(2, m3);
        System.out.println(newString.toString());
        System.out.println();

        // Testing the reverse method
        System.out.println("Testing the reverse method");
        System.out.println(m1.reverse().toString());
        System.out.println(m2.reverse().toString());
        System.out.println(m3.reverse().toString());
        System.out.println();

        // Testing the substring method
        System.out.println("Testing the substring method");
        System.out.println(m1.substring(8));
        System.out.println(m2.substring(2));
        System.out.println(m3.substring(2));
        System.out.println();

        // Testing the toUpperCase method
        System.out.println("Testing the toUpperCase method");
        System.out.println(m1.toUpperCase().toString());
        System.out.println(m2.toUpperCase().toString());
        System.out.println(m3.toUpperCase().toString());
    }
}
