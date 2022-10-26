package algorithm.sorting;

public class InsertionSort {

    public int[] insertionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j <= i; j++){
                if(array[j] > array[i]){
                    int temporary = array[i];
                    array[i] = array[j];
                    array[j] = temporary;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        int[] sortedArray = insertionSort.insertionSort(array);

        for(int i = 0; i < sortedArray.length; i++){
            System.out.println(sortedArray[i] + ", ");
        }
    }
}
