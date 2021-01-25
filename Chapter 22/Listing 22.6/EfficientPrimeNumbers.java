
import java.util.*;

/**
 * Output:
 * Find all prime numbers <= n, enter n: 1000
 * The numbers are *
 * 2 3 5 7 11 13 17 19 23 29
 * 31 37 41 43 47 53 59 61 67 71
 * 73 79 83 89 97 101 103 107 109 113
 * 127 131 137 139 149 151 157 163 167 173
 * 179 181 191 193 197 199 211 223 227 229
 * 233 239 241 251 257 263 269 271 277 281
 * 283 293 307 311 313 317 331 337 347 349
 * 353 359 367 373 379 383 389 397 401 409
 * 419 421 431 433 439 443 449 457 461 463
 * 467 479 487 491 499 503 509 521 523 541
 * 547 557 563 569 571 577 587 593 599 601
 * 607 613 617 619 631 641 643 647 653 659
 * 661 673 677 683 691 701 709 719 727 733
 * 739 743 751 757 761 769 773 787 797 809
 * 811 821 823 827 829 839 853 857 859 863
 * 877 881 883 887 907 911 919 929 937 941
 * 947 953 967 971 977 983 991 997
 * 168 prime(s) less than or equal to 1000
 *
 * @author martinfall
 */
public class EfficientPrimeNumbers {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Find all prime numbers <= n, enter n: ");
        int n = input.nextInt();

        // A list to hold prime numbers
        List<Integer> list = new ArrayList<>();

        final int NUMBER_PER_LINE = 10; // Display 10 numbers per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot

        System.out.println("The numbers are \n");

        // Repeatedly find prime numbers
        while (number <= n) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            // Test whether number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) { // if true, not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count
                list.add(number); // Add a new prime to the list

                if (count % NUMBER_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.println(number);
                } else {
                    System.out.print(number + " ");
                }
            }

            // Check whether the next number is prime
            number++;
        }

        System.out.println(
                "\n" + count + " prime(s) less than or equal to " + n);
    }
}
