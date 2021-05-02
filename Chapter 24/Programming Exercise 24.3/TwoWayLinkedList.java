package twowaylinkedlist;

import java.util.*;

/**
 * (Implement a doubly linked list) The MyLinkedList class used in Listing 24.6
 * is a one-way directional linked list that enables one-way traversal of the
 * list. Modify the Node class to add the new data field name previous to refer
 * to the previous node in the list, as follows:
 *
 * (see book for class Node implementation)
 *
 * Implement a new class named TwoWayLinkedList that uses a doubly linked list
 * to store elements. The MyLinkedList class in the text extends MyAbstractList.
 * Define TwoWayLinkedList to extend the java.util.AbstractSequentialList class.
 * You need to implement all the methods defined in MyLinkedList as well as the
 * methods listIterator() and listIterator(int index). Both return an instance
 * of java.util. ListIterator<E>. The former sets the cursor to the head of the
 * list and the latter to the element at the specified index.
 *
 * @author martinfall
 * @param <E>
 */
public class TwoWayLinkedList<E> extends AbstractSequentialList<E> {

    Node<E> first; // first node
    Node<E> last; // last node
    int size; // list size

    // The head of the list is at position index -1 and continues up to size - 1
    public static final int HEAD_OF_THE_LIST = -1;

    /**
     * Default constructor. Constructs a new empty two-way linked list.
     */
    public TwoWayLinkedList() {
    }

    /**
     * Constructs a new two-way linked list from an array of elements.
     *
     * @param elements an array of elements
     */
    public TwoWayLinkedList(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list
     */
    public E getFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.element;
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element in the list
     */
    public E getLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.element;
    }

    /**
     * Removes and returns the first element in the list.
     *
     * @return the first element in the list
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        } else {
            return unlinkFirst();
        }
    }

    /**
     * Removes and returns the last element in the list.
     *
     * @return the last element in the list
     */
    public E removeLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        } else {
            return unlinkLast();
        }
    }

    /**
     * Adds the element e at the head of the list.
     *
     * @param e the element to add at the head of the list
     */
    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * Add the element e to the tail of the list.
     *
     * @param e the element to add at the tail of the list
     */
    public void addLast(E e) {
        linkLast(e);
    }

    // Link element e to the head of the list
    private void linkFirst(E e) {
        final Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;

        if (f == null) {
            last = newNode;
        } else {
            f.previous = newNode;
        }

        size++;
    }

    // link elemnt e to the tail of the list
    private void linkLast(E e) {
        final Node<E> l = last;

        Node<E> newNode = new Node<>(l, e, null);

        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    // Link element e before node next
    private void linkBefore(E e, Node<E> next) {
        if (next == null) {
            throw new NoSuchElementException();
        }

        final Node<E> previous = next.previous;
        final Node<E> newNode = new Node<>(previous, e, next);

        next.previous = newNode;
        if (previous == null) {
            first = newNode;
        } else {
            previous.next = newNode;
        }

        size++;
    }

    // Unlink the node
    private E unlink(Node<E> node) {
        if (node == null) {
            throw new NoSuchElementException();
        }

        final E element = node.element;
        final Node<E> next = node.next;
        final Node<E> previous = node.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            node.previous = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            node.next = null;
        }

        node.element = null;
        size--;

        return element;
    }

    // Unlink the first node in the list
    private E unlinkFirst() {
        // return unlink(first);

        final E element = first.element;
        final Node<E> next = first.next;

        // LinkedList helps GC by setting first.element and first.next to null
        if (next == null) {
            last = null;
        } else {
            next.previous = null;
        }

        size--;
        return element;
    }

    // Unlink the last node in the list
    private E unlinkLast() {
        // return unlink(last);
        final E element = last.element;
        final Node<E> previous = last.previous;

        if (previous == null) {
            first = null;
        } else {
            previous.next = null;
        }

        size--;
        return element;
    }

    // Returns true if index is a valid position index
    private boolean isPositionIndex(int index) {
        return index >= HEAD_OF_THE_LIST && index <= size;
    }

    // Returns true if index is a valid element index
    private boolean isElementIndex(int index) {
        return index >= HEAD_OF_THE_LIST && index < size;
    }

    // Returns the node at index
    private Node<E> node(int index) {
        if (!isElementIndex(index)) {
            throw new NoSuchElementException();
        }

        Node<E> f = first;
        for (int i = HEAD_OF_THE_LIST; i < index; i++) {
            f = f.next;
        }
        return f;
    }

    @Override // Override the remove method of the AbstractSequentialList class
    public E remove(int index) {
        if (!isElementIndex(index)) {
            throw new NoSuchElementException();
        } else {
            return unlink(node(index));
        }
    }

    @Override // Override the add method of the AbstractSequentialList class
    public void add(int index, E element) {
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override // Override the set method of the AbstractSequentialList class
    public E set(int index, E element) {
        if (!isPositionIndex(index)) {
            throw new NoSuchElementException();
        }

        final Node<E> n = node(index);
        final E oldElement = n.element;
        n.element = element;
        return oldElement;
    }

    @Override // Override the get method of the AbstractSequentialList class
    public E get(int index) {
        if (!isPositionIndex(index)) {
            throw new NoSuchElementException();
        }
        return node(index).element;
    }

    @Override // Override the clear method of the AbstractList class
    public void clear() {
        Node<E> f = first;
        while (f != null) {
            Node<E> next = f.next;

            // unlink(f) instead of the next three lines
            f = null;
            f.next = null;
            f.previous = null;

            f = next;
        }

        first = null;
        last = null;
        size = 0;
    }

    @Override // Override the lastIndexOf method of the AbstractList class
    public int lastIndexOf(Object o) {
        int index = size;

        if (o == null) {
            for (Node<E> n = last; n != null; n = n.previous) {
                index--;
                if (n.element == null) {
                    return index;
                }
            }
        } else {
            for (Node<E> n = last; n != null; n = n.previous) {
                index--;
                if (o.equals(n.element)) {
                    return index;
                }
            }
        }

        return HEAD_OF_THE_LIST - 1;
    }

    @Override // Override the indexOf method of the AbstractList class
    public int indexOf(Object o) {
        int index = HEAD_OF_THE_LIST;

        if (o == null) {
            for (Node<E> n = first; n != null; n = n.next) {
                if (n.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> n = first; n != null; n = n.next) {
                if (o.equals(n.element)) {
                    return index;
                }
                index++;
            }
        }

        return HEAD_OF_THE_LIST - 1;
    }

    @Override // Override the add method of the AbstractList class
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override // Override the remove method of the AbstractCollection class
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> n = first; n != null; n = n.next) {
                if (n.element == null) {
                    unlink(n);
                    return true;
                }
            }
        } else {
            for (Node<E> n = first; n != null; n = n.next) {
                if (o.equals(n.element)) {
                    unlink(n);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // Override the contains method of the AbstractCollection class
    public boolean contains(Object o) {
        return indexOf(o) >= HEAD_OF_THE_LIST;
    }

    @Override // Override the listIterator method of the AbstractList class
    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator(HEAD_OF_THE_LIST);
    }

    @Override // Override the listIterator method of the AbstractSequentialList class
    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    @Override // Override the size method of the AbstractCollection class
    public int size() {
        return size;
    }

    @Override // Override the isEmpty method of the AbstractCollection class
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * A representation of a node (element) in a list with previous and next
     * values.
     *
     * @param <E>
     */
    private static class Node<E> {

        Node<E> previous; // previous element
        E element; // element
        Node<E> next; // next element

        /**
         * Default class constructor with element and specified previous and
         * next nodes.
         *
         * @param previous
         * @param element
         * @param next
         */
        public Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }

    }

    /**
     * An iterator for two way linked lists that allows the programmer to
     * traverse the list in either direction, modify the list during iteration,
     * and obtain the iterator's current position in the list.
     */
    private class TwoWayLinkedListIterator implements ListIterator<E> {

        // Last returned node, next node, and next index
        Node<E> lastReturned;
        Node<E> next;
        int nextIndex;

        /**
         * Default constructor with specified index. The head of the list is at
         * index -1.
         *
         * @param index
         */
        public TwoWayLinkedListIterator(int index) {
            if (!isPositionIndex(index)) {
                index = HEAD_OF_THE_LIST;
            }

            next = (index == size) ? null : node(index);
            nextIndex = index;

        }

        @Override
        public boolean hasNext() {
            return nextIndex < size - 1;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > HEAD_OF_THE_LIST + 1;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            lastReturned = next = (next == null) ? last : next.previous;
            nextIndex--;
            return lastReturned.element;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            Node<E> lastReturnedNext = lastReturned.next;
            unlink(lastReturned);

            // Handle the extremities
            if (next == lastReturned) {
                next = lastReturnedNext;
            } else {
                nextIndex--;
            }

            lastReturned = null;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }

            lastReturned.element = e;
        }

        @Override
        public void add(E e) {
            lastReturned = null;
            if (next == null) {
                linkLast(e);
            } else if (next.previous == null) {
                linkBefore(e, next);
            }

            nextIndex++;
        }
    }
}
