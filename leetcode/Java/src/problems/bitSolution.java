package problems;

/**
 * Created by Martin on 15/06/2015.
 */
public class bitSolution {

    public static int reverseBits(int n) {
        //problem 190
        int res = 0;
        int cnt = 32;
        while (cnt > 0) {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
            cnt--;
        }
        return res;
    }

    public static int hammingWeight(int n) {
        //problem 191
        int res = 0;
        while (0 != n) {
            n = n & (n - 1);
            ++res;
        }
        return res;
    }
}
