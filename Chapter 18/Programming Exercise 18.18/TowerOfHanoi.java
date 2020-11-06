
import java.util.Scanner;

/**
 * (Tower of Hanoi) Modify Listing 18.8, TowerOfHanoi.java, so that the program
 * finds the number of moves needed to move n disks from tower A to tower B.
 * (Hint: Use a static variable and increment it every time the method is
 * called.)
 *
 * Output:
 *
 * Enter number of disks: 3
 * The moves are:
 * Move disk 1 from A to B
 * Move disk 2 from A to C
 * Move disk 1 from B to C
 * Move disk 3 from A to B
 * Move disk 1 from C to A
 * Move disk 2 from C to B
 * Move disk 1 from A to B
 * The number of moves needed to move 3 disks from tower A to tower B is 7
 *
 * @author martinfall
 */
public class TowerOfHanoi {

    static int moves = 0;

    /**
     * Displays the moves needed to move n disks from tower A to tower B.
     *
     * @param n
     * @param fromTower
     * @param toTower
     * @param auxTower
     */
    public static void moveDisks(int n,
            char fromTower, char toTower, char auxTower) {

        if (n == 1) {
            System.out.println(
                    "Move disk " + n + " from " + fromTower + " to " + toTower);
            moves++; // Count a move
        } else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println(
                    "Move disk " + n + " from " + fromTower + " to " + toTower);
            moves++; // Count a move
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();

        // Find the solution recursively
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');

        // Display the number of moves needed to move n disks from A to B
        System.out.println("The number of moves needed to move "
                + n + " disks from tower A to tower B is " + moves);
    }
}
