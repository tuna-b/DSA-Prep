package Data_Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // TODO: Write switch statement using size as cases on what to do
    public void addFirst(E data) {
        // Invalid input check:
        if (data == null)
            throw new NullPointerException("Invalid data entry");

        // If list is empty:
        if (isEmpty()) {
            this.head = new Node(data, tail);
            this.tail = null;
        } else {
            Node node = new Node(data, head);
            this.head = node;
        }
        size++;
    }

    public void addLast(E data) {
        Node newNode = new Node(data, null);

        // Check if list is empty:
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Adding node to end of tail, then setting tail equal to new last node
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        // Check if list is empty
        if (isEmpty())
            throw new NoSuchElementException("List is empty");

        // define data to return
        E data = null;
        // Check if only one element in list
        if (size == 1) {
            data = head.data;
            head = null;
            tail = null;
        } else if (size == 2) {
            data = tail.data;
            tail = head;
        }

        else {
            data = head.data;
            this.head = this.head.next;
        }
        size--;
        return data;
    }

    public E removeLast() {
        // Check if list is empty
        if (isEmpty())
            throw new NoSuchElementException("List is empty");

        E data = null;

        // Removing node from a list with 1 element
        if (size == 1) {
            data = head.data;
            head = null;
            tail = null;
        } else {
            Node nextNode = this.head;
            while (nextNode != null) {
                // find last node in the list
                // node1 -> node2 -> node 3 -> node4 -> null
                if (nextNode.next.next == null) {
                    data = nextNode.next.data;
                    nextNode.next = null;
                    this.tail = nextNode;
                    break;
                } else {
                    nextNode = nextNode.next;
                }
            }
        }
        size--;
        return data;

    }

    public E getFirst() {
        return head.data;
    }

    public E getLast() {
        return tail.data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {
        private E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node current;

        public LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}