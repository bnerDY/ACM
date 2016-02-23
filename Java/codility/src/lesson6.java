import java.util.Arrays;

/**
 * Created by Martin on 15/11/2015.
 */
public class lesson6 {
    //Sorting

    /**
     A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

     For example, array A such that:

     A[0] = -3
     A[1] = 1
     A[2] = 2
     A[3] = -2
     A[4] = 5
     A[5] = 6
     contains the following example triplets:

     (0, 1, 2), product is −3 * 1 * 2 = −6
     (1, 2, 4), product is 1 * 2 * 5 = 10
     (2, 4, 5), product is 2 * 5 * 6 = 60
     Your goal is to find the maximal product of any triplet.
     * @param A
     * @return
     */
    public static int maxProductofThree(int[] A) {
        Arrays.sort(A);
        int maxTriplet = 0;
        int N = A.length;

        //Check if first & second is negative. third is positive
        if (A[0] * A[1] > 0 && A[0] < 0) {
            if (A[0] * A[1] * A[N - 1] > A[N - 3] * A[N - 2] * A[N - 1]) {
                maxTriplet = A[0] * A[1] * A[N - 1];
            } else {
                maxTriplet = A[N - 3] * A[N - 2] * A[N - 1];
            }
        } else {
            maxTriplet = A[N - 3] * A[N - 2] * A[N - 1];
        }

        return maxTriplet;
    }



    public static void main(String[] args) {
        //Max product
        int[] temp = {-3, 1, 2, -2, 5, 6};
        int res = maxProductofThree(temp);
        System.out.println(res);
    }
}
