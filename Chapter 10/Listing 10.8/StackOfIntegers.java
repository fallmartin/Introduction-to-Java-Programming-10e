
/**
 * Output:
 * 9 8 7 6 5 4 3 2 1 0
 *
 * @author martinfall
 */
class StackOfIntegers {

    private int[] elements; // An array to store integers in the stack.
    private int size; // The number of integers in the stack.
    private static final int DEFAULT_CAPACITY = 16; // Default capacity

    /**
     * Construct a stack with the default capacity 16
     */
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct a stack with the specified maximum capacity
     */
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    /**
     * Push a new integer to the top of the stack
     */
    public void push(int value) {
        // If the stack is full
        if (size >= elements.length) {
            // create a new array of twice the current capacity
            int[] temp = new int[elements.length * 2];
            // copy the contents of the current array to the new array
            System.arraycopy(elements, 0, temp, 0, elements.length);
            // Assign assign the reference of the new array to the current array 
            // in the stack
            elements = temp;
        }
        elements[size++] = value; // add the new value to the array
    }

    /**
     * Return and remove the top element from the stack
     */
    public int pop() {
        return elements[--size];
    }

    /**
     * Return the top element from the stack
     */
    public int peek() {
        return elements[size - 1];
    }

    /**
     * Test whether the stack is empty
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Return the number of elements in the stack
     */
    public int getSize() {
        return size;
    }
}
