package DailyChallenge.DP.TargetSum.Approach_3;
// https://leetcode.com/problems/target-sum/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;

        int subSum = (sum + target) / 2;

        int[][] dp = new int[nums.length + 1][subSum + 1];

        // Initialize dp array
        dp[0][0] = 1;

        // Fill dp array
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= subSum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][subSum];
    }

}
