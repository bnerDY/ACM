/**
 * Created by Martin on 15/11/2015.
 */
public class lesson3 {

    //Time Complexity.

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
    public static int frogJmp(int X, int Y, int D) {
        int temp = (Y - X) % D;
        int res;
        if (temp != 0) {
            res = (Y - X) / D + 1;
        } else {
            res = (Y - X) / D;
        }
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

    /**
     * PermMissingElem
     * For example, given array A such that:
     * A[0] = 2
     * A[1] = 3
     * A[2] = 1
     * A[3] = 5
     * the function should return 4, as it is the missing element.
     */
    public static int permMissingElem(int[] A){
        int N = A.length + 1;
        int total = N * (N + 1) / 2;
        for (int i : A) {
            total -= i;
        }
        return total;
    }

    public static void main(String[] args) {
        //Test for TapeEquilibrium.
        int[] list = {3, 1, 2, 4, 3};
        int[] test = {-1000, 1000};
        int tape = tapeEquilibrium(list);
        int test1 = tapeEquilibrium(test);
        System.out.println(test1);

        //Test for frogJump
        System.out.println(frogJmp(10, 85,30));

        int[] num = {1,2,3,5};
        System.out.println(permMissingElem(num));
    }
}
