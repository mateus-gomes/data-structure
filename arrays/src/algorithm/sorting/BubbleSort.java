package algorithm.sorting;

public class BubbleSort {

    public int[] bubbleSort(int[] array){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++){
                if(array[j] > array[j+1]){
                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temporary;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        int[] sortedArray = bubbleSort.bubbleSort(array);

        for(int i = 0; i < sortedArray.length; i++){
            System.out.println(sortedArray[i] + ", ");
        }
    }
}
