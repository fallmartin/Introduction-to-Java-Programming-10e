
/**
 * Output:
 * java.lang.Exception: New info from method1
 *          at ChainedExceptionDemo.method1(ChainedExceptionDemo.java:19)
 *          at ChainedExceptionDemo.main(ChainedExceptionDemo.java:9)
 * Caused by: java.lang.Exception: New info from method2
 *          at ChainedExceptionDemo.method2(ChainedExceptionDemo.java:24)
 *          at ChainedExceptionDemo.method1(ChainedExceptionDemo.java:17)
 * ... 1 more 
 *
 * @author martinfall
 */
public class ChainedExceptionDemo {

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception ex) {
            throw new Exception("New info from method1", ex);
        }
    }

    private static void method2() throws Exception {
        throw new Exception("New info from method2");
    }
}
