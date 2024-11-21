package DailyChallenge.DP.CoinChangeII.Bottom_Up_2D;

class Solution {
    public int change(int amount, int[] coins) {
     int n = coins.length;
     int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= amount ; j++) {
                dp[i][j] = dp[i-1][j];

                int coin = coins[i-1];
                if (j >= coin){
                    dp[i][j] += dp[i][ j - coin];
                }
            }
        }
       return dp[n][amount];
    }
}