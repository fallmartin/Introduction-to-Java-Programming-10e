
/**
 * (Order three cities) Write a program that prompts the user to enter three
 * cities and displays them in ascending order. Here is a sample run:
 *
 * Enter the first city: Chicago
 * Enter the second city: Los Angeles
 * Enter the third city: Atlanta
 * The three cities in alphabetical order are Atlanta Chicago Los Angeles
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class OrderThreeCities {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Declare a String variable temp
        String temp;

        // Prompt the user to enter the first city
        System.out.print("Enter the first city: ");
        String city1 = input.nextLine();

        // Prompt the user to enter the second city
        System.out.print("Enter the second city: ");
        String city2 = input.nextLine();

        // Compare city1 and city2
        if (city1.compareTo(city2) > 0) {
            temp = city1;
            city1 = city2;
            city2 = temp;
        }

        // Prompt the user to enter the third city
        System.out.print("Enter the third city: ");
        String city3 = input.nextLine();
        
        // Order the cities 
        
        // stringA.compareTo( stringB ) < 0 when stringA and stringB are in the 
        // correct order.

        if (city2.compareTo(city3) < 0) {
            System.out.println(city1 + " " + city2 + " " + city3);
        } else {
            if (city1.compareTo(city3) < 0) {
                System.out.println(city1 + " " + city3 + " " + city2);
            } else if (city3.compareTo(city1) < 0) {
                System.out.println(city3 + " " + city1 + " " + city2);
            }
        }
    }
}
