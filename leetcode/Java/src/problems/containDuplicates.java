package problems;

import java.util.HashSet;

/**
 * Created by Martin on 09/02/2016.
 */
public class containDuplicates {
    /**
     * Given an array of integers, find if the array contains any duplicates. Your function should return true
     * if any value appears at least twice in the array, and it should return false if every element is distinct.
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        //problem 217
        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
