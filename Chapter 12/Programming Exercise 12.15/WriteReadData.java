
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * (Write/read data) Write a program to create a file named Exercise12_15.txt if
 * it does not exist. Write 100 integers created randomly into the file using
 * text I/O. Integers are separated by spaces in the file. Read the data back
 * from the file and display the data in increasing order.
 *
 * Output:
 * 1	4	  5	  6	  6	  6	  8 	9	  12	13
 * 15	15	16	16	16	18	18	18	19	19
 * 21	23	26	27	29	30	30	30	30	30
 * 31	32	33	33	34	34	35	37	37	37
 * 37	42	43	44	44	44	46	47	47	48
 * 49	49	49	50	51	52	53	53	54	55
 * 55	57	57	58	59	60	60	61	64	66
 * 68	68	72	73	73	74	75	75	77	78
 * 78	79	79	81	83	85	86	86	88	89
 * 90	90	90	92	93	94	95	97	98	99
 *
 * @author martinfall
 */
public class WriteReadData {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new Random object
        Random r = new Random();

        // Create a file object named Exercise12_15.txt
        File file = new File("Exercise12_15.txt");

        // Check if the file exists
        if (file.exists()) {
            System.out.println("The file already exists.");
            System.exit(0);
        } // Exit the program gracefully if the file already exists

        // Create an output file
        try (PrintWriter output = new PrintWriter(file);) {
            // Write 100 integers created randomly into the file using text I/O
            for (int i = 0; i < 100; i++) {
                output.print(r.nextInt(100) + " "); //upper bound 100
            }
        }

        // Print a line for formatting
        System.out.println();

        // Create an int[] array
        ArrayList<Integer> list = new ArrayList<>();

        // Create output file, and add integers to list
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                list.add(input.nextInt());
            }
            // Sort list in increasing order
            Collections.sort(list);
        }

        // Display the result
        printArrayList(list);
    }

    public static void printArrayList(ArrayList<Integer> list) {
        int counter = 0;
        for (int number : list) {
            System.out.print(number + "\t");
            counter++;
            if (counter % 10 == 0) {
                System.out.println();
            }
        }
    }
}
