package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 05/04/2016.
 */
public class threeSum {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int target = 0;


        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test));
    }
}
