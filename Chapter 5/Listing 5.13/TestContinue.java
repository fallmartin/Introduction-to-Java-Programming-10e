/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class TestContinue {
    public static void main(String[] args) {
        int sum = 0;
        int number = 0;
        
        while (number < 20) {
            number++;
            if (number == 10 || number == 11) {
                continue;
            }
            sum += number;
        }
        
        System.out.println("The sum is " + sum);
    }
}
