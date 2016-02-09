/**
 * Created by Martin on 15/11/2015.
 */
public class lesson4 {
    /**
     * Lesson 4 Counting Elements
     *
     */

    /**
     * For example, you are given integer X = 5 and array A such that:
     * A[0] = 1
     * A[1] = 3
     * A[2] = 1
     * A[3] = 4
     * A[4] = 2
     * A[5] = 3
     * A[6] = 5
     * A[7] = 4
     * In second 6, a leaf falls into position 5.
     * This is the earliest time when leaves appear in every position across the river.
     */


    public static int frogRiverOne(int X, int[] A) {
        // write your code in Java SE 8
        for (int i = 0; i < A.length; i++) {
            if(X == A[i]){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[]forg = {1,3,1,4,2,3,5,4};
        System.out.println(frogRiverOne(5, forg));
    }
}
