package DailyChallenge.DP.MinimumDifficultyOfAJobSchedule.Dp;

class Solution {
    public int minDifficulty(int[] job, int d) {
        int n = job.length;
        if (d > n) {
            return -1;
        }
        int[][] dp = new int[n + 1][d + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = getDifficulty(job, i);
        }

        for (int days = 2; days <= d; days++) {
            
            for (int i = 0; i <= n - days; i++) {
                int maxD = Integer.MIN_VALUE;
                int result = Integer.MAX_VALUE;

                for (int j = i; j <= n - days; j++) {
                    maxD = Math.max(maxD, job[j]);
                    result = Math.min(maxD + dp[j + 1][days - 1], result);
                }
                dp[i][days] = result;
            }

        }
        
        return dp[0][d];
    }
    int getDifficulty(int[] job, int start) {
        int ans = Integer.MIN_VALUE;
        for (int i = start; i < job.length; i++) {
            ans = Math.max(ans, job[i]);
        }
        return ans;
    }
}
