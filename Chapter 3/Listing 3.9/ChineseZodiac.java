/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
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

        System.out.print("Your chinese zodiac sign is ");
        // Switch through cases 0-11
        switch (year % 12) {
            case 0:
                System.out.println("monkey");
                break;
            case 1:
                System.out.println("rooster");
                break;
            case 2:
                System.out.println("dog");
                break;
            case 3:
                System.out.println("pig");
                break;
            case 4:
                System.out.println("rat");
                break;
            case 5:
                System.out.println("ox");
                break;
            case 6:
                System.out.println("tiger");
                break;
            case 7:
                System.out.println("rabbit");
                break;
            case 8:
                System.out.println("dragon");
                break;
            case 9:
                System.out.println("snake");
                break;
            case 10:
                System.out.println("horse");
                break;
            case 11:
                System.out.println("sheep");
        }
    }
}
