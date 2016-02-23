/**
 * Created by Martin on 23/02/2016.
 */
public class lesson17 {
    //Dynamic Programming.

    /**
     For example, given the following array:

     A[0] = 1
     A[1] = -2
     A[2] = 0
     A[3] = 9
     A[4] = -1
     A[5] = -2
     one possible game could be as follows:

     the pebble is on square number 0, which is marked;
     we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
     we throw 5; the pebble does not move, since there is no square number 8 on the board;
     we throw 2; the pebble moves to square number 5; we mark this square and the game ends.
     The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8.
     This is the maximal possible result that can be achieved on this board.
     * @param A
     * @return
     */
    public static int numberSolitaire(int[] A){
        int[] dp = new int[A.length];
        dp[0] = A[0];

        for (int i = 1; i < A.length; i++){
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < A.length; i++) {
            for (int k = 1; k <= 6 && i + k < A.length; k++) {
                dp[i + k] = Math.max(dp[i + k], dp[i] + A[i + k]);
            }
        }
        return dp[A.length - 1];
    }

    public static void main(String[] args) {
        int[] test = {1, -2, 0, 9, -1, -2};
        System.out.println(numberSolitaire(test));
    }
}
