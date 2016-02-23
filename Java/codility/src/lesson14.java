/**
 * Created by Martin on 15/11/2015.
 */
public class lesson14 {
    //Binary Search
    /**
     * The large sum is the maximal sum of any block.

     For example, you are given integers K = 3, M = 5 and array A such that:

     A[0] = 2
     A[1] = 1
     A[2] = 5
     A[3] = 1
     A[4] = 2
     A[5] = 2
     A[6] = 2
     The array can be divided, for example, into the following blocks:

     [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
     [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
     [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
     [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
     The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
     * @param K
     * @param M
     * @param A
     * @return
     */
    public static int minMaxDivision(int K, int M, int[] A){
        //Binary Search
        int left = 0, right = 0;
        for (int i : A) {
            right += i;
            left = Math.max(left, i);
        }
        for (;;) {
            int guess = (right + left) / 2;
            int sum = 0, nblock = 0;
            for (int i : A) {
                sum += i;
                if (sum > guess) {
                    nblock++;
                    sum = i;
                }
            }
            if (sum > 0) {
                nblock++;
            }
            if (nblock <= K) {
                right = guess - 1;
            } else {
                left = guess + 1;
            }
            if (right < left) {
                return left;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(minMaxDivision(3, 5, new int[] { 2, 1, 5, 1, 2, 2, 2, }));
    }
}
