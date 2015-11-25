package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Martin on 15/06/2015.
 */
public class arraySolution {

    public static int removeDuplicates(int[] A) {
        // problem 26
        if (A == null || A.length == 0)
            return 0;
        int index = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }

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


    public static int[] plusOne(int[] digits) {
        //problem 79
        int len = digits.length;
        boolean flag = true; // flag if the digit needs to be changed
        for (int i = len - 1; i >= 0; i--) {
            if (flag) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    flag = false;
                }

                if (i == 0 && digits[i] == 0) {
                    int[] y = new int[len + 1];
                    y[0] = 1;
                    for (int j = 1; j <= len; j++) {
                        y[j] = digits[j - 1];
                    }
                    digits = y;
                }
            }
        }
        return digits;
    }


    public static List<List<Integer>> generate(int numRows) {
        //problem 118
        List<List<Integer>> res = new ArrayList<List<Integer>>(numRows);

        return res;
    }

//    public static boolean exist(char[][] board, String word) {
//        //problem 79 TODO
//        for(int i = 0; i<board.length; i++){
//            for (int j = 0; j <board[i].length ; j++) {
//                for (int k = 0; k <word.length() ; k++) {
//                    char item = word.charAt(k);
//                    if (item != board[i][j]) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (word.length() == 1
                            || search(board, i, j, word.substring(1), visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    static boolean search(char[][] board, int i, int j, String word,
                          boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int k = 0; k < direction.length; k++) {
            int ii = i + direction[k][0];
            int jj = j + direction[k][1];
            if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[i].length
                    && board[ii][jj] == word.charAt(0)
                    && visited[ii][jj] == false) {
                visited[ii][jj] = true;
                if (word.length() == 1
                        || search(board, ii, jj, word.substring(1), visited)) {
                    return true;
                }
                visited[ii][jj] = false;
            }
        }
        return false;
    }

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
}
