/**
 * Created by Martin on 15/11/2015.
 */
public class lesson3 {

    /**
     *  Time Complexity.
     *  Lesson3.
     */

    /**
     * FrogJmp
     * Given three integers X, Y and D,
     * returns the minimal number of jumps from position X to a position equal to or greater than Y.
     *
     * For example, given:
     * X = 10
     * Y = 85
     * D = 30
     * the function should return 3, because the frog will be positioned as follows:
     * after the first jump, at position 10 + 30 = 40
     * after the second jump, at position 10 + 30 + 30 = 70
     * after the third jump, at position 10 + 30 + 30 + 30 = 100
     */
    public int frogJmp(int X, int Y, int D){
        int res = 0;
        return res;
    }

    /**
     * TapeEquilibrium
     *
     * Calculate the minimum difference among the list.
     * input [3,1,2,4,3]
     * output 1
     */
    public static int tapeEquilibrium(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;
        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }
        int minDif = Math.abs(leftSum - rightSum);
        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            minDif = Math.min(minDif, Math.abs(leftSum - rightSum));
        }
        return minDif;
    }


    public static void main(String[] args) {
        //Test for TapeEquilibrium.
        int[] list = {3, 1, 2, 4, 3};
        int[] test = {-1000, 1000};
        int tape = tapeEquilibrium(list);
        int test1 = tapeEquilibrium(test);
        System.out.println(test1);

    }
}
