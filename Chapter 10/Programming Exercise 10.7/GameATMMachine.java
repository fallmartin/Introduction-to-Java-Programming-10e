
import java.util.Scanner;

/**
 * (Game: ATM machine) Use the Account class created in Programming Exercise 9.7
 * to simulate an ATM machine. Create ten accounts in an array with id
 * 0, 1, . . . , 9, and initial balance $100. The system prompts the user to
 * enter
 * an id. If the id is entered incorrectly, ask the user to enter a correct id.
 * Once an id is accepted, the main menu is displayed as shown in the sample
 * run.
 * You can enter a choice 1 for viewing the current balance, 2 for withdrawing
 * money, 3 for depositing money, and 4 for exiting the main menu. Once you
 * exit,
 * the system will prompt for an id again. Thus, once the system starts, it will
 * not stop.
 *
 * Enter an id: 4
 *
 * Main menu
 * 1: check balance
 * 2: withdraw
 * 3: deposit
 * 4: exit
 * Enter a choice: 1
 * The balance is 100.0
 *
 * Main menu
 * 1: check balance
 * 2: withdraw
 * 3: deposit
 * 4: exit
 * Enter a choice: 2
 * Enter an amount to withdraw: 3
 *
 * Main menu
 * 1: check balance
 * 2: withdraw
 * 3: deposit
 * 4: exit
 * Enter a choice: 1
 * The balance is 97.0
 *
 * Main menu
 * 1: check balance
 * 2: withdraw
 * 3: deposit
 * 4: exit
 * Enter a choice: 3
 * Enter an amount to deposit: 10
 *
 * Main menu
 * 1: check balance
 * 2: withdraw
 * 3: deposit
 * 4: exit
 * Enter a choice: 1
 * The balance is 107.0
 *
 * Main menu
 * 1: check balance
 * 2: withdraw
 * 3: deposit
 * 4: exit
 * Enter a choice: 4
 *
 * Enter an id:
 *
 * @author martinfall
 */
public class GameATMMachine {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Create ten accounts in an array.
        Account[] accounts = new Account[10];

        // Declare the choice variable for the main menu
        int choice;

        // Initialize each account with id 0, 1, . . . , 9, and initial balance $100
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        // while true continues to run until stopped manually
        while (true) {
            System.out.print("\nEnter an id: ");
            int id = input.nextInt();

            // If the account id is valid
            if (id >= 0 && id <= 9) {
                // Choose an option from the main menu
                choice = showMainMenu(input);

                // While the option chosen is not 4 for exit
                while (choice != 4) {
                    // Switch the user input
                    switch (choice) {
                        case 1:
                            // Check the balance
                            System.out.println("The balance is "
                                    + accounts[id].getBalance());
                            choice = showMainMenu(input);
                            break;
                        case 2:
                            // Withdraw an amount
                            System.out.print("Enter an amount to withdraw: ");
                            accounts[id].withdraw(input.nextInt());
                            choice = showMainMenu(input);
                            break;
                        case 3:
                            // Deposit an amount
                            System.out.print("Enter an amount to deposit: ");
                            accounts[id].deposit(input.nextInt());
                            choice = showMainMenu(input);
                            break;
                        default:
                            // Incorrect input
                            System.out.println("Not a valid option");
                            choice = showMainMenu(input);
                            break;
                    }
                }
            } else {
                System.out.println("Not a valid option");
                continue;
            }
        }
    }

    /**
     * Displays the main menu to console
     *
     * @param input
     * @return
     */
    public static int showMainMenu(Scanner input) {
        System.out.println("\nMain menu:");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
        System.out.print("Enter a choice: ");
        // Collect a choice from user
        int choice = input.nextInt();
        return choice;
    }
}
