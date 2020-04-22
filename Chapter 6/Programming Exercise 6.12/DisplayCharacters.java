
/**
 * (Display characters) Write a method that prints characters using the following
 * header:
 *
 * public static void printChars(char ch1, char ch2, int numberPerLine)
 *
 * This method prints the characters between ch1 and ch2 with the specified
 * numbers per line. Write a test program that prints ten characters per line
 * from 1 to Z. Characters are separated by exactly one space.
 * 
 * Output:
1 2 3 4 5 6 7 8 9 : 
; < = > ? @ A B C D 
E F G H I J K L M N 
O P Q R S T U V W X 
Y Z 
 *
 * @author martinfall
 */
public class DisplayCharacters {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // prints ten characters per line from 1 to Z
        printChars('1', 'Z', 10);
    }

    /**
     * Print the characters between ch1 and ch2 with the specified numbers per
     * line
     *
     * @param ch1
     * @param ch2
     * @param numberPerLine
     */
    public static void printChars(char ch1, char ch2, int numberPerLine) {
        int count = 0;
        for (; ch1 <= ch2; ch1++) {
            System.out.print(ch1 + " ");
            count++;
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
}
