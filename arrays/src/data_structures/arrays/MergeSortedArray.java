package data_structures.arrays;

public class MergeSortedArray {

    private int[] mergeSortArrays(int[] arrayOne, int[] arrayTwo){
        int[] arrayMergedAndSorted = new int[arrayOne.length+arrayTwo.length];
        int counterArrayOne = 0;
        int counterArrayTwo = 0;

        for(int i = 0; i < arrayMergedAndSorted.length; i++){
            boolean isArray1EmptyAndArray2IsNotEmpty = counterArrayOne >= arrayOne.length && counterArrayTwo < arrayTwo.length;
            boolean isArrayTwoEmptyAndArrayOneIsNotEmpty = counterArrayTwo >= arrayTwo.length && counterArrayOne < arrayOne.length;

            if(isArray1EmptyAndArray2IsNotEmpty){
                arrayMergedAndSorted[i] = arrayTwo[counterArrayTwo];
                counterArrayTwo++;
            } else if(isArrayTwoEmptyAndArrayOneIsNotEmpty){
                arrayMergedAndSorted[i] = arrayOne[counterArrayOne];
                counterArrayOne++;
            } else {
                boolean isArrayOneItemLessThanArrayTwoItem = arrayOne[counterArrayOne] <= arrayTwo[counterArrayTwo];

                if(isArrayOneItemLessThanArrayTwoItem){
                    arrayMergedAndSorted[i] = arrayOne[counterArrayOne];
                    counterArrayOne++;
                }else{
                    arrayMergedAndSorted[i] = arrayTwo[counterArrayTwo];
                    counterArrayTwo++;
                }
            }

            System.out.print(arrayMergedAndSorted[i] + ", ");
        }

        return arrayMergedAndSorted;
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] arrayOne = new int[]{ 0, 3, 4, 31};
        int[] arrayTwo = new int[]{ 4, 6, 30};

        mergeSortedArray.mergeSortArrays(arrayOne, arrayTwo);
    }
}
