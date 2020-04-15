
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 * (Display calendars) Write a program that prompts the user to enter the year
 * and first day of the year and displays the calendar table for the year on the
 * console. For example, if the user entered the year 2013, and 2 for Tuesday,
 * January 1, 2013, your program should display the calendar for each month in
 * the year, as follows:
 * 
 * Output:
 * 
Enter the year: 2020
Enter the first day of the year.
Enter 0 for Sunday, 1 for Monday, 2 for Tuesday, ... 3

           January 2020            
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                 1    2    3    4  
  5    6    7    8    9   10   11  
 12   13   14   15   16   17   18  
 19   20   21   22   23   24   25  
 26   27   28   29   30   31  

           February 2020           
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                                1  
  2    3    4    5    6    7    8  
  9   10   11   12   13   14   15  
 16   17   18   19   20   21   22  
 23   24   25   26   27   28   29  


            March 2020             
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
  1    2    3    4    5    6    7  
  8    9   10   11   12   13   14  
 15   16   17   18   19   20   21  
 22   23   24   25   26   27   28  
 29   30   31  

            April 2020             
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                 1    2    3    4  
  5    6    7    8    9   10   11  
 12   13   14   15   16   17   18  
 19   20   21   22   23   24   25  
 26   27   28   29   30  

             May 2020              
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                           1    2  
  3    4    5    6    7    8    9  
 10   11   12   13   14   15   16  
 17   18   19   20   21   22   23  
 24   25   26   27   28   29   30  
 31  

             June 2020             
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
       1    2    3    4    5    6  
  7    8    9   10   11   12   13  
 14   15   16   17   18   19   20  
 21   22   23   24   25   26   27  
 28   29   30  

             July 2020             
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                 1    2    3    4  
  5    6    7    8    9   10   11  
 12   13   14   15   16   17   18  
 19   20   21   22   23   24   25  
 26   27   28   29   30   31  

            August 2020            
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                                1  
  2    3    4    5    6    7    8  
  9   10   11   12   13   14   15  
 16   17   18   19   20   21   22  
 23   24   25   26   27   28   29  
 30   31  

          September 2020           
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
            1    2    3    4    5  
  6    7    8    9   10   11   12  
 13   14   15   16   17   18   19  
 20   21   22   23   24   25   26  
 27   28   29   30  

           October 2020            
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
                      1    2    3  
  4    5    6    7    8    9   10  
 11   12   13   14   15   16   17  
 18   19   20   21   22   23   24  
 25   26   27   28   29   30   31  


           November 2020           
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
  1    2    3    4    5    6    7  
  8    9   10   11   12   13   14  
 15   16   17   18   19   20   21  
 22   23   24   25   26   27   28  
 29   30  

           December 2020           
-----------------------------------
 Sun  Mon  Tue  Wed  Thu  Fri  Sat 
            1    2    3    4    5  
  6    7    8    9   10   11   12  
 13   14   15   16   17   18   19  
 20   21   22   23   24   25   26  
 27   28   29   30   31  

 * 
 */
/**
 *
 * @author martinfall
 */
public class DisplayCalendars {

    public static void main(String[] args) {
        // Constant variable for number of days per line
        final int DAYS_PER_LINE = 7;

        // Declare boolean flag for leap year and set to false
        boolean isLeap = false;

        // Create a new Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year
        System.out.print("Enter the year: ");
        int year = input.nextInt();

        // Is is a leap year?
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            isLeap = true;
        }

        // Prompt the user to enter the first day of the year
        System.out.println("Enter the first day of the year.");
        System.out.print("Enter 0 for Sunday, 1 for Monday, 2 for Tuesday, ... ");
        int day = input.nextInt();

        // Print a new line
        System.out.println();

        // Loop through the 12 months of the year
        for (int month = 1; month <= 12; month++) {
            String s = ""; // Create an empty string and populate through the loop

            // Concatenate month to string s
            switch (month) {
                case 1:
                    s += "January";
                    break;
                case 2:
                    s += "February";
                    break;
                case 3:
                    s += "March";
                    break;
                case 4:
                    s += "April";
                    break;
                case 5:
                    s += "May";
                    break;
                case 6:
                    s += "June";
                    break;
                case 7:
                    s += "July";
                    break;
                case 8:
                    s += "August";
                    break;
                case 9:
                    s += "September";
                    break;
                case 10:
                    s += "October";
                    break;
                case 11:
                    s += "November";
                    break;
                case 12:
                    s += "December";
                    break;
            }

            // Concatenate the year to string s
            s += " " + year;

            // Display the monthly header
            System.out.printf("%s%n", StringUtils.center(s, 35));
            System.out.println("-----------------------------------");
            System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat ");

            // Calculate the day from the first day of the year
            day %= 7;

            // Print the right amount of white spaces before each date
            for (int blanks = 0; blanks < day * 5; blanks++) {
                System.out.print(" ");
            }

            // Determine the number of days in the month
            int monthLength;

            switch (month) { // use a fall through switch case pattern
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    monthLength = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    monthLength = 30;
                    break;
                default:
                    if (isLeap) {
                        monthLength = 29;
                    } else {
                        monthLength = 28;
                    }
                    break;
            }

            // Print the dates of the month
            for (int i = 1; i <= monthLength; i++) {
                System.out.printf("%s", StringUtils.center(String.valueOf(i), 5));
                // Print a new line after Saturday
                if (day % 7 == 6) {
                    System.out.println();
                }
                // Increment the day
                day++;
            }

            // Whew!!! New line please
            System.out.println("\n");
        }
    }
}
