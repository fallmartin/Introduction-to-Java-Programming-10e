/*
(Print a table) Write a program that displays the following table. Cast floatingpoint
numbers into integers.
a   b   pow(a, b)
1   2   1
2   3   8
3   4   81
4   5   1024
5   6   15625

Actual output:
a	b	pow(a, b)
1 2	1
2	3	8
3	4	81
4	5	1024
5	6	15625
 */

/**
 *
 * @author martinfall
 */
public class PrintTable {

    public static void main(String[] args) {
        System.out.println("a\tb\tpow(a, b)");
        for (int i = 1; i < 6; i++) {
            System.out.println(i + "\t" + (i + 1) + "\t" + (int) Math.pow(i, i + 1));
        }
    }
}
