package data_structures.linkedlist;

public class DoubleLinkedNode {

    private Object value;
    private DoubleLinkedNode next;
    private DoubleLinkedNode previous;

    public DoubleLinkedNode(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Object getValue() {
        return value;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }

    public DoubleLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedNode previous) {
        this.previous = previous;
    }
}
