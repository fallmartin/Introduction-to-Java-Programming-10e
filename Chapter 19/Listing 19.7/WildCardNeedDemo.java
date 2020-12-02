
import java.util.ArrayList;

/**
 *
 * @author martinfall
 */
public class WildCardNeedDemo {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1); // 1 is autoboxed into new Integer
        intStack.push(2);
        intStack.push(-2);

        /**
         * The program in Listing 19.7 has a compile error in the following line
         * because intStack is not an instance of GenericStack<Number>. Thus,
         * you cannot invoke max(intStack).
         */
        System.out.println("The max number is " + max(intStack));
    }

    /**
     * Find the maximum in a stack of numbers.
     *
     * @param stack
     * @return
     */
    public static double max(GenericStack<? extends Number> stack) {
        double max = stack.pop().doubleValue();

        while (!stack.isEmpty()) {
            double value = stack.pop().doubleValue();
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}

class GenericStack<E> {

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
}
