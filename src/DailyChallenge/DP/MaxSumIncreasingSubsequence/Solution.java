package DailyChallenge.DP.MaxSumIncreasingSubsequence;
// https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card 

class Solution {
    public int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] + arr[i] > dp[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}