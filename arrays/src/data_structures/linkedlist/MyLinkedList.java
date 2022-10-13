package data_structures.linkedlist;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public MyLinkedList(Object value) {
        this.head = new Node(value);
        this.tail = head;
        this.length = 1;
    }

    public void append(Object value){
        Node newTail = new Node(value);
        Node oldTail = tail;

        tail = newTail;
        oldTail.setNext(tail);
        length++;
    }

    public void prepend(Object value){
        Node oldHead = head;
        head = new Node(value);
        head.setNext(oldHead);

        length++;
    }

    public void insert(int index, Object value){
        if(index >= length){
            System.out.printf("Linked list have the length of %d, index %d is not a valid option\n", length, index);
            return;
        }

        if(index == 0){
            prepend(value);
            return;
        }

        Node newNode = new Node(value);
        Node previousNode = findPreviousNode(index);

        Node auxiliarNode = previousNode.getNext();
        previousNode.setNext(newNode);
        newNode.setNext(auxiliarNode);
        length++;
    }

    public void delete(int index){
        if(index >= length){
            System.out.printf("Linked list have the length of %d, index %d is not a valid option\n", length, index);
            return;
        }

        if(index == 0){
            Node newHead = head.getNext();
            head = newHead;
            return;
        }

        Node previousNode = findPreviousNode(index);
        Node deletedNode = previousNode.getNext();
        previousNode.setNext(deletedNode.getNext());
        length--;
    }

    private Node findPreviousNode(int index){
        Node currentNode = head;
        int counter = 0;

        while(counter <= index){
            Node nextNode = currentNode.getNext();

            if(counter == index-1){
                return currentNode;
            } else {
                currentNode = nextNode;
            }

            counter++;
        }

        return null;
    }

    public void print(){
        Node currentNode = head;

        while(currentNode != null){
            System.out.println(currentNode.getValue());
            Node nextNode = currentNode.getNext();
            currentNode = nextNode;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);

        myLinkedList.append(6);
        myLinkedList.append(16);
        myLinkedList.prepend(0);
        myLinkedList.insert(3, 99);
        myLinkedList.delete(1);

        myLinkedList.print();
    }
}
