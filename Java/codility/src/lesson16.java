/**
 * Created by Martin on 23/02/2016.
 */
public class lesson16 {
    // Greedy algorithm.

    /**
     For example, consider arrays A, B such that:
     A[0] = 1    B[0] = 5
     A[1] = 3    B[1] = 6
     A[2] = 7    B[2] = 8
     A[3] = 9    B[3] = 9
     A[4] = 9    B[4] = 10
     The segments are shown in the figure below.

     The size of a non-overlapping set containing a maximal number of segments is 3.
     For example, possible sets are {0, 2, 3}, {0, 2, 4}, {1, 2, 3} or {1, 2, 4}. There is no non-overlapping set with four segments.
     * @param A
     * @param B
     * @return
     */
    public static int maxNonoverlappingSegments(int[] A, int[] B) {
        int res = 0;
        int previous = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > previous) {
                res++;
                previous = B[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 7, 9, 9};
        int[] b = {5, 6, 8, 9, 10};

        System.out.println(maxNonoverlappingSegments(a,b));
    }

}
