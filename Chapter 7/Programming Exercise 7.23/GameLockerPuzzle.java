
/**
 * (Game: locker puzzle) A school has 100 lockers and 100 students. All lockers
 * are closed on the first day of school. As the students enter, the first
 * student, denoted S1, opens every locker. Then the second student, S2, begins
 * with the second locker, denoted L2, and closes every other locker. Student S3
 * begins with the third locker and changes every third locker (closes it if it
 * was open, and opens it if it was closed). Student S4 begins with locker L4
 * and changes every fourth locker. Student S5 starts with L5 and changes every
 * fifth locker, and so on, until student S100 changes L100.
 *
 * After all the students have passed through the building and changed the
 * lockers, which lockers are open? Write a program to find your answer and
 * display all open locker numbers separated by exactly one space.
 *
 * (Hint: Use an array of 100 Boolean elements, each of which indicates whether
 * a locker is open (true) or closed (false). Initially, all lockers are
 * closed.)
 *
 * Output: L1 L4 L9 L16 L25 L36 L49 L64 L81 L100
 *
 * @author martinfall
 */
public class GameLockerPuzzle {

    public static void main(String[] args) {
        final int N = 100;
        boolean[] array = new boolean[N];

        // Manipulate lockers
        closeLockers(array);

        // Display which lockers are open
        displayOpenLockers(array);
    }

    /**
     * Manipulate lockers
     *
     * @param array
     */
    public static void closeLockers(boolean[] array) {
        for (int student = 0; student < array.length; student++) {
            for (int locker = 0; locker < array.length; locker++) {
                // Do something
                if ((locker + 1) % (student + 1) == 0) {
                    array[locker] = !array[locker];
                }
            }
        }
    }

    /**
     * Display all open locker numbers separated by exactly one space
     *
     * @param array
     */
    public static void displayOpenLockers(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                System.out.print("L" + (i + 1) + " ");
            }
        }
    }
}
