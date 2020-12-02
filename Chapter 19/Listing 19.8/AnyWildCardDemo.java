
import java.util.ArrayList;

/**
 * Output:
 * -2 2 1
 *
 * @author martinfall
 */
public class AnyWildCardDemo {

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

        print(intStack);
    }

    /**
     * Prints objects and empties the stack.
     *
     * @param stack
     */
    public static void print(GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static class GenericStack<E> {

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
}
