/*
 * Output:
Enter first integer: 125
Enter second integer: 2525
The greatest common divisor for 125 and 2525 is 25
 */
import java.util.Scanner;
/**
 *
 * @author martinfall
 */
public class GreatestCommonDivisor {
    /* Main method */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);
        
        // Prompt the user to enter 2 integers
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();
        
        int gcd = 1; // Initial gcd is 1
        
        int k = 2; // Possible gcd
        
        // While n1 and n2 are greater than k and k is a gcd
        while(k <= n1 && k <= n2) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
            k++;
        }
        
        System.out.println("The greatest common divisor for " + n1 + " and " +
                n2 + " is " + gcd);
    }
}
