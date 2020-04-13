
/**
 * ﻿Write a program that displays the pi value for i = 10000, 20000, ..., and
 * 100000.
 * 
 * Output: 
 * 3.1415826535897198
 */
/**
 *
 * @author martinfall
 */
public class ComputePi {

    public static void main(String[] args) {
        double sigma = 0, pi;

        // Calculate pi
        for (int i = 1; i <= 100000; i++) { // Change 100000 to the other numbers in exercise
            //System.out.println(Math.pow(-1, i + 1) + "/" + (2 * i - 1));
            sigma += Math.pow(-1, i + 1) / (2 * i - 1);
        } // This calculation gives us sigma from n = 0 to n = a predetermined number
        pi = 4 * sigma; // Multiply sigma by 4
        
        // Display pi
        System.out.println(pi);
    }
}
