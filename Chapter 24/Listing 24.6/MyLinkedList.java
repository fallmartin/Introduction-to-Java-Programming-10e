
import java.util.*;

/**
 * MyLinkedList implements a list using a linked list of nodes.
 *
 * @author martinfall
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    Node<E> head, tail;

    /**
     * Creates a default linked list.
     */
    public MyLinkedList() {
        // No-args constructor
    }

    /**
     * Creates a linked list from an array of elements.
     *
     * @param elements
     */
    public MyLinkedList(E[] elements) {
        super(elements);
    }

    /**
     * Returns the first element in the list.
     *
     * @param e
     * @return
     */
    public E getFirst(E e) {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /**
     * Returns the last element in the list.
     *
     * @param e
     * @return
     */
    public E getLast(E e) {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /**
     * Adds an element to the head of the list.
     *
     * @param e
     */
    public void addFirst(E e) {
        // Create a new node
        Node<E> newNode = new Node<>(e);

        // link the new node with the head
        newNode.next = head;

        // head points to the new node
        head = newNode;

        // Increase list size
        size++;

        // The new node is the only node in lis
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Adds an element to the tail of the list.
     *
     * @param e
     */
    public void addLast(E e) {
        // Create a new node for e
        Node<E> newNode = new Node<>(e);

        if (tail == null) {
            head = tail = newNode; // The only node in list
        } else {
            // Link the new node with the last node
            tail.next = newNode;

            // tail now points to the last node
            tail = tail.next;
        }

        // Increase size
        size++;
    }

    /**
     * Add a new element at the specified index in this list. The index of the
     * head element is 0
     */
    @Override
    public void add(int index, E e) {
        if (index == 0) { // Insert first
            addFirst(e);
        } else if (index >= size) { // Insert last
            addLast(e);
        } else {
            // Create a new node to store the new element
            Node<E> current = head;

            // Locate where to insert it
            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            //  the new node is to be inserted between current and temp
            Node<E> temp = current.next;

            // Assign the new node to current.next
            current.next = new Node<>(e);

            // Assigns temp to the new node’s next
            (current.next).next = temp;

            // Increase size
            size++;
        }
    }

    /**
     * Removes the first element from the list.
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            // Keep the first node temporarily
            Node<E> temp = head;

            // Move head to point to next node
            head = head.next;

            // Reduce size by 1
            size--;

            // List becomes empty
            if (head == null) {
                tail = null;
            }

            // Return the deleted element
            return temp.element;
        }
    }

    /**
     * Removes the last element from the list.
     */
    public E removeLast() {
        if (size == 0) {
            return null; // Nothing to remove
        } // Only one element in the list
        else if (size == 1) {
            // Keep the first node temporarily
            Node<E> temp = head;

            // list becomes empty
            head = tail = null;
            size = 0;

            // Return the deleted element
            return temp.element;
        } else {
            Node<E> current = head;

            // Locate the penultimate node
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            // Keep the tail temporarily
            Node<E> temp = tail;

            // Link current to tail and point tail.next to null
            tail = current;
            tail.next = null;

            // Decrement the size
            size--;

            // Return the removed element
            return temp.element;
        }
    }

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null; // Out of range
        } else if (index == 0) {
            return removeFirst(); // Remove first
        } else if (index == size - 1) {
            return removeLast(); // Remove last
        } else {
            //  Find the node previous to the node at index
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            // The node at the current index
            Node<E> current = previous.next;

            // Assign current.next to previous.next
            previous.next = current.next;
            size--; // Decrease the size by 1

            // Return the current element
            return current.element;
        }
    }

    @Override // Override the toString method of the Object class
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;

            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    /**
     * Clear the list.
     */
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    /**
     * Returns true if this list contains the element e.
     *
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return true;
            } else {
                current = current.next;
            }
        }

        System.out.println("Implementation left as an exercise");
        return false;
    }

    /**
     * Return the element at the specified index.
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    @Override
    public int indexOf(E e) {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    /**
     * Return the index of the last matching element in this list. Return -1 if
     * no match.
     */
    @Override
    public int lastIndexOf(E e) {
        System.out.println("Implementation left as an exercise");
        return 0;
    }

    /**
     * Replace the element at the specified position in this list with the
     * specified element.
     *
     * @param index
     * @param e
     * @return
     */
    @Override
    public E set(int index, E e) {
        System.out.println("Implementation left as an exercise");
        return null;
    }

    @Override // Override iterator() defined in Iterable
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * The private LinkedListIterator implements the Iterator interface. This
     * class is only used in LinkedList, so it is private.
     */
    private class LinkedListIterator implements Iterator<E> {

        private Node<E> current = head; // Current index

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return (current != null); // current.next != null???
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        /**
         * Removes from the underlying collection the last element returned by
         * this iterator.
         */
        @Override
        public void remove() {
            System.out.println("Implementation left as an exercise");
        }

    }

    /**
     * This class is only used in LinkedList, so it is private. This class does
     * not need to access any instance members of LinkedList, so it is defined
     * static.
     *
     * @param <E>
     */
    private static class Node<E> {

        E element; // element
        Node<E> next; // next Node

        /**
         * Creates a new Node with the specified element.
         *
         * @param element
         */
        public Node(E element) {
            this.element = element;
        }
    }
}
