package problems;

import java.util.HashMap;

/**
 * Created by Martin on 09/02/2016.
 */
public class twoSum {
//problem1

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2.
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p>
     * You may assume that each input would have exactly one solution.
     * <p>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */
    private static int[] twoSum(int[] numbers, int target) {
        // problem 1
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
