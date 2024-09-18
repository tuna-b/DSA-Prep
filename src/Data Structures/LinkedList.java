public class LinkedList<E> {
    Node head;
    Node tail;

    public void addFirst(E data) {
        // edge case: LinkedList is empty:
        if (head.next == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node node = new Node(data);
            node.next = head;
            this.head = node;
        }
    }

    public void addLast(E data) {
        Node node = new Node(data);
        this.tail.next = node;
        this.tail = node;
    }
    public Node removeFirst() {
        Node returnNode = head;
        head = head.next;
        return returnNode;
    }
    public Node removeLast() {
        
    }
    public void getFirst(Node node) {
        
    }
    public void getLast(Node node) {
        
    }


    private class Node {
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
        }
    }
}
