
/**
 * (Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to
 * implement it using an array rather than an ArrayList. You should check the
 * array size before adding a new element to the stack. If the array is full,
 * create a new array that doubles the current array size and copy the elements
 * from the current array to the new array.
 *
 * Output:
 *
 * stack: red
 *
 * stack: red, green
 *
 * stack: red, green, blue
 *
 * stack: red, green, blue
 *
 * stack: red, green
 *
 * stack: red
 *
 * stack: EMPTY STACK
 *
 * stack: EMPTY STACK
 *
 * @author martinfall
 */
public class GenericStack<E> {

    private int capacity = 32;
    private E[] elements;

    public GenericStack() {
        this.elements = (E[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return
     */
    public int getSize() {
        int counter = 0;

        for (E element : elements) {
            if (element != null) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns the last element in the generic stack.
     *
     * @return
     */
    public E peek() {
        if (getSize() == 0) {
            System.out.println("The stack is empty.");
            return null;
        } else {
            return elements[getSize() - 1];
        }
    }

    /**
     * Adds the specified element to the end of this generic stack.
     *
     * @param o
     */
    public void push(E o) {
        if (getSize() == capacity) {
            capacity *= 2;
            E[] tempElements = (E[]) new Object[capacity];
            System.arraycopy(elements, 0, tempElements, 0, elements.length);
        }
        elements[getSize()] = o;
    }

    /**
     * Removes the last element from the generic stack and returns it to the
     * caller.
     *
     * @return
     */
    public E pop() {
        if (!isEmpty()) {
            E o = elements[getSize() - 1];
            elements[getSize() - 1] = null;
            return o;
        } else {
            return null;
        }
    }

    /**
     * Returns true if this generic stack contains no elements.
     *
     * @return
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override // Returns a string representation of the generic stack
    public String toString() {
        String str = "stack: ";

        if (isEmpty()) {
            str = str + "EMPTY STACK";
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null) {
                    str = str + elements[i] + ", ";
                }
            }
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        stack1.push("red");
        System.out.println(stack1.toString());
        System.out.println();

        stack1.push("green");
        System.out.println(stack1.toString());
        System.out.println();

        stack1.push("blue");
        System.out.println(stack1.toString());
        System.out.println();

        stack1.peek();
        System.out.println(stack1.toString());
        System.out.println();

        stack1.pop();
        System.out.println(stack1.toString());
        System.out.println();

        stack1.pop();
        System.out.println(stack1.toString());
        System.out.println();

        stack1.pop();
        System.out.println(stack1.toString());
        System.out.println();

        stack1.pop();
        System.out.println(stack1.toString());
        System.out.println();
    }
}
