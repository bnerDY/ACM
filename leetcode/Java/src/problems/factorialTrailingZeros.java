package problems;

/**
 * Created by Martin on 10/02/2016.
 */
public class factorialTrailingZeros {
    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        //problem 172
        if (n / 5 < 5) {
            return n / 5;
        } else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
