package data_structures.stacks;

public class StacksWithArray {

    private Object[] data;
    private int length;

    public StacksWithArray(int length) {
        this.data = new Object[length];
        this.length = 0;
    }

    public Object peek(){
        return data[length-1];
    }

    public void push(Object value){
        data[length] = value;
        length++;
    }

    public Object pop(){
        Object lastItem = data[length-1];
        data[length-1] = null;
        length--;

        return lastItem;
    }

    public void print(){
        for(int i = 0; i < length; i++){
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        StacksWithArray stacksWithArray = new StacksWithArray(10);

        stacksWithArray.push(13);
        stacksWithArray.push(6);
        stacksWithArray.push(98);

        stacksWithArray.print();

        System.out.println("Peek number is " + stacksWithArray.peek());

        System.out.println("Popping the number " + stacksWithArray.pop());
        stacksWithArray.push(77);

        stacksWithArray.print();

        System.out.println("Popping the number " + stacksWithArray.pop());
        System.out.println("Popping the number " + stacksWithArray.pop());
        System.out.println("Popping the number " + stacksWithArray.pop());

        stacksWithArray.print();
    }
}
