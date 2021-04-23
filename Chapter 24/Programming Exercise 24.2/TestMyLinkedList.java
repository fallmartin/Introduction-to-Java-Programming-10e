package mylinkedlist;

/**
 *
 * (Implement MyLinkedList). The implementations of the methods contains(E
 * e), get(int index),indexOf(E e), lastIndexOf(E e), and set(int index, E e)
 * are omitted in the text. Implement these methods.
 *
 * Output:
 *
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
        // System.out.println(list);

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
        System.out.println("(9) " + list);

        // Is America in this list
        System.out.println("(10) Does list contain America? "
                + list.contains("America"));

        // Is USA in this list
        System.out.println("(11) Does list contain USA? "
                + list.contains("USA"));

        // indexOf and get methods for index 1
        System.out.println("(12) indexOf and get methods");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i) + " is at index "
                    + list.indexOf(list.get(i)));
        }

        // lastIndexOf
        System.out.println("(13) The last index of "
                + list.get(list.size() - 2) + " is "
                + list.lastIndexOf(list.get(list.size() - 2)));

        // indexOf and get methods for index 1
        String placeholder = "India";
        System.out.println("(14) Set " + placeholder + " at each index in list ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.set(i, placeholder));
            System.out.println(list);
        }

        // Use a for-each loop to traverse the list
        for (String s : list) {
            System.out.print(s.toUpperCase() + " ");
        }
    }
}
