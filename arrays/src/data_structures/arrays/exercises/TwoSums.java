package data_structures.arrays.exercises;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        int[] arrayIndicesSum = new int[2];

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    boolean isNumberSum = nums[i] + nums[j] == target;
                    if (isNumberSum) {
                        arrayIndicesSum[0] = i;
                        arrayIndicesSum[1] = j;
                    }
                }
            }
        }

        return arrayIndicesSum;
    }

    public static void main(String[] args) {
            TwoSums twoSums = new TwoSums();
            int[] array = new int[]{2,7,11,15};

            int[] response = twoSums.twoSum(array, 9);

            for(int i = 0; i < response.length;i++){
                System.out.print(response[i] + " ");
            }
    }
}
