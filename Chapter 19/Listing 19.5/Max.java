
/**
 * Output:
 * 1999
 *
 * @author martinfall
 */
public class Max {

    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        } else {
            return o2;
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // 23 is autoboxed into new Integer(23)
        // MaxUsingGenericType.max("Welcome", 23);
        System.out.println(Max.max(1999, 1899));
    }
}
