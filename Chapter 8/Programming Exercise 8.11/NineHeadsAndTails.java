
import java.util.Scanner;

/**
 * (Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix with
 * some
 * face up and some face down. You can represent the state of the coins using a
 * 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:
 *
 *
 * 0 0 0  1 0 1   1 1 0   1 0 1   1 0 0
 * 0 1 0  0 0 1   1 0 0   1 1 0   1 1 1
 * 0 0 0  1 0 0   0 0 1   1 0 0   1 1 0
 *
 * Each state can also be represented using a binary number. For example, the
 * preceding matrices correspond to the numbers
 *
 * 000010000 101001100 110100001 101110100 100111110
 *
 * There are a total of 512 possibilities, so you can use decimal numbers 0, 1,
 * 2,
 * 3, . . . , and 511 to represent all states of the matrix. Write a program
 * that
 * prompts the user to enter a number between 0 and 511 and displays the
 * corresponding matrix with the characters H and T. Here is a sample run:
 *
 * Enter a number between 0 and 511: 7
 * H H H
 * H H H
 * T T T
 *
 * The user entered 7, which corresponds to 000000111. Since 0 stands for H and
 * 1 for T, the output is correct.
 *
 * @author martinfall
 */
public class NineHeadsAndTails {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number between 0 and 511
        System.out.print("Enter a number between 0 and 511: ");
        int decimal = input.nextInt();

        // Display the results
        printBinaryArray(decimalToBinary(decimal));

    }

    /**
     * Convert a decimal number to a binary array
     *
     * @param decimal
     * @return
     */
    public static int[][] decimalToBinary(int decimal) {
        int[][] binary = new int[3][3];

        for (int row = binary.length - 1; row >= 0; row--) {
            for (int column = binary[row].length - 1; column >= 0; column--) {
                if (decimal > 0) {
                    binary[row][column] = decimal % 2;
                    decimal = decimal / 2;
                } else {
                    binary[row][column] = 0;
                }
            }
        }

        return binary;
    }

    /**
     * Print the binary array with H for 0s and T for 1s.
     *
     * @param binary
     */
    public static void printBinaryArray(int[][] binary) {
        for (int row = 0; row < binary.length; row++) {
            for (int column = 0; column < binary[row].length; column++) {
                System.out.print((binary[row][column] == 0 ? "H" : "T") + " ");
            }
            System.out.println();
        }
    }
}
