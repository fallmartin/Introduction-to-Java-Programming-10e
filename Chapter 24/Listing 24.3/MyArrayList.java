
import java.util.Iterator;

/**
 *
 * @author martinfall
 */
public class MyArrayList<E> extends MyAbstractList<E> {

    private static final int INITIAL_CAPACITY = 16; // Initial capacity
    private E[] data = (E[]) (new Object[INITIAL_CAPACITY]); // Create an array

    /**
     * Creates a default array list.
     */
    public MyArrayList() {
    }

    /**
     * Creates an array list from an array of objects.
     *
     * @param objects
     */
    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]); // // Warning: don't use super(objects)!
        }
    }

    /**
     * Trims the capacity of this array list to the list’s current size.
     */
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // If size == capacity, no need to trim
    }

    /**
     * Doubles the current array size if needed. Creates a new larger array,
     * double the current size + 1.
     */
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]); // Double capacity + 1
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    /**
     * Throws an exception if the index is out of bounds in the list.
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "index " + index + " out of bounds");
        }
    }

    /**
     * Adds a new element at the specified index.
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        ensureCapacity();

        // Move the elements to the right after the specified index
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // Insert new element at data[index]
        data[index] = e;

        // Increase size by 1
        size++;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        data = (E[]) (new Object[INITIAL_CAPACITY]);
        size = 0;
    }

    /**
     * Returns true if this list contains the element.
     *
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * Returns the index of the first matching element in this list. Returns -1
     * if no match is found.
     *
     * @param e
     * @return
     */
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the index of the last matching element in this list. Return -1 if
     * no match is found.
     *
     * @param e
     * @return
     */
    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove the element at the specified position in this list. Shift any
     * subsequent elements to the left. Return the element that was removed from
     * the list.
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];

        // Shift data to the left
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }

        data[size - 1] = null; // This element is now null

        // Decrement size
        size--;

        return e;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public Object set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    /**
     * Overrides the toString method of the Object class.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }

        return result.toString() + "]";
    }

    /**
     * Overrides the iterator method of the Iterable interface.
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator(); // Iterator object
    }

    /**
     * The private class ArrayListIterator implements the Iterator interface and
     * overrides the hasNext, next, and remove methods.
     */
    private class ArrayListIterator implements Iterator<E> {

        private int current = 0; // Current index

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }

    }
}
