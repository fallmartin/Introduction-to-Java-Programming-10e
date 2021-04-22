package setoperations;

/**
 * (Add set operations in MyList) Define the following methods in MyList and
 * implement them in MyAbstractList.
 *
 * Adds the elements in otherList to this list.
 * Returns true if this list changed as a result of the call.
 * public boolean addAll(MyList<E> otherList);
 *
 * Removes all the elements in otherList from this list
 * Returns true if this list changed as a result of the call
 * public boolean removeAll(MyList<E> otherList);
 *
 * Retains the elements in this list that are also in otherList
 * Returns true if this list changed as a result of the call
 * public boolean retainAll(MyList<E> otherList);
 *
 * Write a test program that creates two MyArrayLists, list1 and list2, with the
 * initial values {"Tom", "George", "Peter", "Jean", "Jane"} and {"Tom",
 * "George", "Michael", "Michelle", "Daniel"}, then perform the following
 * operations:
 *
 * ■ Invokes list1.addAll(list2), and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values, invokes
 * list1.removeAll(list2), and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values, invokes
 * list1.retainAll(list2), and displays list1 and list2.
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

    /**
     * Adds the elements in otherList to this list. Returns true if this list
     * changed as a result of the call.
     *
     * @param otherList
     * @return
     */
    public boolean addAll(MyList<E> otherList);

    /**
     * Removes all the elements in otherList from this list. Returns true if
     * this list changed as a result of the call.
     *
     * @param otherList
     * @return
     */
    public boolean removeAll(MyList<E> otherList);

    /**
     * Retains the elements in this list that are also in otherList. Returns
     * true if this list changed as a result of the call.
     *
     * @param otherList
     * @return
     */
    public boolean retainAll(MyList<E> otherList);
}
