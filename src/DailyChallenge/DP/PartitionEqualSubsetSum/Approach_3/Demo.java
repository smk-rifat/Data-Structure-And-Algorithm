package DailyChallenge.DP.PartitionEqualSubsetSum.Approach_3;

import java.util.Arrays;

public class Demo {
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the total sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // A subset sum of 0 is always achievable (empty subset)
        }

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    // TC = O(n*sum), SC = O(sum)
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target];
        dp[0] = true;

        for (int no : nums) {
            for (int i = target; i >= no; i--) {
                if (dp[i - no] == true) {
                    if (i == target) return true;
                    dp[i] = true;
                }
            }
        }
        return false;
    }
}
