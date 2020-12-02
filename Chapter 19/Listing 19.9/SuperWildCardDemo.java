
import java.util.ArrayList;

/**
 * This program will also work if the method header in lines 12–13 is
 * modified as follows:
 *
 * public static <T> void add(GenericStack<? extends T> stack1,
 * GenericStack<T> stack2)
 *
 * Output:
 * Sun 2 Java
 *
 * @author martinfall
 */
public class SuperWildCardDemo {

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        GenericStack<Object> stack2 = new GenericStack<>();

        stack2.push("Java");
        stack2.push(2);
        stack1.push("Sun");
        add(stack1, stack2);
        print(stack2);
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

    /**
     *
     * @param <T>
     * @param stack1
     * @param stack2
     */
    public static <T> void add(GenericStack<T> stack1,
            GenericStack<? super T> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
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
