package data_structures.queues;

import data_structures.linkedlist.Node;
import data_structures.stacks.StackWithLinkedList;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Object peek(){
        return first.getValue();
    }

    public void enqueue(Object value){
        Node newItem = new Node(value);

        if (length == 0){
            first = newItem;
            last = first;
        }else{
            Node oldLastItem = last;
            oldLastItem.setNext(newItem);
            last = newItem;
        }

        length++;
    }

    public Object dequeue(){
        if (length == 1){
            Node dequeuedObject = first;
            first = null;
            last = null;
            length--;

            return dequeuedObject;
        }

        Node oldFirst = first;
        first = first.getNext();

        return oldFirst.getValue();
    }

    public void print(){
        Node currentNode = first;

        while(currentNode != null){
            System.out.println(currentNode.getValue());
            Node nextNode = currentNode.getNext();
            currentNode = nextNode;
        }
    }


    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(13);
        queue.enqueue(6);
        queue.enqueue(98);

        queue.print();

        System.out.println("Peek number is " + queue.peek());

        System.out.println("Popping the number " + queue.dequeue());
        queue.enqueue(77);

        queue.print();

        System.out.println("Popping the number " + queue.dequeue());
        System.out.println("Popping the number " + queue.dequeue());
        System.out.println("Popping the number " + queue.dequeue());

        queue.print();
    }
}
