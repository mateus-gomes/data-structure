package data_structures.stacks;

import data_structures.linkedlist.Node;

public class StackWithLinkedList {

    private Node bottom;
    private Node top;
    private int length;

    public StackWithLinkedList() {
        this.bottom = null;
        this.top = null;
        this.length = 0;
    }

    public Object peek(){
        return top.getValue();
    }

    public void push(Object value){
        Node newItem = new Node(value);

        if(length == 0){
            top = newItem;
            bottom = top;
        } else {
            Node oldTop = top;
            oldTop.setNext(newItem);
            top = newItem;
        }

        length++;
    }

    public Object pop(){
        Node currentNode = bottom;

        if(length == 1){
            bottom = null;
            top = null;
            length--;
            return currentNode.getValue();
        }

        while(currentNode.getNext() != null){
            if(currentNode.getNext().getNext() == null){
                Node removedItem = currentNode.getNext();
                top = currentNode;
                top.setNext(null);
                length--;
                return removedItem.getValue();
            }
            currentNode = currentNode.getNext();
        }

        return null;
    }

    public void print(){
        Node currentNode = bottom;

        while(currentNode != null){
            System.out.println(currentNode.getValue());
            Node nextNode = currentNode.getNext();
            currentNode = nextNode;
        }
    }

    public static void main(String[] args) {
        StackWithLinkedList stackWithLinkedList = new StackWithLinkedList();

        stackWithLinkedList.push(13);
        stackWithLinkedList.push(6);
        stackWithLinkedList.push(98);

        stackWithLinkedList.print();

        System.out.println("Peek number is " + stackWithLinkedList.peek());

        System.out.println("Popping the number " + stackWithLinkedList.pop());
        stackWithLinkedList.push(77);

        stackWithLinkedList.print();

        System.out.println("Popping the number " + stackWithLinkedList.pop());
        System.out.println("Popping the number " + stackWithLinkedList.pop());
        System.out.println("Popping the number " + stackWithLinkedList.pop());

        stackWithLinkedList.print();
    }
}
