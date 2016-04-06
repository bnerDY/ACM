package problems;

/**
 * Created by Martin on 05/04/2016.
 */
public class jumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     * For example:
     * A = [2,3,1,1,4], return true.
     * A = [3,2,1,0,4], return false.
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
//        if (nums.length <= 1)  67/72 solution.
//            return true;
//        int init = nums[0];
//        int length = nums.length - 1;
//        while (true) {
//            if (init < length) {
//                if (nums[init] == 0) {
//                    break;
//                } else {
//                    init += nums[init];
//                }
//            } else {
//                return true;
//            }
//        }
//        return false;

        if(nums.length <= 1)
            return true;

        int max = nums[0]; //max stands for the largest index that can be reached.

        for(int i=0; i<nums.length; i++){
            //if not enough to go to next
            if(max <= i && nums[i] == 0)
                return false;

            //update max
            if(i + nums[i] > max){
                max = i + nums[i];
            }

            //max is enough to reach the end
            if(max >= nums.length-1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {2, 3, 1, 1, 4};
        int[] B = {3, 2, 1, 0, 4};
        int[] C = {2, 5, 0, 0};
        System.out.println(canJump(A));
        System.out.println(canJump(B));
        System.out.println(canJump(C));
    }
}
