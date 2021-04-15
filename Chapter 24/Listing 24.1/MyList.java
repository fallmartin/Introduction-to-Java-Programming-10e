
/**
 *
 * @author martinfall
 * @param <E>
 */
public interface MyList<E> extends Iterable<E> {

    /**
     * Appends a new element at the end of this list.
     *
     * @param e
     */
    public void add(E e);

    /**
     * Inserts a new element at the specified index in this list.
     *
     * @param index
     * @param e
     */
    public void add(int index, E e);

    /**
     * Removes all the elements from this list.
     */
    public void clear();

    /**
     * Returns true if this list contains the specified element.
     *
     * @param e
     * @return
     */
    public boolean contains(E e);

    /**
     * Returns the element from this list at the specified index.
     *
     * @param index
     * @return
     */
    public E get(int index);

    /**
     * Returns the index of the first matching element in this list. Returns -1
     * if no match is found.
     *
     * @param e
     * @return
     */
    public int indexOf(E e);

    /**
     * Returns true if this list does not contain any elements.
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Returns the index of the last matching element in this list. Returns -1
     * if no match is found.
     *
     * @param e
     * @return
     */
    public int lastIndexOf(E e);

    /**
     * Remove the first occurrence of the element e from this list. Shift any
     * subsequent elements to the left. Return true if the element is removed.
     *
     * @param e
     * @return
     */
    public boolean remove(E e);

    /**
     * Removes the element at the specified index and returns the removed
     * element. Shift any subsequent elements to the left. Return the element
     * that was removed from the list.
     *
     * @param index
     * @return
     */
    public E remove(int index);

    /**
     * Sets the element at the specified index and returns the element being
     * replaced.
     *
     * @param index
     * @param e
     * @return
     */
    public Object set(int index, E e);

    /**
     * Returns the number of elements in this list.
     *
     * @return
     */
    public int size();
}
