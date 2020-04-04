/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class TestSum {
    public static void main(String[] args) {
        // Initialize sum
        double sum = 0;
        double currentValue = 0.01;
        
        // Add 0.01, 0.02, ..., 0.99, 1 to sum
        for (int count = 0; count < 100; count++) {
            sum += currentValue;
            currentValue += 0.01;
        }
        
        // Display result
        System.out.println("The sum is " + sum);
    }
}
