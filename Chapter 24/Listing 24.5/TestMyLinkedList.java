
/**
 * Output:
 * (1) [America]
 * (2) [Canada, America]
 * (3) [Canada, America, Russia]
 * (4) [Canada, America, Russia, France]
 * (5) [Canada, America, Germany, Russia, France]
 * (6) [Canada, America, Germany, Russia, France, Norway]
 * (7) [Poland, Canada, America, Germany, Russia, France, Norway]
 * (8) [Canada, America, Germany, Russia, France, Norway]
 * (9) [Canada, America, Russia, France, Norway]
 * (10) [Canada, America, Russia, France]
 * (11) CANADA AMERICA RUSSIA FRANCE
 *
 * @author martinfall
 */
public class TestMyLinkedList {

    /**
     * Main method with driver code to test the MyLinkedList class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a list for Strings
        MyLinkedList<String> list = new MyLinkedList<>();

        // Add elements to the list
        list.add("America"); // Add it to the list
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2) " + list);

        list.add("Russia"); // Add it to the end of the list
        System.out.println("(3) " + list);

        list.addLast("France"); // Add it to the end of the list
        System.out.println("(4) " + list);

        list.add(2, "Germany"); // Add it to the list at index 2
        System.out.println("(5) " + list);

        list.add(5, "Norway"); // Add it to the list at index 5
        System.out.println("(6) " + list);

        list.add(0, "Poland"); // Same as list.addFirst("Poland")
        System.out.println("(7) " + list);

        // Remove elements from the list
        list.remove(0); // Same as list.remove("Poland") in this case
        System.out.println("(8) " + list);

        list.remove(2); // Remove the element at index 2
        System.out.println("(9) " + list);

        list.remove(list.size() - 1); // Remove the last element
        System.out.print("(10) " + list + "\n(11) ");

        // Use a for-each loop to traverse the list
        for (String s : list) {
            System.out.print(s.toUpperCase() + " ");
        }

        System.out.println(); // Print the line separator string
    }
}
