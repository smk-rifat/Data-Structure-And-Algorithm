package DailyChallenge.DP.LongestIncreasingSubsequence.Memoization;

class Solution {
    int n;
    Integer[][] memo;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        memo = new Integer[n][n + 1];
        return Memoization(nums, 0, -1);
    }

    // Memoization approach to find the length of the longest increasing subsequence
    public int Memoization(int[] nums, int idx, int prev) {
        if (idx >= n)
            return 0;
        if (memo[idx][prev + 1] != null)
            return memo[idx][prev + 1];
        
        int len = 0;
        int notTake = Memoization(nums, idx + 1, prev);
        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + Memoization(nums, idx + 1, idx);
        }
        len = Math.max(take, notTake);

        memo[idx][prev + 1] = len;
        
        return memo[idx][prev + 1];
    }
}
