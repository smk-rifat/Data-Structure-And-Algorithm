package DailyChallenge.DP.LongestIncreasingSubsequence.Tabulation;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx - 1; prev >= -1; prev--) {
                int len = 0;
                int notTake = dp[idx + 1][prev + 1];
                int take = 0;
                if (prev == -1 || nums[idx] > nums[prev]) {
                    take = 1 + dp[idx + 1][idx + 1];
                }
                len = Math.max(take, notTake);

                dp[idx][prev + 1] = len;
            }
        }
        return dp[0][0];
    }
}