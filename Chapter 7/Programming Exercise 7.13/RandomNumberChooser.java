
/**
 * (Random number chooser) Write a method that returns a random number between
 * 1 and 54, excluding the numbers passed in the argument. The method header is
 * specified as follows:
 *
 * public static int getRandom(int... numbers)
 *
 * @author martinfall
 */
public class RandomNumberChooser {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        
        System.out.println(getRandom(array));
        
        System.out.println(getRandom(1, 2, 3));
        
        // Anonymous array
        System.out.println(getRandom(new int[] 
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
        21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
        51, 52, 53}));
    }

    public static int getRandom(int... numbers) {
        boolean flag; // Create a boolean flag and set to true if excluded
        int randomNumber; // int variable to hold the randomNumber

        // do-while loop
        do {
            flag = false; // assume that the number is not in the array

            // Generate a random number between 1 and 54
            randomNumber = 1 + (int) (Math.random() * 54);

            // Check the var length argument list array
            for (int number : numbers) { // For each element in the array
                if (number == randomNumber) { // If the numbers match
                    flag = true;
                    // Set the flag to true to signify that number is in the array
                }
            }

        } while (flag); // repeat loop while the flag is true

        return randomNumber; // return the randomly generated number
    }
}
