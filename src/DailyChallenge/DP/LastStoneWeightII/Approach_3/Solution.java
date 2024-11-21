package DailyChallenge.DP.LastStoneWeightII.Approach_3;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalweight = 0;
        for(int s : stones){
            totalweight += s;
        }
        int target = totalweight/2;
        int[][] dp = new int[stones.length +1][target +1];

        for (int i = 1; i <= stones.length ; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= stones[i-1]){
                    dp[i][j] = Math.max(dp[i - 1] [j], dp[i-1][j - stones[i-1]] + stones[i-1]);
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }
        int sum1 = dp[stones.length][target];
        int sum2 = totalweight - sum1;

        return Math.abs(sum1 - sum2);
    }
}
