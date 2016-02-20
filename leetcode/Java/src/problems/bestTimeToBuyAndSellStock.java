package problems;

/**
 * Created by Martin on 20/02/2016.
 */
public class bestTimeToBuyAndSellStock {
    /**
     * Say you have an array for which the ith element is
     * the price of a given stock on day i.
     * If you were only permitted to complete at most one transaction
     * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     */

    public static int maxProfit(int[] prices) {
//        if (prices == null || prices.length < 2) {
//            return 0;
//        }
//
//        int profit = Integer.MIN_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < prices.length; j++) {
//                if (profit < prices[j] - prices[i]) {
//                    profit = prices[j] - prices[i];
//                }
//            }
//        }
//        return profit;
        int profit = 0;
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minElement);
            minElement = Math.min(minElement, prices[i]);
        }
        return profit;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] test = {11, 4, 5, 10, 12};
        System.out.println(maxProfit(test));
    }
}
