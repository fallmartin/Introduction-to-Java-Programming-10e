
import java.util.ArrayList;

/**
 * (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to
 * perform a deep copy of the list field.
 *
 * @author martinfall
 */
public class MyStack implements Cloneable {

    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    @Override
    /**
     * Override the toString in the Object class
     */
    public String toString() {
        return "stack: " + list.toString();
    }

    /**
     * Override the protected clone method defined in 25 the Object class, and
     * strengthen its accessibility
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // Perform a shallow copy
        MyStack clone = (MyStack) super.clone();
        // Deep copy on whenBuilt
        clone.list = (ArrayList<Object>) (list.clone());
        return clone;
    }

}
