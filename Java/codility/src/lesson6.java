import java.util.Arrays;

/**
 * Created by Martin on 15/11/2015.
 */
public class lesson6 {

    /**
     * Lesson 6 Sorting
     *
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
