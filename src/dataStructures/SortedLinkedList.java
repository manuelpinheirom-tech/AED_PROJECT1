package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Sorted linked list Implementation
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class SortedLinkedList<E> extends LinkedList<E> implements SortedList<E> {
    /**
     * Comparator of elements.
     */
    private final Comparator<E> comparator;
    /**
     * Constructor of an empty sorted singly linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public SortedLinkedList(Comparator<E> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Returns the first element of the list.
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMin( ) throws NoSuchElementException {
        //TODO: Left as an exercise.
        if (isEmpty())
            throw new NoSuchElementException();
        return head.getElement();
    }

    /**
     * Returns the last element of the list.
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMax( ) throws NoSuchElementException {
        //TODO: Left as an exercise.
        if (isEmpty())
            throw new NoSuchElementException();
        return tail.getElement();
    }
    /**
     * Returns the first occurrence of the element equals to the given element in the list.
     * @return element in the list or null
     */
    @Override
    public E get(E element) {
        //TODO: Left as an exercise.
        LinkedNode<E> current = head;
        while (current != null) {
            if(current.getElement().equals(element))
                 return current.getElement();
            current = current.getNext();
        }
        return null;
    }
    /**
     * Returns true iff the element exists in the list.
     *
     * @param element to be found
     * @return true iff the element exists in the list.
     */
    public boolean contains(E element) {
        //TODO: Left as an exercise.
        return get(element) != null;
    }

    /**
     * Inserts the specified element at the list, according to the comparator order.
     * If there is an equal element, the new element is inserted after it.
     * @param element to be inserted
     */
    public void add(E element) {
        //TODO: Left as an exercise.
        if (isEmpty() || comparator.compare(element, tail.getElement()) >= 0) {
            addLast(element);
        } else if (comparator.compare(element, head.getElement()) < 0) {
            addFirst(element);
        } else {
            LinkedNode<E> prev = head;
            LinkedNode<E> curr = head.getNext();
            while (comparator.compare(element, curr.getElement()) >= 0) {
                prev = curr;
                curr = curr.getNext();
            }
            addMiddleNode(new pairNode<>(prev, curr), new SinglyListNode<>(element, null));
        }
        assert invariant();
    }

    /**
     * Inserts the element before node after.
     * Precondition: after is not the head of the list.
     * @param element - Element to be inserted
     * @param before - Node to be previous to the new node
     */
    void addBeforeNode(E element, LinkedNode<E> before){
        //TODO: Left as an exercise.
        LinkedNode<E> prev = head;
        while (prev != null && prev.getNext() != before)
            prev = prev.getNext();
        addMiddleNode(new pairNode<>(prev, before), new SinglyListNode<>(element, null));
    }

    /**
     * Inserts the element at the first position in the list.
     * @param element - Element to be inserted
     */
    void addFirst( E element ) {
        //TODO: Left as an exercise.
        LinkedNode<E> newNode = new SinglyListNode<E>(element, null);
        addFirstNode(newNode);
    }

    /**
     * Inserts the element at the last position in the list.
     * @param element - Element to be inserted
     */
    void addLast( E element ) {
        //TODO: Left as an exercise.
        LinkedNode<E> newNode = new SinglyListNode<E>(element, null);
        addLastNode(newNode);
    }

    /**
     * Removes and returns the first occurrence of the element equals to the given element in the list.
     * @return element removed from the list or null if !belongs
     */
    public E remove(E element) {
        //TODO: Left as an exercise.
        pairNode<E> pair = nodeOf(element);
        if (pair == null)
            return null;
        E removed = pair.node().getElement();
        if (pair.prev() == null)
            removeFirstNode();
        else if (pair.node() == tail)
            removeLastNode(pair);
        else
            removeMiddleNode(pair);
        return removed;
        //VE ME SE ESTA MERDA FAZ SENTUIDO SFF
    }

    void addElem(E element){
        //TODO: Left as an exercise.
        addLast(element);
    }


    private boolean invariant() {
        //TODO: Left as an exercise.
        return true;
        //MANU VE ESTA MERDA QUE TA NO ULTIMO SLIDE DO ULTIMO PPT E FAZ Q EU N TENHO PACIENCIA. ORBIGADFO
        //AGRADECE AO GEMINI TB
    }

    void writeData(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // write the normal attributes
    }
    void readData(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // read the normal attributes
    }
}
