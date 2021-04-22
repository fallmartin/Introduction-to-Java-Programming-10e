package setoperations;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void add(E e) {
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

    // Adds the elements in otherList to this list. 
    // Returns true if this list changed as a result of the call
    @Override // Override the addAll method of the MyList interface
    public boolean addAll(MyList<E> otherList) {
        // Remember the current size of this list
        int thisCurrentSize = size();

        // For each element in otherList
        for (E e : otherList) {
            // If this list does not contain e, add e to it
            if (!contains(e)) {
                add(e);
            }
        }

        // Returns true if this list changed and false otherwise
        return thisCurrentSize != size();
    }

    // Removes all the elements in otherList from this list.
    // Returns true if this list changed as a result of the call.
    @Override // Override the removeAll method of the MyList interface
    public boolean removeAll(MyList<E> otherList) {
        // Remember the current size of this list
        int thisCurrentSize = size();

        // For each element in otherList
        for (E e : otherList) {
            // If this list does not contain e, add e to it
            remove(e);
        }

        // Returns true if this list changed and false otherwise
        return thisCurrentSize != size();
    }

    // Retains the elements in this list that are also in otherList. 
    // Returns true if this list changed as a result of the call.
    @Override // Override the retainAll method of the MyList interface
    public boolean retainAll(MyList<E> otherList) {

        // Remember the current size of this list
        int thisCurrentSize = size();

        // This list in other list?
        for (int i = 0; i < this.size(); i++) {
            if (!otherList.contains(this.get(i))) {
                this.remove(i);
                i--;
            }
        }

        // Other list in this list?
        for (int i = 0; i < otherList.size(); i++) {
            if (!this.contains(otherList.get(i))) {
                otherList.remove(i);
                i--;
            }
        }

        // Returns true if this list changed and false otherwise
        return thisCurrentSize != size();
    }

}
