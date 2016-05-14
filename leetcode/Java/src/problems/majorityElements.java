package problems;

import java.util.Arrays;

/**
 * Created by Martin on 14/05/2016.
 */
public class majorityElements {
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

     You may assume that the array is non-empty and the majority element always exist in the array.
     * @param nums
     * @return
     */

    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        int init = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == init){
                count += 1;
                if(count > nums.length/2) return nums[i];
            }else{
                count = 1;
                init = nums[i];
            }
        }
        return 0;
    }
}
