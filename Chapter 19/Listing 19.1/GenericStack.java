
import java.util.ArrayList;

/**
 * Output:
 * stack: [London, Paris, Berlin]
 * stack: [1, 2, 3]
 *
 * @author martinfall
 */
public class GenericStack<E> {

    private ArrayList<E> list = new ArrayList<>();

    /**
     * Returns the number of elements in the generic stack.
     *
     * @return
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns the last element in the generic stack.
     *
     * @return
     */
    public E peek() {
        return list.get(getSize() - 1);
    }

    /**
     * Adds the specified element to the end of this generic stack.
     *
     * @param o
     */
    public void push(E o) {
        list.add(o);
    }

    /**
     * Removes the last element from the generic stack and returns it to the
     * caller.
     *
     * @return
     */
    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    /**
     * Returns true if this generic stack contains no elements.
     *
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override // Returns a string representation of the generic stack
    public String toString() {
        return "stack: " + list.toString();
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

        System.out.println(stack1.toString());
        System.out.println(stack2.toString());
    }
}
