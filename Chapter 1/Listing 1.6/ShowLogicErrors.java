public class ShowLogicErrors {
    public static void main(String[] args) {
        System.out.println("Celsius 35 is Fahrenheit degree ");
        // System.out.println((9 / 5) * 35 + 32);
        // Integer division results in the quotient
        // The fractional part is truncated
        // Change 9 to 9.0 to retain the decimal 
        System.out.println((9.0 / 5) * 35 + 32);
    }
}
