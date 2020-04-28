
/**
 * Before invoking swap
 * array is {1, 2}
 * After invoking swap
 * array is {1, 2}
 *
 * Before invoking swapFirstTwoInArray
 * array is {1, 2}
 * After invoking swapFirstTwoInArray
 * array is {2, 1}
 *
 * @author martinfall
 */
public class TestPassArray {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2}; // Declare and create a new int array

        // Swap elements using the swap method
        System.out.println("Before invoking swap");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
        swap(a[0], a[1]);
        System.out.println("After invoking swap");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");

        // Print a line for readability
        System.out.println();

        // Swap elements using the swapFirstTwoInArray method
        System.out.println("Before invoking swapFirstTwoInArray");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
        swapFirstTwoInArray(a);
        System.out.println("After invoking swapFirstTwoInArray");
        System.out.println("array is {" + a[0] + ", " + a[1] + "}");
    }

    /**
     * Swap two variables
     */
    public static void swap(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }

    /**
     * Swap the first two elements in the array
     *
     * @param array
     */
    public static void swapFirstTwoInArray(int[] array) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;

    }
}
