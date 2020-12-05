
import java.util.ArrayList;

/**
 * (Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
 * implemented using composition.Define a new stack class that extends
 * ArrayList. Draw the UML diagram for the classes and then implement
 * GenericStack. Write a
 * test program that prompts the user to enter five strings and displays them in
 * reverse order.
 *
 * Output:
 * stack1: [London, Paris, Berlin]
 * stack2: [1, 2, 3]
 *
 * @author martinfall
 * @param <E>
 */
public class GenericStack<E> extends ArrayList<E> {

    /**
     * Returns the number of elements in the generic stack.
     *
     * @return
     */
    public int getSize() {
        return size();
    }

    /**
     * Returns the last element in the generic stack.
     *
     * @return
     */
    public E peek() {
        return get(getSize() - 1);
    }

    /**
     * Adds the specified element to the end of this generic stack.
     *
     * @param o
     */
    public void push(E o) {
        add(o);
    }

    /**
     * Removes the last element from the generic stack and returns it to the
     * caller.
     *
     * @return
     */
    public E pop() {
        E o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    /**
     * Returns true if this generic stack contains no elements.
     *
     * @return
     */
    public boolean isEmpty() {
        return isEmpty();
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        stack1.push("London");
        stack1.push("Paris");
        stack1.push("Berlin");

        GenericStack<Integer> stack2 = new GenericStack<>();
        stack2.push(1); // autoboxing 1 to new Integer(1)
        stack2.push(2);
        stack2.push(3);

        System.out.println("stack1: " + stack1.toString());
        System.out.println("stack2: " + stack2.toString());
    }
}
