package DailyChallenge.DP.BestTimeToBuyAndSellStockIV.Tabulation;

class Solution {    
    public int maxProfit(int transaction, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][transaction + 1];

        for (int buy = 0; buy < 2; buy++) {
            for (int k = 0; k <= transaction; k++) {
                dp[n][buy][k] = 0;
            }
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int k = 1; k <= transaction; k++) {

                    int profit = 0;

                    if (buy == 1)
                        profit = Math.max(-prices[idx] + dp[idx + 1][0][k],
                                dp[idx + 1][1][k]);
                    else
                        profit = Math.max(prices[idx] + dp[idx + 1][1][k - 1],
                                dp[idx + 1][0][k]);
                    dp[idx][buy][k] = profit;
                }
            }
        }
        
        return dp[0][1][transaction];
    }
}
