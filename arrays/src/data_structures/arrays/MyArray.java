package data_structures.arrays;

import java.util.Arrays;

public class MyArray {
    private Object[] data;
    private int length;

    public MyArray() {
        this.length = 0;
        this.data = new Object[length];
    }

    private Object get(int index) {
        return data[index];
    }

    private int push(Object item){
        data = Arrays.copyOf(data, length+1);
        data[length] = item;
        length++;
        return length;
    }

    private Object pop() {
        if(length > 0){
            Object item = data[length-1];
            data =  Arrays.copyOf(data, --length);
            return item;
        } else {
            throw new ArrayIndexOutOfBoundsException("You are trying to pop an empty array!");
        }
    }

    private void delete(int index){
        shiftItems(index);
    }

    private void shiftItems(int index){
        for(int i = index; i < length - 1; i++){
            data[i] = this.data[i+1];
        }
        pop();
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.push("This");
        myArray.push("is");
        myArray.push("a");
        myArray.push("text");
        System.out.println(myArray);
        myArray.pop();
        myArray.push("array");
        System.out.println(myArray);
        myArray.delete(2);

        System.out.println(myArray);
    }
}

