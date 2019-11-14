public class ShowRuntimeErrors {
    public static void main(String[] args) {
        // Will throw an exception in thread "main" java.lang.ArithmeticException: / by zero
        System.out.println(1 / 0);
    }
}
