
/**
 * Output:
 * (1) [America]
 * (2) [Canada, America]
 * (3) [Canada, America, Russia]
 * (4) [Canada, America, Russia, France]
 * (5) [Canada, America, Germany, Russia, France]
 * (6) [Canada, America, Germany, Russia, France, Norway]
 * (7) [America, Germany, Russia, France, Norway]
 * (8) [America, Germany, France, Norway]
 * (9) [America, Germany, France]
 * (10) AMERICA GERMANY FRANCE
 *
 * @author martinfall
 */
public class TestMyLinkedList {

    /**
     * Main method with driver code to test the MyArrayList class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a list
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println(list);

        // Add elements to the list
        list.add("America"); // Add it to the list
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2) " + list);

        list.add("Russia"); // Add it to the end of the list
        System.out.println("(3) " + list);

        list.add("France"); // Add it to the end of the list
        System.out.println("(4) " + list);

        list.add(2, "Germany"); // Add it to the list at index 2
        System.out.println("(5) " + list);

        list.add(5, "Norway"); // Add it to the list at index 5
        System.out.println("(6) " + list);

        // Remove elements from the list
        list.remove("Canada"); // Same as list.remove(0) in this case
        System.out.println("(7) " + list);

        list.remove(2); // Remove the element at index 2
        System.out.println("(8) " + list);

        list.remove(list.size() - 1); // Remove the last element
        System.out.print("(9) " + list + "\n(10) ");

        // Use a for-each loop to traverse the list
        for (String s : list) {
            System.out.print(s.toUpperCase() + " ");
        }
    }
}
