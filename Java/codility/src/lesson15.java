/**
 * Created by Martin on 15/11/2015.
 */
public class lesson15 {
    //Caterpillar method.

    /**
     * For example, consider array A such that:

     A[0] = 10    A[1] = 2    A[2] = 5
     A[3] = 1     A[4] = 8    A[5] = 12
     There are four triangular triplets
     that can be constructed from elements of this array,
     namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
     * @param A
     * @return
     */
    public static int countTriangles(int[] A){
        //not the best solution. O(n^3)
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (A[i] + A[j] > A[k] && A[j] + A[k] > A[i] && A[i] + A[k] > A[j]){
                        res ++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {10, 2, 5, 1, 8, 12};
        System.out.println(countTriangles(test));
    }
}
