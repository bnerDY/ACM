package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class numberOf1Bits {
    /**
     * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
     * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        //problem 191
        int res = 0;
        while (0 != n) {
            n = n & (n - 1);
            ++res;
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
