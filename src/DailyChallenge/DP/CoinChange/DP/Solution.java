package DailyChallenge.DP.CoinChange.DP;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],amount+1);
            dp[i][0] = 0;
        }

        for (int c = 1; c <= n; c++) {
            for (int t = 1; t <= amount ; t++) {
                if (t >= coins[c-1]){
                    dp[c][t] = Math.min(dp[c-1][t], 1+ dp[c][t - coins[c-1]]);
                } else
                    dp[c][t] = dp[c-1][t];
            }
        }

        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {3};
        int amount = 0;
        Solution obj = new Solution();
        System.out.println(obj.coinChange(coins, amount));
    }
}
