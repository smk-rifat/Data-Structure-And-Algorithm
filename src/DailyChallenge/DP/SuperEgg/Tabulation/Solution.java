package DailyChallenge.DP.SuperEgg.Tabulation;

class Solution {
    public int superEggDrop(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        for (int i = 1; i <= e; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        for (int i = 1; i <= f; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                int attempt = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int temp = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    attempt = Math.min(attempt, temp);
                }
                dp[i][j] = attempt;
            }
        }

        return dp[e][f];
    }
}
