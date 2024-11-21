package DailyChallenge.DP.BestTimeToBuyAndSellStockIV.BruteForce;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

class Solution {
    int n;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        return bruteForce(prices, 0, 1, k);
    }

    public int bruteForce(int[] prices, int idx, int buy, int k) {
        if (idx == n || k == 0)
            return 0;
        
        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-prices[idx] + bruteForce(prices, idx + 1, 0, k), bruteForce(prices, idx + 1, 1, k));
        } else {
            profit = Math.max(prices[idx] + bruteForce(prices, idx + 1, 1, k - 1), bruteForce(prices, idx + 1, 0, k));
        }

        return profit;
    }
}
