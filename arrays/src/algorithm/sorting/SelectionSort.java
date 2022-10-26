package algorithm.sorting;

public class SelectionSort {

    public int[] selectionSort(int[] array){

        for(int i = 0; i < array.length; i++){
            int smallestNumberIndex = i;
            for(int j = i; j < array.length; j++){
                if(array[j] < array[smallestNumberIndex]){
                    smallestNumberIndex = j;
                }
            }

            System.out.println();
            int temporary = array[i];
            array[i] = array[smallestNumberIndex];
            array[smallestNumberIndex] = temporary;
        }

        return array;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        int[] sortedArray = selectionSort.selectionSort(array);

        for(int i = 0; i < sortedArray.length; i++){
            System.out.println(sortedArray[i] + ", ");
        }
    }
}
