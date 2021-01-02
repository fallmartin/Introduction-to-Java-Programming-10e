
import java.util.*;

/**
 * (Nonrecursive Tower of Hanoi) Implement the moveDisks method in Listing 18.8
 * using a moves instead of using recursion.
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
 *
 * @author martinfall
 */
public class TowerOfHanoi {

    // Static stack of Move objects as a data field
    private static final Stack<Move> moves = new Stack<Move>();

    /**
     * Main method with driver code.
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
    public static void moveDisks(int n, char fromTower,
            char toTower, char auxTower) {
        // Push a new move on the the stack
        moves.push(new Move(false, n, fromTower, toTower, auxTower));

        // While the stack moves is not empty
        while (!moves.isEmpty()) {
            // Retrieve the move at the top of the moves stack
            Move move = moves.pop();

            // If it is the last move
            if (move.isLast) {
                System.out.println(move); // Print to console
            } else {
                if (move.n == 1) { // If moving the top disk
                    System.out.println(move); // Print to console
                } else {
                    /**
                     * moveDisks(n - 1, fromTower, auxTower, toTower);
                     * System.out.println("Move disk " + n + " from " +
                     * fromTower + " to " + toTower);
                     * moveDisks(n - 1, auxTower, toTower, fromTower);
                     *
                     * Similarly, we push the same moves to the stack, but we
                     * do it in reverse, since stacks are LIFO data structures.
                     */
                    moves.push(new Move(false, move.n - 1, move.auxTower, move.toTower, move.fromTower));
                    moves.push(new Move(true, move.n, move.fromTower, move.toTower, move.auxTower));
                    moves.push(new Move(false, move.n - 1, move.fromTower, move.auxTower, move.toTower));
                }
            }
        }
    }

    /**
     * The Move class represents a single record of moves of the Tower of Hanoi
     * game.
     */
    public static class Move {

        boolean isLast = false; // isLast indicates that this is the last disk in the fromTower.
        int n;
        char fromTower;
        char toTower;
        char auxTower;

        /**
         * Parameterized constructor.
         *
         * @param isLast
         * @param n
         * @param fromTower
         * @param toTower
         * @param auxTower
         */
        public Move(boolean isLast, int n, char fromTower, char toTower, char auxTower) {
            this.isLast = isLast;
            this.n = n;
            this.fromTower = fromTower;
            this.toTower = toTower;
            this.auxTower = auxTower;
        }

        @Override // Override the toString method of the Object class
        public String toString() {
            return "Move disk " + n + " from " + fromTower + " to " + toTower;
        }

    }
}
