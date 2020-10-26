
import java.io.*;
import java.util.*;

/**
 * (Frequency of characters) Write a program that prompts the user to enter the
 * name of an ASCII text file and displays the frequency of the characters in
 * the file.
 * 
 * Output:
 *
 * Enter the name of an ASCII text file: MLK.txt
     ASCII Character           Frequency
                                     174
                   ,                   7
                   .                   9
                   A                   2
                   B                   1
                   E                   1
                   F                   1
                   I                   2
                   N                   5
                   O                   3
                   P                   1
                   S                   1
                   T                   1
                   a                  68
                   b                   5
                   c                  21
                   d                  33
                   e                  94
                   f                  20
                   g                  19
                   h                  40
                   i                  64
                   j                   3
                   k                   1
                   l                  34
                   m                  22
                   n                  59
                   o                  69
                   p                  10
                   r                  48
                   s                  50
                   t                  63
                   u                  12
                   v                   7
                   w                  11
                   x                   1
                   y                  22
                   z                   1
 * @author martinfall
 */
public class FrequencyOfCharacters {

    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        // Create a scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the name of an ASCII text file
        System.out.print("Enter the name of an ASCII text file: ");
        String filename = scanner.nextLine();

        // Check if the file exists
        File inputFile = new File(filename);
        if (!inputFile.exists()) {
            System.out.println("The file " + inputFile.getName()
                    + " does not exist.");
            System.exit(0); // Could user nonzero to show abnormal termination
        }

        // Create an array list to keep track of frequency of each character
        // ASCII characters range from 0 to 127
        int[] counter = new int[128];

        // The fun stuff
        try (
                // Create a data input stream
                Scanner input
                = new Scanner(
                        new BufferedInputStream(
                                new FileInputStream(inputFile)));) {
            while (input.hasNext()) {
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    int ascii = line.charAt(i);
                    counter[ascii]++;
                }
            }
        }

        System.out.printf("%20s%20s%n", "ASCII Character", "Frequency");
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0) {
                System.out.printf("%20c%20d%n", (char) i, counter[i]);
            }
        }
    }
}
