/*
 * Output:

Miles      Kilometers  |  Kilometers      Miles
1          1.609       |  20              12.430    
2          3.218       |  25              15.538    
3          4.827       |  30              18.645    
4          6.436       |  35              21.753    
5          8.045       |  40              24.860    
6          9.654       |  45              27.968    
7          11.263      |  50              31.075    
8          12.872      |  55              34.183    
9          14.481      |  60              37.290    
10         16.090      |  65              40.398  

 */

/**
 *
 * @author martinfall
 */
public class DistanceUnitConverter {
    // Conversion from miles to kilometers
    public static void main(String[] args) {
        // 1 Kilogram is 2.2 pounds
        final double MILES_TO_KILOMETERS = 1.609;
        System.out.print("Miles      Kilometers");
        System.out.print("  |  ");
        System.out.println("Kilometers      Miles");
        
        for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            System.out.printf("%-10d %-10.3f", i, i * MILES_TO_KILOMETERS);
            System.out.print("  |  ");
            System.out.printf("%-15d %-10.3f\n", j, j / MILES_TO_KILOMETERS);
        }
    }
}
