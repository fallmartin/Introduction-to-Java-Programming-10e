
import java.util.ArrayList;

/**
 *
 * @author martinfall
 */
public class MyStack {

    private ArrayList<Object> list = new ArrayList<>();

    /**
     * Returns true if the stack is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns the top element in this stack without removing it.
     *
     * @return
     */
    public Object peek() {
        return list.get(list.size() - 1);
    }

    /**
     * Returns and removes the top element in this stack.
     *
     * @return
     */
    public Object pop() {
        Object o = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return o;
    }

    /**
     * Adds a new element to the top of this stack.
     *
     * @param o
     */
    public void push(Object o) {
        list.add(o);
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}
