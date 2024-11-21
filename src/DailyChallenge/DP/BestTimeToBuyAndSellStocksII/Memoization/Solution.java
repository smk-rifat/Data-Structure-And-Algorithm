package DailyChallenge.DP.BestTimeToBuyAndSellStocksII.Memoization;

class Solution {
    int n;
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        n = prices.length;
        memo = new Integer[n][2];
        return memoization(prices, 0, 1);
    }

    public int memoization(int[] price, int idx, int buy) {
        if (idx == n)
            return 0;
        if (memo[idx][buy] != null)
            return memo[idx][buy];

        int profit = 0;

        if (buy == 1)
            profit = Math.max(-price[idx] + memoization(price, idx + 1, 0), memoization(price, idx + 1, 1));
        else 
            profit = Math.max(price[idx] + memoization(price, idx + 1, 1), memoization(price, idx + 1, 0));
        memo[idx][buy] = profit;

        return memo[idx][buy];
    }
}
