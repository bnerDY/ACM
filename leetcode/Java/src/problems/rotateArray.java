package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class rotateArray {
    /**
     * Rotate an array of n elements to the right by k steps.
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     *
     Note:
     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        //problem 189
        int length = nums.length;
        k = k % length;
        if (length == 1) return;
        if (k == 0) return;
        reversal(nums, 0, length - k - 1);
        reversal(nums, length - k, length - 1);
        reversal(nums, 0, length - 1);
    }

    private static void reversal(int[] nums, int i, int j) {
        // problem 189
        int t = 0;
        while (i < j && i >= 0) {
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
