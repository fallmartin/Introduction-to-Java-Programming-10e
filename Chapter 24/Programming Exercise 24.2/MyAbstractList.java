package mylinkedlist;

/**
 *
 * @author martinfall
 */
public abstract class MyAbstractList<E> implements MyList<E> {

    protected int size; // The size of the list

    /**
     * Creates a default list.
     */
    protected MyAbstractList() {
    }

    /**
     * Creates a list from an array of objects.
     *
     * @param objects
     */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    /*
     * Add a new element at the end of this list
     */
    public final void add(E e) {
        add(size, e);
    }

    @Override
    /**
     * Return true if this list doesn't contain any elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /**
     * Return the number of elements in this list
     */
    public int size() {
        return size;
    }

    @Override
    /**
     * Remove the first occurrence of the element e from this list. Shift any
     * subsequent elements to the left. Return true if the element is removed.
     */
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }

}
