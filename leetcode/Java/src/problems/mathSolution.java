package problems;

/**
 * Created by Martin on 15/06/2015.
 */
public class mathSolution {

    public static int titleToNumber(String s) {
        //problem 171
        if (s == null || s.isEmpty()) return 0; // invalid input
        char[] chars = s.toCharArray();
        int r = 0;
        for (char c : chars) {
            r = r * 26 + (c - 'A') + 1;
        }
        return r;
    }

    public static int trailingZeroes(int n) {
        //problem 172
        if (n / 5 < 5) {
            return n / 5;
        } else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }
}
