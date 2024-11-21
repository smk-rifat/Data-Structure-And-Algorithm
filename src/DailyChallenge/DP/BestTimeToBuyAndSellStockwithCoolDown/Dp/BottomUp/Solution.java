package DailyChallenge.DP.BestTimeToBuyAndSellStockwithCoolDown.Dp.BottomUp;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1 || n == 0) return 0;
        int[][] dp = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        
        for (int i = n-1; i >= 0 ; i--) {

            dp[i][0] = Math.max(dp[i+1][1]- prices[i], dp[i+1][0]);
            dp[i][1] = Math.max(dp[Math.min(i + 2, n)][0] + prices[i], dp[i+1][1]);
        } 
        return dp[0][0];
    } 
}