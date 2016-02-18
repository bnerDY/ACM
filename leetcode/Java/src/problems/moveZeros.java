package problems;

/**
 * Created by Martin on 12/02/2016.
 */
public class moveZeros {
    /**
     * Given an array nums, write a function to move all 0's to the end of
     * it while maintaining the relative order of the non-zero elements.
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
     * nums should be [1, 3, 12, 0, 0].
     */
    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos ++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {0, 1, 0, 3, 12};
        moveZeroes(test);

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
