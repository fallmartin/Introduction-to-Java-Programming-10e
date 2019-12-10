/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class SimpleIfDemo {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.println("Enter an integer: ");

        // Collect user input
        int number = input.nextInt();

        // Check 5
        if (number % 5 == 0) {
            System.out.println("HiFive");
        }

        // Check even
        if (number % 2 == 0) {
            System.out.println("HiEven");
        }
    }
}
