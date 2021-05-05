package genericstack;

import java.util.LinkedList;

/**
 * The GenericStack class encapsulates the stack storage and provides the
 * operations for manipulating the stack.
 *
 * @author martinfall
 */
public class GenericStack<E> {

    // An array to store elements
    LinkedList<E> list;

    /**
     * Creates an empty stack.
     */
    public GenericStack() {
        list = new LinkedList<>();
    }

    public GenericStack(E[] list) {
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Returns the top element in this stack.
     *
     * @return
     */
    public E peek() {
        return list.get(getSize() - 1);
    }

    /**
     * Returns and removes the top element in this stack.
     *
     * @return
     */
    public E pop() {
        return list.remove(getSize() - 1);
    }

    /**
     * Adds a new element to the top of this stack.
     *
     * @param o
     */
    public void push(E o) {
        list.add(o);
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override // Override the toString method of the Object class
    public String toString() {
        return "stack: " + list.toString();
    }
}
