package data_structures.arrays.exercises;

public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i >= nums.length-1){
                break;
            }

            if(nums[i] == 0){
                if(nums[i+1] == 0){
                    int counter = 1;
                    boolean isNextZero = true;

                    while(isNextZero){
                        if(nums.length-1 >= i+counter){
                            if(nums[i+counter] == 0){
                                counter++;
                            }else{
                                nums[i] = nums[i+counter];
                                nums[i+counter] = 0;
                                isNextZero = false;
                            }
                        }else{
                            isNextZero = false;
                        }
                    }
                } else {
                    nums[i] = nums[i+1];
                    nums[i+1] = 0;
                }
            }
        }

        return nums;
    }

    //LeetCode solution
    public int[] moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] array = new int[]{1,0,0,12,3,0};

//        int[] response = moveZeroes.moveZeroes(array);
        int[] response2 = moveZeroes.moveZeroes2(array);

        for(int i = 0; i < response2.length;i++){
            System.out.print(response2[i] + " ");
        }
    }
}
