
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Data sorted?) Write a program that reads the strings from file
 * SortedStrings.txt and reports whether the strings in the files are stored in
 * increasing order. If the strings are not sorted in the file, displays the
 * first two strings that are out of the order.
 *
 * Output 1:
 * accurate and accuracy are out of order.
 * The strings are not stored in increasing order.
 *
 * Output 2:
 * The strings are stored in increasing order.
 *
 * @author martinfall
 */
public class SortedStrings {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("SortedStrings.txt");

        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist.");
        }

        try (Scanner input = new Scanner(file);) {
            // Create a new list
            ArrayList<String> list = new ArrayList<>();

            // Populate the list
            while (input.hasNext()) {
                list.add(input.next());
            }

            boolean flag = true;

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    System.out.println(list.get(i - 1) + " and " + list.get(i)
                            + " are out of order.");
                    flag = false;
                }
            }

            System.out.println("The strings are" + (flag ? " " : " not ") + "stored in increasing order.");
        }
    }
}
