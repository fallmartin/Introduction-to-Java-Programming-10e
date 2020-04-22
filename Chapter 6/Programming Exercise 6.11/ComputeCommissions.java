/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinfall
 */
public class ComputeCommissions {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.printf("%-20s%-20s%n", "Sales Amount", "Commission");
        System.out.println("------------------------------");
        for (int salesAmount = 10000; salesAmount <= 100000; salesAmount += 5000) {
            System.out.printf("%-20d%-20.1f%n", salesAmount, computeCommission(salesAmount));
        }
    }

    /**
     * Computes the commission, using the scheme in Programming Exercise 5.39
     *
     * @param salesAmount
     * @return
     */
    public static double computeCommission(double salesAmount) {

        double earnedCommission = 0;

        if (salesAmount >= 0.01 && salesAmount <= 5000) {
            earnedCommission += salesAmount * 0.08;
        }
        if (salesAmount >= 5000.01 && salesAmount <= 10000) {
            earnedCommission += (5000 * 0.08) + ((salesAmount - 5000) * 0.10);
        }
        if (salesAmount >= 10000.01) {
            earnedCommission += (5000 * 0.08) + (5000 * 0.10)
                    + ((salesAmount - 10000) * 0.12);
        }

        return earnedCommission;
    }
}
