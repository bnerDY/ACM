/**
 * Created by Martin on 15/11/2015.
 */
public class lesson1 {
    /**
     * Time Complexity.
     * Lesson1. Calculate the minimum difference among the list.
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
        int [] test = {-1000, 1000};
        int tape = tapeEquilibrium(list);
        int test1 = tapeEquilibrium(test);
        System.out.println(test1);

    }
}
