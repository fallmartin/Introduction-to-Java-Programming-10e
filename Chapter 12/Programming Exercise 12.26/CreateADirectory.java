
import java.io.File;
import java.util.Scanner;

/**
 * (Create a directory) Write a program that prompts the user to enter a
 * directory name and creates a directory using the File’s mkdirs method. The
 * program displays the message “Directory created successfully” if a directory
 * is created or “Directory already exists” if the directory already exists.
 *
 * Output:
 * Enter a directory name: MyPhotos
 * Directory created successfully
 *
 * Enter a directory name: MyPhotos
 * Directory already exists
 *
 * @author martinfall
 */
public class CreateADirectory {

    public static void main(String[] args) {
        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a directory name
        System.out.print("Enter a directory name: ");
        // Collect user input
        File dir = new File(input.nextLine());

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Directory already exists");
        } else {
            dir.mkdir();
            System.out.println("Directory created successfully");
        }
    }
}
