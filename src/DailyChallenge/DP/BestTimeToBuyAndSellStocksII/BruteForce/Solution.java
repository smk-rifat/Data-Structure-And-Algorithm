package DailyChallenge.DP.BestTimeToBuyAndSellStocksII.BruteForce;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        return helper(prices, 0, true);
    }

    public int helper(int[] prices, int idx, boolean buy) {
        if (idx == n)
            return 0;
        int profit = 0;
        if (buy) {
            profit = Math.max(-prices[idx] + helper(prices, idx + 1, false), helper(prices, idx + 1, true));
        } else {
            profit = Math.max(prices[idx] + helper(prices, idx + 1, true), helper(prices, idx + 1, false));
        }
        return profit;
    }
}
// BruteForce tries all the possible ways in recursive ways.
// Time Complexity: O(2^n);
// Space Complexity : O(N)