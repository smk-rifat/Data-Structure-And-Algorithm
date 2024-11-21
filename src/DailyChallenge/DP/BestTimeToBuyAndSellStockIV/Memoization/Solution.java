package DailyChallenge.DP.BestTimeToBuyAndSellStockIV.Memoization;

class Solution {
    int n;
    Integer[][][] memo;

    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        memo = new Integer[n][2][k + 1];
        return memoization(prices, 0, 1, k);
    }

    public int memoization(int[] prices, int idx, int buy, int k) {
        if (idx == n || k == 0)
            return 0;
        if (memo[idx][buy][k] != null)
            return memo[idx][buy][k];
        
        int profit = 0;

        if (buy == 1)
            profit = Math.max(-prices[idx] + memoization(prices, idx + 1, 0, k), memoization(prices, idx + 1, 1, k));
        else 
            profit = Math.max(prices[idx] + memoization(prices, idx + 1, 1, k - 1), memoization(prices, idx + 1, 0, k));
        memo[idx][buy][k] = profit;

        return memo[idx][buy][k];
    }
}