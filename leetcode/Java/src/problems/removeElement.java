package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class removeElement {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        //problem 27
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
