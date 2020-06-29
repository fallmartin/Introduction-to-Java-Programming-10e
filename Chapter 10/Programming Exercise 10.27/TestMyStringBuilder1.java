
/**
 * (Implement the StringBuilder class) The StringBuilder class is provided
 * in the Java library. Provide your own implementation for the following methods
 * (name the new class MyStringBuilder1):
 * public MyStringBuilder1(String s);
 * public MyStringBuilder1 append(MyStringBuilder1 s);
 * public MyStringBuilder1 append(int i);
 * public int length();
 * public char charAt(int index);
 * public MyStringBuilder1 toLowerCase();
 * public MyStringBuilder1 submatrix(int begin, int end);
 * public String toString();
 *
 * Output:
 * Create a new MyStringBuilder1 object m
 * class MyStringBuilder1 object successfully created!
 *
 * Append a MyStringBuilder1 object to m
 * HTML is OK!
 * Welcome to Java! HTML is OK!
 *
 * Append an int object to m
 * 6292020
 * Welcome to Java! HTML is OK! 6292020
 *
 * The length of m is 36
 *
 * Print the entire string using charAt() and length()
 * Welcome to Java! HTML is OK! 6292020
 *
 * welcome to java! html is ok! 6292020
 *
 * Java and HTML
 *
 * @author martinfall
 */
public class TestMyStringBuilder1 {

    public static void main(String[] args) {
        // Create a new MyStringBuilder1 object
        System.out.println("Create a new MyStringBuilder1 object m");
        MyStringBuilder1 m = new MyStringBuilder1("Welcome to Java! ");
        System.out.println(m.getClass() + " object successfully created!");
        System.out.println();

        // Append a MyStringBuilder1 to m and print to console with toString 
        System.out.println("Append a MyStringBuilder1 object to m");
        String s = "HTML is OK! ";
        m = m.append(new MyStringBuilder1(s));
        System.out.println(s);
        System.out.println(m.toString());
        System.out.println();

        // Append an integer to m and print to console with toString 
        System.out.println("Append an int object to m");
        int i = 6292020;
        m = m.append(i);
        System.out.println(i);
        System.out.println(m.toString());
        System.out.println();

        // Display the length of m
        System.out.println("The length of m is " + m.length());
        System.out.println();

        // Print the entire string using charAt() and length()
        System.out.println("Print the entire string using charAt() and length()");
        for (int index = 0; index < m.length(); index++) {
            System.out.print(m.charAt(index));
        }
        System.out.println("\n");

        // Test the toLowerCase method
        MyStringBuilder1 n = m.toLowerCase();
        System.out.println(n.toString());
        System.out.println();

        // Test the submatrix method and return Java and HTML
        System.out.println(m.submatrix(11, 15) + " and " + m.submatrix(17, 21));
        System.out.println();
    }
}
