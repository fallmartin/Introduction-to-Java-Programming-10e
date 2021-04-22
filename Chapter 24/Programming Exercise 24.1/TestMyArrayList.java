package setoperations;

/**
 * (Add set operations in MyList) Define the following methods in MyList and
 * implement them in MyAbstractList.
 *
 * Adds the elements in otherList to this list.
 * Returns true if this list changed as a result of the call.
 * public boolean addAll(MyList<E> otherList);
 *
 * Removes all the elements in otherList from this list
 * Returns true if this list changed as a result of the call
 * public boolean removeAll(MyList<E> otherList);
 *
 * Retains the elements in this list that are also in otherList
 * Returns true if this list changed as a result of the call
 * public boolean retainAll(MyList<E> otherList);
 *
 * Write a test program that creates two MyArrayLists, list1 and list2, with the
 * initial values {"Tom", "George", "Peter", "Jean", "Jane"} and {"Tom",
 * "George", "Michael", "Michelle", "Daniel"}, then perform the following
 * operations:
 *
 * ■ Invokes list1.addAll(list2), and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values, invokes
 * list1.removeAll(list2), and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values, invokes
 * list1.retainAll(list2), and displays list1 and list2.
 *
 * Output:
 * list1: [Tom, George, Peter, Jean, Jane]
 * list2: [Tom, George, Michael, Michelle, Daniel]
 *
 * list1: [Tom, George, Peter, Jean, Jane, Michael, Michelle, Daniel]
 * list2: [Tom, George, Michael, Michelle, Daniel]
 *
 * list1: [Peter, Jean, Jane]
 * list2: [Tom, George, Michael, Michelle, Daniel]
 *
 * list1: [Tom, George]
 * list2: [Tom, George]
 *
 * @author martinfall
 */
public class TestMyArrayList {

    /**
     * Main method with driver code to test the MyArrayList class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create two instances of the MyArrayList
        // Create list1
        MyArrayList<String> list1 = new MyArrayList<>(
                new String[]{"Tom", "George", "Peter", "Jean", "Jane"});

        // Create list2
        MyArrayList<String> list2 = new MyArrayList<>(
                new String[]{"Tom", "George", "Michael", "Michelle", "Daniel"});

        // Create copies of list1 and list2 to restore them later;
        MyArrayList<String> list1Copy = getListCopy(list1);
        MyArrayList<String> list2Copy = getListCopy(list2);

        // Display list1 and list2
        displayLists(list1, list2);

        // Invoke list1.addAll(list2), and display list1 and list2
        list1.addAll(list2);
        displayLists(list1, list2);

        // Recreate list1 and list2 with the same initial values
        list1 = getListCopy(list1Copy);
        list2 = getListCopy(list2Copy);

        // Invoke list1.removeAll(list2), and display list1 and list2
        list1.removeAll(list2);
        displayLists(list1, list2);

        // Recreate list1 and list2 with the same initial values
        list1 = getListCopy(list1Copy);
        list2 = getListCopy(list2Copy);

        // Invoke list1.retainAll(list2), and display list1 and list2
        list1.retainAll(list2);
        displayLists(list1, list2);
    }

    /**
     * Displays list1 and list2 to the console.
     *
     * @param <E>
     * @param list1
     * @param list2
     */
    public static <E> void displayLists(
            MyArrayList<E> list1, MyArrayList<E> list2) {
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2 + "\n");
    }

    /**
     * Returns a copy of the list.
     *
     * @param list the list to copy
     * @return
     */
    public static <E> MyArrayList<E> getListCopy(MyArrayList<E> list) {
        // Create a new MyArrayList object
        MyArrayList<E> listCopy = new MyArrayList<>();

        // Copy the contents of list into listCopy
        for (int i = 0; i < list.size(); i++) {
            listCopy.add(list.get(i));
        }

        // Return the copy of the list
        return listCopy;
    }
}
