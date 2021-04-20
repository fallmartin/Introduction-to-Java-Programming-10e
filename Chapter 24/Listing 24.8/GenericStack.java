package teststackqueue;

import java.util.ArrayList;

/**
 * GenericStack uses an array list to provide a last-in, first-out (LIFO) data
 * structure.
 *
 * @author martinfall
 */
public class GenericStack<E> {

    // An array list to store elements
    private ArrayList<E> list = new ArrayList<>();

    /**
     * Creates an empty stack.
     */
    public GenericStack() {
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns the top element in this stack.
     *
     * @return the top element in this stack
     */
    public E peek() {
        return list.get(getSize() - 1);
    }

    /**
     * Returns and removes the top element in this stack.
     *
     * @return the top element in this stack
     */
    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    /**
     * Adds a new element to the top of this stack.
     *
     * @param o the element to add to the top of this stack
     */
    public void push(E o) {
        list.add(o);
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override // Override the toString method fo the Object class
    public String toString() {
        return "Stack: " + list.toString();
    }
}
