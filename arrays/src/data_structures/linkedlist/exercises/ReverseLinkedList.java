package data_structures.linkedlist.exercises;

import data_structures.linkedlist.MyLinkedList;
import data_structures.linkedlist.Node;

public class ReverseLinkedList {

    //My solution
    public MyLinkedList reverseLinkedList(MyLinkedList linkedList){
        MyLinkedList reversedLinkedList = new MyLinkedList(0);

        Node currentNode = linkedList.getHead();

        while(currentNode != null){
            reversedLinkedList.prepend(currentNode.getValue());
            Node nextNode = currentNode.getNext();
            currentNode = nextNode;
        }

        reversedLinkedList.delete(reversedLinkedList.getLength()-1);
        return reversedLinkedList;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        MyLinkedList myLinkedList = new MyLinkedList(10);

        myLinkedList.append(6);
        myLinkedList.append(16);
        myLinkedList.append(10);
        myLinkedList.append(21);

        MyLinkedList reversedLinkedList = reverseLinkedList.reverseLinkedList(myLinkedList);
        reversedLinkedList.print();
    }
}
