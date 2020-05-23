
/**
 * (Culture: Chinese Zodiac) Simplify Listing 3.9 using an array of strings to
 * store the animal names.
 *
 * @author martinfall
 */
public class ChineseZodiac {

    public static void main(String[] args) {
        // Local import of java.util.Scanner
        // Create a new Scanner object
        java.util.Scanner input = new java.util.Scanner(System.in);

        // Prompt the user to enter a year
        System.out.print("Enter a year: ");

        // Collect input from user
        int year = input.nextInt();

        // Display the results
        System.out.println("Your chinese zodiac sign is " + getZodiacSign(year));
    }

    /**
     * Returns the corresponding Chinese zodiac sign for the passed year
     *
     * @param year
     * @return
     */
    public static String getZodiacSign(int year) {
        // Chinese zodiac signs in array 011
        String[] sign = {"monkey", "rooster", "dog", "pig", "rat", "ox", "tiger",
            "rabbit", "dragon", "snake", "horse", "horse", "sheep"};

        return sign[year % 12];
    }
}
