/*
 * Output:

Miles      Kilometers
1          1.609     
2          3.218     
3          4.827     
4          6.436     
5          8.045     
6          9.654     
7          11.263    
8          12.872    
9          14.481    
10         16.090

 */

/**
 *
 * @author martinfall
 */
public class MilesToKilometersConverter {
    public static void main(String[] args) {
        // 1 Kilogram is 2.2 pounds
        final double MILES_TO_KILOMETERS = 1.609;
        System.out.println("Miles      Kilometers");
        
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-10d %-10.3f\n", i, i * MILES_TO_KILOMETERS);
        }
    }
}
