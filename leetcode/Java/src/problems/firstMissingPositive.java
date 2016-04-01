package problems;

/**
 * Created by Martin on 01/04/2016.
 */
public class firstMissingPositive {
    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * @param nums
     * @return
     */

    public static int firstMissingPositive(int[] nums) {
//        bucket sort.
//        int count = 0;
//        int sum = 0;
//        for (int i : nums) {
//            if (i > 0) {
//                count++;
//            }
//        }
//        for (int i = 1; i <= count + 1; i++) {
//            sum += i;
//        }
//        for (int i : nums) {
//            if (i > 0) {
//                sum -= i;
//            }
//        }
//        return sum;
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i+1)) {
                int tmp = nums[nums[i]-1];
                if (tmp == nums[i]) {
                    break;//duplicate issue
                }
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1,2,0};
        int[] temp1 = {3,4,-1,1};
        System.out.println(firstMissingPositive(test));
        System.out.println(firstMissingPositive(temp1));
    }

}
