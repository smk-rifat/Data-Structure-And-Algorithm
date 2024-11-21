package DailyChallenge.DP.LongestIncreasingSubsequence.PrintLIS;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx - 1; prev >= -1; prev--) {
                int len = 0;
                int notTake = next[prev + 1];
                int take = 0;
                if (prev == -1 || nums[idx] > nums[prev]) {
                    take = 1 + next[idx + 1];
                }
                len = Math.max(take, notTake);

                cur[prev + 1] = len;
            }
            int[] temp = cur;
            cur = next;
            next = temp;
        }
        return next[0];
    }
}
