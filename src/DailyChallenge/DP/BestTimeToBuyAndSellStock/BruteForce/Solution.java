package DailyChallenge.DP.BestTimeToBuyAndSellStock.BruteForce;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int buy = prices[i];
                int sell = prices[j];
                if (sell - buy > 0) {
                    max = Math.max(max, (sell - buy));
                }
            }
        }

        return max;
    }
}
// Time complexity O(N^2), space constant;
