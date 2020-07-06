
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * (Sort ArrayList) Write the following method that sorts an ArrayList of
 * numbers:
 *
 * public static void sort(ArrayList<Integer> list)
 *
 * Write a test program that prompts the user to enter 5 numbers, stores them in
 * an array list, and displays them in increasing order.
 *
 * @author martinfall
 */
public class SortArrayList {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner input = new Scanner(System.in);
        
        // Create a new ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
        // Promt the user to enter 5 numbers.
        System.out.print("Enter 5 numbers: ");
        
        // Store 5 user entries in the array list
        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }
        
        // Sort the array list and display it 
        sort(list);
        System.out.println(list);
    }

    /**
     * Sorts an ArrayList of numbers.
     *
     * @param list
     */
    public static void sort(ArrayList<Integer> list) {
        Collections.sort(list);
    }
}
