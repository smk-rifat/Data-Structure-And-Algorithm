package DailyChallenge.DP.NumberOfLongestIncreasingSubsequence;

class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return 1;
            
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }

            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int countLIS = 0;

        for (int i = 0; i < n; i++) {
            if (maxLen == dp[i]) {
                countLIS += count[i];
            }
        }

        return countLIS;
    }
}
