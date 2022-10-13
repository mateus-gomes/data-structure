package data_structures.linkedlist;

public class DoubleLinkedList {

    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int length;

    public DoubleLinkedList(Object value) {
        this.head = new DoubleLinkedNode(value);
        this.tail = head;
        this.length = 1;
    }

    public void append(Object value){
        DoubleLinkedNode oldTail = tail;
        DoubleLinkedNode newTail = new DoubleLinkedNode(value);

        newTail.setPrevious(oldTail);
        tail = newTail;
        oldTail.setNext(tail);

        length++;
    }

    public void prepend(Object value){
        DoubleLinkedNode oldHead = head;
        DoubleLinkedNode newHead = new DoubleLinkedNode(value);

        oldHead.setPrevious(newHead);
        head = newHead;
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

        DoubleLinkedNode newNode = new DoubleLinkedNode(value);
        DoubleLinkedNode nextNode = findNode(index);
        DoubleLinkedNode previousNode = nextNode.getPrevious();

        previousNode.setNext(newNode);
        newNode.setPrevious(previousNode);
        newNode.setNext(nextNode);
        nextNode.setPrevious(newNode);
        length++;
    }

    public void delete(int index){
        if(index >= length){
            System.out.printf("Linked list have the length of %d, index %d is not a valid option\n", length, index);
            return;
        }

        if(index == 0){
            DoubleLinkedNode newHead = head.getNext();
            head = newHead;
            return;
        }

        DoubleLinkedNode deletedNode = findNode(index);
        DoubleLinkedNode previousNode = deletedNode.getPrevious();
        previousNode.setNext(deletedNode.getNext());
        length--;
    }

    private DoubleLinkedNode findNode(int index){
        DoubleLinkedNode currentNode = head;
        int counter = 0;

        while(counter <= index){
            DoubleLinkedNode nextNode = currentNode.getNext();

            if(counter == index){
                return currentNode;
            } else {
                currentNode = nextNode;
            }

            counter++;
        }

        return null;
    }

    public void print(){
        DoubleLinkedNode currentNode = head;

        while(currentNode != null){
            System.out.println(currentNode.getValue());
            DoubleLinkedNode nextNode = currentNode.getNext();
            currentNode = nextNode;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(10);

        doubleLinkedList.append(6);
        doubleLinkedList.append(16);
        doubleLinkedList.prepend(0);
        doubleLinkedList.insert(3, 99);
        doubleLinkedList.delete(4);

        doubleLinkedList.print();
    }

}
