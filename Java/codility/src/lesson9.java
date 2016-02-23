/**
 * Created by Martin on 15/11/2015.
 */
public class lesson9 {
    //Maximun slice problem.
    /**
     * A zero-indexed array A consisting of N integers is given.
     * It contains daily prices of a stock share for a period of N
     * consecutive days. If a single share was bought on day P and
     * sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such
     * transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P].
     * Otherwise, the transaction brings loss of A[P] − A[Q].
     * @param A
     * @return
     */
    public static int maxProfit(int[] A){
        // DP solution.
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            profit = Math.max(profit, A[i] - minElement);
            minElement = Math.min(minElement, A[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] test = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(maxProfit(test));
    }
}
