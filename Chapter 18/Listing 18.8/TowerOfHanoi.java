
import java.util.Scanner;

/**
 * Output:
 *
 * Enter number of disks: 4
 * The moves are:
 * Move disk 1 from A to C
 * Move disk 2 from A to B
 * Move disk 1 from C to B
 * Move disk 3 from A to C
 * Move disk 1 from B to A
 * Move disk 2 from B to C
 * Move disk 1 from A to C
 * Move disk 4 from A to B
 * Move disk 1 from C to B
 * Move disk 2 from C to A
 * Move disk 1 from B to A
 * Move disk 3 from C to B
 * Move disk 1 from A to C
 * Move disk 2 from A to B
 * Move disk 1 from C to B
 *
 * @author martinfall
 */
public class TowerOfHanoi {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();

        // Find the solution recursively
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
    }

    /**
     * The method for finding the solution to move n disks from fromTower to
     * toTower with auxTower.
     *
     * @param n
     * @param fromTower
     * @param toTower
     * @param auxTower
     */
    public static void moveDisks(
            int n, char fromTower, char toTower, char auxTower) {
        if (n == 1) { // Stopping condition
            System.out.println(
                    "Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println(
                    "Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
