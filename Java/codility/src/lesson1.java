/**
 * Created by Martin on 15/11/2015.
 */
public class lesson1 {
    /**
     * Lesson1 Iteration
     * Binary Gap
     * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001
     * and so its longest binary gap is of length 5.
     * Assume that:
     * N is an integer within the range [1..2,147,483,647].
     */
    public static int binaryGap(int N) {
        int res = 0;
        int count = -1;
        int r;

        while (N > 0) {
            // get right most bit & shift right
            r = N & 1; //AND
            //System.out.println(r);
            //System.out.println(N);
            N = N >> 1;
            if (0 == r && count >= 0) {
                count++;
            }
            if (1 == r) {
                res = count > res ? count : res;
                count = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(1041));
    }
}
