
/**
 * Output:
 * 1 2 3 4 5
 * London Paris New York Austin
 * 1 2 3 4 5
 * London Paris New York Austin
 *
 * @author martinfall
 */
public class GenericMethodDemo {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        String[] strings = {"London", "Paris", "New York", "Austin"};

        // prefix the method name with the actual type in angle brackets
        GenericMethodDemo.<Integer>print(integers);
        GenericMethodDemo.<String>print(strings);

        // the actual type is not explicitly specified
        // The compiler automatically discovers the actual type
        print(integers);
        print(strings);
    }

    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
