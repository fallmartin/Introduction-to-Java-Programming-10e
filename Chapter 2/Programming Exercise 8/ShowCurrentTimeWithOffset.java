/*
(Current time) Listing 2.7, ShowCurrentTime.java, gives a program that displays
the current time in GMT. Revise the program so that it prompts the user to enter
the time zone offset to GMT and displays the time in the specified time zone. 

Here is a sample run:

Enter the time zone offset to GMT: −5
The current time is 4:50:34
 */

import java.util.Scanner;

/**
 *
 * @author martinfall
 */
public class ShowCurrentTimeWithOffset {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);
        
        // Promt the user to enter the time zone offset to GMT
        System.out.print("Enter the time zone offset to GMT: ");
        int offset = input.nextInt();
        
        // Obtain the total milliseconds since midnight, January 1, 1970
        // Also known as Unix epoch
        
        //long totalMilliseconds = 1203183068328L; 
        long totalMilliseconds = System.currentTimeMillis();
        
        // Obtain the total seconds totalSeconds by dividing totalMilliseconds by 1000
        long totalSeconds = totalMilliseconds / 1000;
        
        // Compute the current second from totalSeconds % 60
        long currentSecond = totalSeconds % 60;
        
        // Obtain the total minutes totalMinutes by dividing totalSeconds by 60
        long totalMinutes = totalSeconds / 60;
        
        // Compute the current minute from totalMinutes % 60
        long currentMinute = totalMinutes % 60;
        
        // Obtain the total hours totalHours by dividing totalMinutes by 60
        long totalHours = totalMinutes / 60;
        
        // Compute the current hour in GMT from totalHours % 24
        long currentHour = totalHours % 24;
        
        // Computer the current hour with time zone offset
        currentHour += offset;
        
        System.out.println("The current time is " + currentHour + ":" 
                + currentMinute + ":" + currentSecond);
    }
}
