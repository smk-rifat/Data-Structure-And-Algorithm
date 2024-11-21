package DailyChallenge.DP.BestTimeToBuyAndSellStocks_III.Memoization;

class Solution {
    Integer[][][] memo;
    int n;

    public int maxProfit(int[] prices) {
        n = prices.length;
        memo = new Integer[n][2][2];
        return memoization(prices, 0, 1, 2);
    }

    public int memoization(int[] prices, int idx, int buy, int transaction) {
        if (transaction == 0 || idx == n)
            return 0;
        if (memo[idx][buy][transaction] != null)
            return memo[idx][buy][transaction];
        int profit = 0;
        if (buy == 1)
            profit = Math.max(-prices[idx] + memoization(prices, idx + 1, 0, transaction),
                    memoization(prices, idx + 1, 1, transaction));
        else 
            profit = Math.max(prices[idx] + memoization(prices, idx + 1, 1, transaction - 1),
                    memoization(prices, idx + 1, 0, transaction));
        
        memo[idx][buy][transaction] = profit;
        return memo[idx][buy][transaction];
    }
}
