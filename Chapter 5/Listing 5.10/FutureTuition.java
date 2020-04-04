/*
 * Output:
Tuition will be doubled in 11 years
Tuition will be $21048.52 in 11 years
 */

/**
 *
 * @author martinfall
 */
public class FutureTuition {
    public static void main(String[] args) {
        // Variable of type double initialized at 10,000
        double tuition = 10000;
        // Year 0
        int year = 0;
        
        // Increase the tuition yearly by 0.07 percent and increment the year
        while (tuition < 20000) {
            tuition *= 1.07;
            year++;
        }
        
        // Display the result
        System.out.println("Tuition will be doubled in " + year + " years");
        System.out.printf("Tuition will be $%.2f in %d years", tuition, year);
    }
}
