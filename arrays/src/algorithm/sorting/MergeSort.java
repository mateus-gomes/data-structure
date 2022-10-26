package algorithm.sorting;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }

        int[] firstArray = Arrays.copyOfRange(array, 0, array.length/2);
        int[] secondArray = Arrays.copyOfRange(array, array.length/2, array.length);

        firstArray = mergeSort(firstArray);
        secondArray = mergeSort(secondArray);

        int[] mergedArray = mergeArray(firstArray, secondArray);

        return mergedArray;
    }

    private int[] mergeArray(int[] firstArray, int[] secondArray){
        int[] mergedArray = new int[firstArray.length + secondArray.length];
        int positionFirstArray = 0;
        int positionSecondArray = 0;
        int positionMergedArray = 0;

        //While the first and the second array are not empty
        while(firstArray.length > positionFirstArray && secondArray.length > positionSecondArray){
            if(firstArray[positionFirstArray] > secondArray[positionSecondArray]){
                mergedArray[positionMergedArray] = secondArray[positionSecondArray];
                positionSecondArray++;
            } else {
                mergedArray[positionMergedArray] = firstArray[positionFirstArray];
                positionFirstArray++;
            }

            positionMergedArray++;
        }

        boolean isFirstArrayEmpty = positionFirstArray == firstArray.length;
        if(isFirstArrayEmpty){
            //While the second is not empty
            while(secondArray.length > positionSecondArray){
                mergedArray[positionMergedArray] = secondArray[positionSecondArray];
                positionSecondArray++;
                positionMergedArray++;
            }

            return mergedArray;
        }

        boolean isSecondArrayEmpty = positionSecondArray == secondArray.length;
        if(isSecondArrayEmpty){
            //While the first is not empty
            while(firstArray.length > positionFirstArray){
                mergedArray[positionMergedArray] = firstArray[positionFirstArray];
                positionFirstArray++;
                positionMergedArray++;
            }

            return mergedArray;
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        int[] sortedArray = mergeSort.mergeSort(array);

        for(int i = 0; i < sortedArray.length; i++){
            System.out.println(sortedArray[i] + ", ");
        }
    }
}
