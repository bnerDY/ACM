package problems;

/**
 * Created by Martin on 09/02/2016.
 */
public class reverseBits {
    /**
     * Reverse bits of a given 32 bits unsigned integer.
     * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
     * return 964176192 (represented in binary as 00111001011110000010100101000000).
     * @param n
     * @return
     */
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

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
