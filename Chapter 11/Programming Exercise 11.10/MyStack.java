
import java.util.ArrayList;

/**
 * (Implement MyStack using inheritance) In Listing 11.10, MyStack is using
 * composition. Define a new stack class that extends ArrayList.
 *
 * Draw the UML diagram for the classes and then implement MyStack. Write
 * a test program that prompts the user to enter five strings and displays them
 * in reverse order.
 *
 * @author martinfall
 */
public class MyStack extends ArrayList {

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return
     */
    public int getSize() {
        return size();
    }

    /**
     * Returns the top element in this stack without removing it.
     *
     * @return
     */
    public Object peek() {
        return get(size() - 1);
    }

    /**
     * Returns and removes the top element in this stack.
     *
     * @return
     */
    public Object pop() {
        Object o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    /**
     * Adds a new element to the top of this stack.
     *
     * @param o
     */
    public void push(Object o) {
        add(o);
    }

    @Override
    public String toString() {
        int size = size();
        Object[] o = this.toArray();
        String s = "";
        
        System.out.println("Display the list in reverse order:");
        for (int i = size - 1; i >= 0 ; i--) {
            s = s + o[i] + "\n";
        }
        return s;
    } 
}
