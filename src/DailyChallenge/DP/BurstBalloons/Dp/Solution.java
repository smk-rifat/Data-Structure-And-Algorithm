package DailyChallenge.DP.BurstBalloons.Dp;

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] num){
        int n = num.length;
        int[][] dp = new int[n+2][n+2];
        int[] balloons = new int[n+2];
        balloons[0] = balloons[n+1] = 1;

        for (int i = 1; i <= n; i++) {
            balloons[i] = num[i-1];
        }
        
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n- len +1; left++) {
                int right = left + len -1;
                for (int i = left; i <= right; i++) {
                    int cost = balloons[left-1] * balloons[i] * balloons[right+1];
                    cost += dp[left][i-1] + dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right], cost);
                }
            }
        }
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[1][n];
    }
    public static void main(String[] args) {
        int[] balloons = {3,1,5,8};
        Solution obj = new Solution();
        System.out.println(obj.maxCoins(balloons));
    }
}
